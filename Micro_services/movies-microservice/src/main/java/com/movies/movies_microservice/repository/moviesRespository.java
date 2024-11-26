package com.movies.movies_microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.movies.movies_microservice.entities.movie;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface moviesRespository extends JpaRepository<movie,Long> {

}
