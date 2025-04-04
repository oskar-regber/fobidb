package org.fobidb.fortbildungen;

import org.fobidb.teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FortbildungRepository extends JpaRepository<Fortbildung, Integer> { // unser TeacherRepository erbt von JpaRepository, daher stehen viele Befehle zum manipulieren der Datenbank zur Verfügung

    //SELECT * FROM teacher WHERE email = ?
    @Query("SELECT f FROM Fortbildung f WHERE f.Fortbildung_ID = ?1")
    Optional<Fortbildung> findByFobid_ID(int id);
}
