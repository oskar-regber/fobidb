package org.fobidb.fachbereiche;

import org.fobidb.fachbereiche.Fachbereich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FachbereichRepository extends JpaRepository<org.fobidb.fachbereiche.Fachbereich, String> { // unser FachbereichrRepository erbt von JpaRepository, daher stehen viele Befehle zum manipulieren der Datenbank zur Verfügung

    //SELECT * FROM teacher WHERE email = ?
    @Query("SELECT a FROM Fachbereich a WHERE a.Fachbereich_Name = ?1")
    Optional<org.fobidb.fachbereiche.Fachbereich> findByName(String Fachbereich_name);
}
