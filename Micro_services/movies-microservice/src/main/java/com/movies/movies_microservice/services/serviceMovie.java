package com.movies.movies_microservice.services;


import java.util.List;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.movies.movies_microservice.Dto.qualificationDTO;
import com.movies.movies_microservice.client.qualificationClient;
import com.movies.movies_microservice.entities.movie;
import com.movies.movies_microservice.http.response.responseQualificationToMovie;
import com.movies.movies_microservice.repository.moviesRespository;

@Service
public class serviceMovie {

    
    @Autowired
    private moviesRespository MoviesRespository;

    @Autowired
    private qualificationClient qualificationClient;


        //GET
        public movie getMovieByID(Long id){
            return  MoviesRespository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product with ID: not found " + id));
        }


        //GET
        public ResponseEntity<?> searchMovieByID(Long id){
            try {
                
                movie movieFind = this.getMovieByID(id);
                
                return ResponseEntity.ok(movieFind);
    
            } catch (Exception e) {
                // TODO: handle exception
                return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(e.getMessage());
            }
        }


        //UPDATE
        public ResponseEntity<?> setMovieByID(movie movie){
            try {
    
                movie movieFind = this.getMovieByID(movie.getId());

                movieFind.setCategoria(movie.getCategoria());
                movieFind.setDescpription(movie.getDescpription());
                movieFind.setName(movie.getName());
                movieFind.setPrice(movie.getPrice());


                MoviesRespository.save(movieFind);

                return ResponseEntity.ok(movieFind);
    
            } catch (Exception e) {
                // TODO: handle exception
                return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(e.getMessage());
            }
        }


        //CREATE
        public ResponseEntity<?> createMovie(movie movie){

            try {

                movie newMovie = new movie();

                newMovie.setCategoria(movie.getCategoria());
                newMovie.setDescpription(movie.getDescpription());
                newMovie.setName(movie.getName());
                newMovie.setPrice(movie.getPrice());
 
                return ResponseEntity.ok(MoviesRespository.save(newMovie));
      
            } catch (Exception e) {
                // TODO: handle exception
                return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(e.getMessage());
            }

        }


        //DELETE
        public ResponseEntity<?> deleteMovie(Long id){
            try {

                movie movieFind = this.getMovieByID(id);

                MoviesRespository.delete(movieFind);
                return ResponseEntity.ok("Movie eliminated");

            } catch (Exception e) {
                // TODO: handle exception
                return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(e.getMessage());
            }
        }

        
        //CONECTION WITH OTHER MICROSERVICES
        public ResponseEntity<?> searchMovieAndQualificaions(Long id){

            try {

                movie movieFind = this.getMovieByID(id);

                List<qualificationDTO> qualificationsDTO = qualificationClient.findAllQualificaionByMovie(id);

                responseQualificationToMovie response = new responseQualificationToMovie();

                response.setCategoria(movieFind.getCategoria());
                response.setPrice(movieFind.getPrice());
                response.setDescpription(movieFind.getDescpription());
                response.setId(movieFind.getId());
                response.setName(movieFind.getName());
                response.setQualifications(qualificationsDTO);
                
                return ResponseEntity.ok(response);

            } catch (Exception e) {
                // TODO: handle exception
                return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(e.getMessage());
            }

        }


}
