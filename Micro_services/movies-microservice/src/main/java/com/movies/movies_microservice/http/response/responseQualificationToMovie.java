package com.movies.movies_microservice.http.response;

import java.util.List;

import com.movies.movies_microservice.Dto.qualificationDTO;

public class responseQualificationToMovie {

    private Long id;
    private String Categoria;
    private String Description;
    private int Price;
    private String Name;
    private List<qualificationDTO> Qualifications;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCategoria() {
        return Categoria;
    }
    public void setCategoria(String categoria) {
        Categoria = categoria;
    }
    public String getDescpription() {
        return Description;
    }
    public void setDescpription(String description) {
        Description = description;
    }
    public int getPrice() {
        return Price;
    }
    public void setPrice(int price) {
        Price = price;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public List<qualificationDTO> getQualifications() {
        return Qualifications;
    }
    public void setQualifications(List<qualificationDTO> qualifications) {
        Qualifications = qualifications;
    }

    
}
