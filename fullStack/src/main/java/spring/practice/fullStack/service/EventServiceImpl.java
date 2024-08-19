package spring.practice.fullStack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.practice.fullStack.dao.EventRepository;
import spring.practice.fullStack.model.Events;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Events> getAllEvents(){
        return eventRepository.findAll();
    }

    @Override
    public Events saveEvent(Events event) {
        return eventRepository.save(event);
    }

}
