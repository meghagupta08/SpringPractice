package spring.practice.fullStack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jdk.jfr.Enabled;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Events {
    @Id
    private String id;
    private String name;
    private String date;

    @ManyToMany(mappedBy = "events")
    private List<Photographer> photographersList;

    public Events(String id, String name, String date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public Events() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
