package com.movies.movies_microservice.Dto;

public class qualificationDTO {

    private Long id;
    private String Name;
    private Long Points;
    private Long MovieId;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public Long getPoints() {
        return Points;
    }
    public void setPoints(Long points) {
        Points = points;
    }
    public Long getMovieId() {
        return MovieId;
    }
    public void setMovieId(Long movieId) {
        MovieId = movieId;
    }


}
