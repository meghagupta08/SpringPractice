package spring.practice.fullStack.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.practice.fullStack.model.Photographer;

public interface PhotographerRepository extends JpaRepository<Photographer,Long> {
}
