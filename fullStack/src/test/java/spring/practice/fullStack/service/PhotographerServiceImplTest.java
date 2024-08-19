package spring.practice.fullStack.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.practice.fullStack.dao.EventRepository;
import spring.practice.fullStack.dao.PhotographerRepository;
import spring.practice.fullStack.model.Events;
import spring.practice.fullStack.model.Photographer;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class PhotographerServiceImplTest {

    @Mock
    private PhotographerRepository photographerRepository;

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private PhotographerServiceImpl photographerServiceImpl;

    @BeforeEach
    public void initialize(){
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Return all photographers list")
    @Test
    public void getAllPhotographersTest(){

        Photographer photographer1 = new Photographer();
        photographer1.setId(1L);
        photographer1.setName("John Doe");

        Photographer photographer2 = new Photographer();
        photographer2.setId(2L);
        photographer2.setName("Jane Smith");


        List<Photographer> list = Arrays.asList(photographer1, photographer2);
        when(photographerRepository.findAll()).thenReturn(list);
        List<Photographer> listActual = photographerServiceImpl.getAllPhotoographer();
        assertEquals("John Doe", listActual.get(0).getName());
        assertEquals(2,listActual.size());

        verify(photographerRepository,times(1)).findAll();

    }

    @Test
    @DisplayName("save all photographers")
    public void savePhotographerTest(){

        Photographer photographer1 = new Photographer();
        photographer1.setId(1L);
        photographer1.setName("John Doe");

        when(photographerRepository.save(photographer1)).thenReturn(photographer1);

        assertEquals(photographer1, photographerServiceImpl.savePhotograher(photographer1));

        verify(photographerRepository,times(1)).save(any(Photographer.class));


    }

    @Test
    @DisplayName("Test for saving photographers and events")
    void savePhotographerByEventsTest(){
        Photographer photographer = new Photographer();
        photographer.setId(1L);
        photographer.setName("John Doe");

        Events event1 = new Events();
        event1.setId("1");
        event1.setName("Wedding");


        Events event2 = new Events();
        event2.setId("2");
        event2.setName("Corporate Event");


        when(photographerRepository.findById(1L)).thenReturn(Optional.of(photographer));
        when(eventRepository.findAllById(anyList())).thenReturn(Arrays.asList(event1, event2));
        when(photographerRepository.save(any(Photographer.class))).thenReturn(photographer);

        Photographer updatedPhotographer = photographerServiceImpl.savePhotographerByEvents( Arrays.asList("1L", "2L"),1L);


        assertNotNull(updatedPhotographer);
        assertEquals(2, updatedPhotographer.getEvents().size());

        verify(photographerRepository, times(1)).findById(1L);
        verify(eventRepository, times(1)).findAllById(anyList());
        verify(photographerRepository, times(1)).save(any(Photographer.class));


    }








}
