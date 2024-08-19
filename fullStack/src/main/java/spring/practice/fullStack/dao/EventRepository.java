package spring.practice.fullStack.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.practice.fullStack.model.Events;

import java.util.List;

public interface EventRepository extends JpaRepository<Events, String> {

}
