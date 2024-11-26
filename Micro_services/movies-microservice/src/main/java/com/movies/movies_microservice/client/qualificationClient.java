package com.movies.movies_microservice.client;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.movies.movies_microservice.Dto.qualificationDTO;


@FeignClient(name = "qualification-microservice" , url = "http://localhost:8070")
public interface qualificationClient {

    @GetMapping("/qualifications/getQualificationsbyMovie/{Id}")
    List<qualificationDTO> findAllQualificaionByMovie(@PathVariable Long Id);
    
}
