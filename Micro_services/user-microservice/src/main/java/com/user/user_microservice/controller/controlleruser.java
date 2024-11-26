package com.user.user_microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.user.user_microservice.entities.user;
import com.user.user_microservice.services.serviceUser;


@Controller
@RequestMapping("/user")
public class controlleruser {

    @Autowired
    serviceUser serviceUser;

    @GetMapping("/searchUsereByID/{ID}")
    public ResponseEntity<?> searchUsereByID(@PathVariable Long ID) {
        //TODO: process GET request       
        return serviceUser.searchUsereByID(ID);

    }


    @PostMapping("/CreateMovie")
    public ResponseEntity<?> createUser(@RequestBody user user) {
        //TODO: process POST 
        return serviceUser.createUser(user);

    }


    @PutMapping("/setUserByID")
    public ResponseEntity<?> setUserByID( @RequestBody user user) {
        //TODO: process PUT request
        return serviceUser.setUserByID(user);

    }


    @DeleteMapping("/deleteUser/{ID}")
    public ResponseEntity<?> deleteUser(@PathVariable Long ID){
        //TODO: process DELETE request
        return serviceUser.deleteUser(ID);

      }  

}
