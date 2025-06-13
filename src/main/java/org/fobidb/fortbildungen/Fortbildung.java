package org.fobidb.fortbildungen;

// Import der notwendigen Bibliotheken
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.format.DateTimeFormatterBuilder;

// Entitätsklasse für eine Fortbildung
@Entity
@Table(name = "fortbildungen")
public class Fortbildung {

    // Primärschlüssel für die Entität Fortbildung, der automatisch generiert wird
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Fortbildung_ID;

    // Konstruktor, der alle Felder der Fortbildung entgegennimmt
    public Fortbildung(String fortbildungstitel, String datum, String kursleiter, int dauer_min, String anbieter_Name) {
        Fortbildungstitel = fortbildungstitel;  // Setzt den Titel der Fortbildung
        Datum = datum;  // Setzt das Datum der Fortbildung
        Kursleiter = kursleiter;  // Setzt den Kursleiter
        Dauer_min = dauer_min;  // Setzt die Dauer in Minuten
        Anbieter_Name = anbieter_Name;  // Setzt den Namen des Anbieters
    }

    // Felder der Fortbildung
    public String Fortbildungstitel;  // Titel der Fortbildung
    public String Datum;  // Datum der Fortbildung
    public String Kursleiter;  // Kursleiter der Fortbildung
    public int Dauer_min;  // Dauer der Fortbildung in Minuten
    @JsonProperty("anbieter_name")
    public String Anbieter_Name;  // Name des Anbieters der Fortbildung

    // Getter- und Setter-Methoden für die Felder

    public String getAnbieter_Name() {
        return Anbieter_Name;  // Gibt den Anbieter-Namen zurück
    }

    public void setAnbieter_Name(String anbieter_Name) {
        Anbieter_Name = anbieter_Name;  // Setzt den Anbieter-Namen
    }

    public int getDauer_min() {
        return Dauer_min;  // Gibt die Dauer in Minuten zurück
    }

    public void setDauer_min(int dauer_min) {
        Dauer_min = dauer_min;  // Setzt die Dauer in Minuten
    }

    public String getKursleiter() {
        return Kursleiter;  // Gibt den Namen des Kursleiters zurück
    }

    public void setKursleiter(String kursleiter) {
        Kursleiter = kursleiter;  // Setzt den Namen des Kursleiters
    }

    public String getDatum() {
        return Datum;  // Gibt das Datum der Fortbildung zurück
    }

    public void setDatum(String datum) {
        Datum = datum;  // Setzt das Datum der Fortbildung
    }

    public String getFortbildungstitel() {
        return Fortbildungstitel;  // Gibt den Titel der Fortbildung zurück
    }

    public void setFortbildungstitel(String fortbildungstitel) {
        Fortbildungstitel = fortbildungstitel;  // Setzt den Titel der Fortbildung
    }

    // Standardkonstruktor (für JPA)
    public Fortbildung() {}

    // Getter- und Setter-Methoden für die Fortbildung_ID

    public void setFortbildung_ID(Long id) {
        this.Fortbildung_ID = Fortbildung_ID;  // Setzt die Fortbildung_ID
    }

    public Long getFortbildung_ID() {
        return Fortbildung_ID;  // Gibt die Fortbildung_ID zurück
    }
}
