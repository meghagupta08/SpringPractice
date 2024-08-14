package spring.practice.fullStack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.practice.fullStack.model.Photographer;
import spring.practice.fullStack.repository.PhotographyRepository;

import java.util.List;

@Service
public class PhotographerService {

    @Autowired
    private PhotographyRepository photographyRepository;

    public List<Photographer> getAllPhotographer(){
        return photographyRepository.findAll();
    }
}
