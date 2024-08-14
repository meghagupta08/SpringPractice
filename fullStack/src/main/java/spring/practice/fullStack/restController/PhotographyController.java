package spring.practice.fullStack.restController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.practice.fullStack.model.Photographer;
import spring.practice.fullStack.service.PhotographerService;

import java.util.List;

@RestController
@RequestMapping("/api/photographers")
public class PhotographyController {

    @Autowired
    private PhotographerService photographerService;

    @GetMapping
    public List<Photographer> getAllPhotographers() {
        return photographerService.getAllPhotographer();
    }
}
