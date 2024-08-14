package spring.practice.fullStack.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import spring.practice.fullStack.model.Events;

import java.util.List;

@Repository
public interface EventRepository {

    List<Events> findAll();
}
