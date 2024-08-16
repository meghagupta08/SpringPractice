package spring.practice.fullStack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Photographer {
        @Id
        private String id;
        private  String name;
        @OneToMany
        private List<Events> events;

        public Photographer(){

        }
    public Photographer(String id, String name, List<Events> events) {
        this.id = id;
        this.name = name;
        this.events = events;
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

    public List<Events> getEvents() {
        return events;
    }

    public void setEvents(List<Events> events) {
        this.events = events;
    }
}
