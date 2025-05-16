/*
package org.fobidb.teacher;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

// Data Access LAYER *******************************************************


@Configuration // Diese Klasse wird als Konfigurationsklasse für Spring markiert. Sie enthält Beans, die von Spring verwaltet werden sollen.
public class TeacherConfig {

    @Bean // Diese Annotation sagt Spring, dass die Methode commandLineRunner ein Bean ist, welches beim Start der Anwendung ausgeführt werden soll.
    CommandLineRunner commandLineRunner(TeacherRepository repository) { //CommandLineRunnder: Funktionales Interface von Spring Boot. Es erlaubt die Ausführung von Code nach dem Start der Anwendung. Hier wird der übergebene Code also ausgeführt, sobald die Anwendung vollständig gestartet ist.
        return args -> { // Lambda-Ausdruck = kompakte Art, das Interface zu implementieren.
            // Prüfen, ob die Datenbank bereits Einträge enthält
            if (repository.count() == 0) {
                Teacher sb = new Teacher(
                        "Schubert",
                        "Simon",
                        "sb",
                        "simon.schubert@aloberlin.de",
                        45
                );
                Teacher pr = new Teacher(
                        "Pommer",
                        "Dennis",
                        "pr",
                        "dennis.pommer@aloberlin.de",
                        45
                );
                repository.saveAll(
                        List.of(sb, pr) // temporäre unveränderliche Liste, um die Objekte in der Datenbank zu speichern.
                );
            };
        };
    }
}*/
