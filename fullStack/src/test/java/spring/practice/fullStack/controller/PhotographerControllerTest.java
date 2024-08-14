//package spring.practice.fullStack.controller;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultMatcher;
//import spring.practice.fullStack.model.Events;
//import spring.practice.fullStack.model.Photographer;
//import spring.practice.fullStack.service.PhotographerService;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
//
//import java.time.LocalDate;
//import java.util.Arrays;
//
//
//
//
//
//public class PhotographerControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private PhotographerService photographerService;
//
//    @Test
//    public void testGetAllPhotographers() throws Exception {
//        Events event = new Events("1", "Wedding", LocalDate.of(2024, 9, 10));
//        Photographer photographer = new Photographer("1", "John Doe", Arrays.asList(event));
//
//        Mockito.when(photographerService.getAllPhotographer()).thenReturn(Arrays.asList(photographer));
//
//        mockMvc.perform(get("/api/photographers"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].name").value("John Doe"))
//                .andExpect(jsonPath("$[0].events[0].name").value("Wedding"))
//                .andExpect(jsonPath("$[0].events[0].date").value("2024-09-10"));
//    }
//
//}
