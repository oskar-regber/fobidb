/*package org.fobidb.fortbildungen;

import org.fobidb.teacher.Teacher;
import org.fobidb.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FortbildungService {

    private final FortbildungRepository fortbildungRepository;

    @Autowired
    public FortbildungService(FortbildungRepository fortbildungRepository) {
        this.fortbildungRepository = fortbildungRepository;
    }

    public List<Fortbildung> getFortbildungen() {
        return fortbildungRepository.findAll();
    }

    public void addNewTeacher(Fortbildung fortbildung) {
        Optional<Fortbildung> fortbildungOptional = fortbildungRepository.findByFobid_ID(fortbildung.getFortbildung_ID());
        if (fortbildungOptional.isPresent()) {
            throw new IllegalStateException("email already in use");
        }
        fortbildungRepository.save(fortbildung);
    }

    public void deleteTeacher(Long teacherId) {
        boolean exists = fortbildungRepository.existsById(teacherId);
        if (!exists) {
            throw new IllegalStateException("teacher with Id "+ teacherId + " does not exist");
        }
        fortbildungRepository.deleteById(teacherId);
    }
}
*/