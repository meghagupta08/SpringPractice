package spring.practice.fullStack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.practice.fullStack.dao.EventRepository;
import spring.practice.fullStack.dao.PhotographerRepository;
import spring.practice.fullStack.exception.PhotographerNotFoundException;
import spring.practice.fullStack.model.Events;
import spring.practice.fullStack.model.Photographer;

import java.util.List;
import java.util.Optional;

@Service
public class PhotographerServiceImpl implements PhotographerService{

    @Autowired
    PhotographerRepository photographerRepository;

    @Autowired
    EventRepository eventRepository;

    @Override
    public List<Photographer> getAllPhotoographer() {
        return photographerRepository.findAll();
    }

    @Override
    public Photographer savePhotograher(Photographer photgrapher) {
        try{
            return photographerRepository.save(photgrapher);
        }
        catch(PhotographerNotFoundException ex){
            throw new PhotographerNotFoundException("Not found");
        }

    }

    @Override
    public Photographer savePhotographerByEvents(List<String> eventsIds, Long id) {


        Optional<Photographer> photographer = photographerRepository.findById(id);
       if(photographer.isPresent()){
           Photographer currPhotographer = photographer.get();
           List<Events> currEvents = eventRepository.findAllById(eventsIds);
           currPhotographer.setEvents(currEvents);
           return photographerRepository.save(currPhotographer);
       }else{
           throw new PhotographerNotFoundException("Photographer with id " + id + " not found");
       }
    }
}
