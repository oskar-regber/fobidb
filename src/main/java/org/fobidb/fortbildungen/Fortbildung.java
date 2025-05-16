package org.fobidb.fortbildungen;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.format.DateTimeFormatterBuilder;

@Entity
@Table(name = "fortbildungen")
public class Fortbildung{

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long Fortbildung_ID;

    public Fortbildung(String fortbildungstitel, String datum, String kursleiter, int dauer_min, String anbieter_Name) {
        Fortbildungstitel = fortbildungstitel;
        Datum = datum;
        Kursleiter = kursleiter;
        Dauer_min = dauer_min;
        Anbieter_Name = anbieter_Name;
    }

    public String Fortbildungstitel;
    public String  Datum;
    public String Kursleiter;
    public int Dauer_min;
    @JsonProperty("anbieter_name")
    public String Anbieter_Name;

    public String getAnbieter_Name() {
        return Anbieter_Name;
    }

    public void setAnbieter_Name(String anbieter_Name) {
        Anbieter_Name = anbieter_Name;
    }

    public int getDauer_min() {
        return Dauer_min;
    }

    public void setDauer_min(int dauer_min) {
        Dauer_min = dauer_min;
    }

    public String getKursleiter() {
        return Kursleiter;
    }

    public void setKursleiter(String kursleiter) {
        Kursleiter = kursleiter;
    }

    public String getDatum() {
        return Datum;
    }

    public void setDatum(String datum) {
        Datum = datum;
    }

    public String getFortbildungstitel() {
        return Fortbildungstitel;
    }

    public void setFortbildungstitel(String fortbildungstitel) {
        Fortbildungstitel = fortbildungstitel;
    }



    public Fortbildung(){}



    public void setFortbildung_ID(Long id) {
        this.Fortbildung_ID = Fortbildung_ID;
    }

    public Long getFortbildung_ID() {
        return Fortbildung_ID;
    }
}
