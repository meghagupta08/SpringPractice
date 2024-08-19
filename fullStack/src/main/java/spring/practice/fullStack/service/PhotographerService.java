package spring.practice.fullStack.service;

import spring.practice.fullStack.model.Events;
import spring.practice.fullStack.model.Photographer;

import java.util.List;

public interface PhotographerService {

    List<Photographer> getAllPhotoographer();
    Photographer savePhotograher(Photographer photgrapher);

    Photographer savePhotographerByEvents(List<String> eventsIds, Long photographerId);

}
