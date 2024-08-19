package spring.practice.fullStack.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.practice.fullStack.model.Events;
import spring.practice.fullStack.service.EventServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventServiceImpl eventService;

    @GetMapping
    public List<Events> getAllEvents(){

        return eventService.getAllEvents();
    }

    @PostMapping("/saveEvent/event")
    public void saveEvents(@RequestBody Events event){
        eventService.saveEvent(event);
    }
}
