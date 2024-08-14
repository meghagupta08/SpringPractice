package spring.practice.fullStack.service;

import jdk.jfr.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.practice.fullStack.model.Events;
import spring.practice.fullStack.repository.EventRepository;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Events> getAllEvents(){
        return eventRepository.findAll();
    }

}
