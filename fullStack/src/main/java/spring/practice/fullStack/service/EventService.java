package spring.practice.fullStack.service;


import spring.practice.fullStack.model.Events;
import java.util.List;

public interface EventService {
    List<Events> getAllEvents();
    Events saveEvent(Events events);

}
