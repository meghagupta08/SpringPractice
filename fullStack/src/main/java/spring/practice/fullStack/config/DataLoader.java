package spring.practice.fullStack.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import spring.practice.fullStack.model.Events;
import spring.practice.fullStack.model.Photographer;
import spring.practice.fullStack.service.EventService;
import spring.practice.fullStack.service.PhotographerService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Configuration
public class DataLoader {

    @Autowired
    private EventService eventService;

    @Autowired
    private PhotographerService photographerService;

    @PostConstruct
    public void loadData(){
        try {
            loadEvents();
            loadPhotographer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//
//    @Bean
//    public List<Photographer> loadPhotographer() throws IOException{
//        ObjectMapper objectMapper = new ObjectMapper();
//        InputStream inputStream = new ClassPathResource("photographers.json").getInputStream();
//        return objectMapper.readValue(inputStream, new TypeReference<List<Photographer>>() {
//        });
//    }

    public void loadEvents() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            InputStream inputStream = new ClassPathResource(("events.json")).getInputStream();
            List<Events> events = objectMapper.readValue(inputStream, new TypeReference<List<Events>>() {
            });

            for(Events event:events){
                eventService.saveEvent(event);
            }

        }catch (IOException ex){
            ex.printStackTrace();
        }

    }

    public void loadPhotographer() throws  IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            InputStream inputStream = new ClassPathResource(("photographers.json")).getInputStream();
            List<Photographer> photographers = objectMapper.readValue(inputStream, new TypeReference<List<Photographer>>() {
            });
            for(Photographer eachPhotographer: photographers){
                for(Events eachEvent:eachPhotographer.getEvents()){
                    eventService.saveEvent(eachEvent);
                }
                photographerService.savePhotograher(eachPhotographer);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }



}
