package org.fobidb.anbieter;

import jakarta.persistence.*;

@Entity
@Table
public class Anbieter {
    @Id
    public String Anbieter_Name;

    public Anbieter() {
    }

    public Anbieter(String Anbieter_Name) {
        this.Anbieter_Name = Anbieter_Name;
    }


    public String getAnbieter_Name() {
        return Anbieter_Name;
    }

    public void setAnbieter_Name(String Anbieter_Name) {
        this.Anbieter_Name = Anbieter_Name;
    }

    @Override
    public String toString() {
        return "Anbieter{" +
                "Anbieter_Name=" + Anbieter_Name +
                '}';
    }
}
