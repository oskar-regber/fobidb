package org.fobidb.fachbereiche;

import jakarta.persistence.*;

@Entity
@Table(name = "fachbereiche")
public class Fachbereich {
    @Id
    @Column(name = "FB_Name")
    public String Fachbereich_Name;
    @Column(name = "FB_Leiter")
    public String Fachbereich_Leiter;

    public Fachbereich() {
    }

    public Fachbereich(String Fachbereich_Name, String Fachbereich_Leiter) {
        this.Fachbereich_Name = Fachbereich_Name;
        this.Fachbereich_Leiter = Fachbereich_Leiter;
    }


    public String getFachbereich_Name() {
        return Fachbereich_Name;
    }


    public String getFachbereich_Leiter() {
        return Fachbereich_Leiter;
    }

    public void setFachbereich_Leiter(String fachbereich_Leiter) {
        Fachbereich_Leiter = fachbereich_Leiter;
    }


    public void setFachbereich_Name(String Fachbereich_Name) {
        this.Fachbereich_Name = Fachbereich_Name;
    }

    @Override
    public String toString() {
        return "Fachbereich{" +
                "Fachbereich_Name=" + Fachbereich_Name +
                '}';
    }
}
