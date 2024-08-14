package spring.practice.fullStack.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import spring.practice.fullStack.model.Photographer;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    public List<Photographer> loadPhotographer() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = new ClassPathResource("photographers.json").getInputStream();
        return objectMapper.readValue(inputStream, new TypeReference<List<Photographer>>() {
        });
    }

}
