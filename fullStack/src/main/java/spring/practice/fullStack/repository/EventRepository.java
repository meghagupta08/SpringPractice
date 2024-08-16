package spring.practice.fullStack.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.practice.fullStack.model.Events;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Events, String> {

    List<Events> findAll();
}
