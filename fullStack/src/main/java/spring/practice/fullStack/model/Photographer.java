package spring.practice.fullStack.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "photographer")
public class Photographer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "photographer_event",
            joinColumns = @JoinColumn(name = "photographer_Id",referencedColumnName = "id"),
            inverseJoinColumns =  @JoinColumn(name = "event_id", referencedColumnName = "ID")
    )
    private List<Events> events;

    public Photographer(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
