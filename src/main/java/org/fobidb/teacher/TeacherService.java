package org.fobidb.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


// Service LAYER *******************************************************

@Service
public class  TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    public void addNewTeacher(Teacher teacher) {
        Optional<Teacher> teacherOptional = teacherRepository.findByEmail(teacher.getEmail());
        if (teacherOptional.isPresent()) {
            throw new IllegalStateException("email already in use");
        }
        teacherRepository.save(teacher);
    }

    public void deleteTeacher(Long teacherId) {
        boolean exists = teacherRepository.existsById(teacherId);
        if (!exists) {
            throw new IllegalStateException("teacher with Id "+ teacherId + " does not exist");
        }
        teacherRepository.deleteById(teacherId);
    }

    @Transactional
    public void updateTeacher(Long teacherId,
                              String name,
                              String email) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new IllegalStateException("teacher with Id " + teacherId + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(teacher.getName(), name)) {
            teacher.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(email, teacher.getEmail())) {
            Optional<Teacher> teacherOptional = teacherRepository.findByEmail(email);

            if (teacherOptional.isPresent()) {
                throw new IllegalStateException("email already in use");
            }

            teacher.setEmail(email);
        }
    }
}
