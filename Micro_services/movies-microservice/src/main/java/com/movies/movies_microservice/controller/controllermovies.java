package com.movies.movies_microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.movies.movies_microservice.entities.movie;
import com.movies.movies_microservice.services.serviceMovie;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/movies")
public class controllermovies {

    @Autowired
    serviceMovie serviceMovie;

    @GetMapping("/getMovieByID/{ID}")
    public ResponseEntity<?> allMovies(@PathVariable Long ID) {
        //TODO: process GET request       
        return serviceMovie.searchMovieByID(ID);

    }


    @PostMapping("/CreateMovie")
    public ResponseEntity<?> postMethodName(@RequestBody movie movie) {
        //TODO: process POST 
        return serviceMovie.createMovie(movie);

    }


    @PutMapping("/setMovieByID")
    public ResponseEntity<?> putMethodName( @RequestBody movie movie) {
        //TODO: process PUT request
        return serviceMovie.setMovieByID(movie);

    }


    @DeleteMapping("/deletemovie/{ID}")
    public ResponseEntity<?> deleteUser(@PathVariable Long ID){
        //TODO: process DELETE request
        return serviceMovie.deleteMovie(ID);

      }


    @GetMapping("/getMovieAndQualification/{ID}")
    public ResponseEntity<?> getMovieAndQualification(@PathVariable Long ID) {
        //TODO: process GET request       
        return serviceMovie.searchMovieAndQualificaions(ID);
  
    }
  

}
