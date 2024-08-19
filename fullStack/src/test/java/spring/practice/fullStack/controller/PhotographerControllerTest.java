package spring.practice.fullStack.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import spring.practice.fullStack.model.Event;
import spring.practice.fullStack.model.Photographer;
import spring.practice.fullStack.restController.PhotographerController;
import spring.practice.fullStack.service.PhotographerService;
import spring.practice.fullStack.service.PhotographerServiceImpl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class PhotographerControllerTest {


 @Mock
private PhotographerServiceImpl photographerServiceImpl;


 private MockMvc mockMvc;

 @InjectMocks
 private PhotographerController photographerController;

 @BeforeEach
    void setup(){
     MockitoAnnotations.openMocks(this);
     mockMvc = MockMvcBuilders.standaloneSetup(photographerController).build();
 }



    @Test
    void testGetAllPhotographers() throws Exception {
        Photographer photographer1 = new Photographer();
        photographer1.setId(1L);
        photographer1.setName("John Doe");

        Photographer photographer2 = new Photographer();
        photographer2.setId(2L);
        photographer2.setName("Jane Smith");

        List<Photographer> photographers = Arrays.asList(photographer1, photographer2);

        when(photographerServiceImpl.getAllPhotoographer()).thenReturn(photographers);

        mockMvc.perform(get("/api/photography/getAllPhotographers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("John Doe")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].name", is("Jane Smith")));

        verify(photographerServiceImpl, times(1)).getAllPhotoographer();
    }


}
