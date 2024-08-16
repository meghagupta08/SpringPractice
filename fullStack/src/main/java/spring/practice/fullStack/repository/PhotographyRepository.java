package spring.practice.fullStack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.practice.fullStack.model.Events;
import spring.practice.fullStack.model.Photographer;

import java.util.List;

@Repository
public interface PhotographyRepository extends JpaRepository<Events, String>{

    List<Photographer> findAll();

}
