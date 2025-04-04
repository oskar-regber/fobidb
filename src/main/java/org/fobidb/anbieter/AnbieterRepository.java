package org.fobidb.anbieter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnbieterRepository extends JpaRepository<Anbieter, String> { // unser AnbieterrRepository erbt von JpaRepository, daher stehen viele Befehle zum manipulieren der Datenbank zur Verfügung

    //SELECT * FROM teacher WHERE email = ?
    @Query("SELECT a FROM Anbieter a WHERE a.Anbieter_Name = ?1")
    Optional<Anbieter> findByName(String Anbieter_name);
}
