package spring.practice.fullStack.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.practice.fullStack.model.Photographer;
import spring.practice.fullStack.service.PhotographerService;

import java.util.List;

@RestController
@RequestMapping("/api/photography")
public class PhotographerController {

    @Autowired
    private PhotographerService photographerService;

    @GetMapping("/getAllPhotographers")
    public List<Photographer> getAllPhotographer()
    {
        return photographerService.getAllPhotoographer();
    }

    @PostMapping("/savePhotographer/photographer")
    public Photographer savePhotographer(@RequestBody Photographer photographer){
        return photographerService.savePhotograher(photographer);
    }



    @PostMapping("/{photographerId}/events")
    public Photographer saveEventsForPhotographer(@PathVariable Long photographerId, @RequestBody List<String> eventIds) {
        return photographerService.savePhotographerByEvents(eventIds,photographerId);
    }

}
