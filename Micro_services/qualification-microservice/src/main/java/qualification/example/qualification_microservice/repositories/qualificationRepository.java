package qualification.example.qualification_microservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import qualification.example.qualification_microservice.entities.qualification;

@Transactional
@Repository
public interface qualificationRepository extends JpaRepository<qualification,Long> {

    List<qualification> findAllBymovieId(Long movieId);
    
}
