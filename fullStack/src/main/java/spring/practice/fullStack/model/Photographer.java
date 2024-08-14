package spring.practice.fullStack.model;

import java.util.List;

public class Photographer {

        private String id;
        private  String name;
        private List<Events> events;

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
