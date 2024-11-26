package com.user.user_microservice.services;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.user.user_microservice.entities.user;
import com.user.user_microservice.repository.userRepository;

@Service
public class serviceUser {


    @Autowired
    private userRepository userRepository;

        //GET
        public user getUserByID(Long id){
            return  userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product with ID: not found " + id));
        }


        //GET
        public ResponseEntity<?> searchUsereByID(Long id){
            try {
                
                user userFind = this.getUserByID(id);
                
                return ResponseEntity.ok(userFind);
    
            } catch (Exception e) {
                // TODO: handle exception
                return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(e.getMessage());
            }
        }


        //UPDATE
        public ResponseEntity<?> setUserByID(user user){
            try {
    
                user userFind = this.getUserByID(user.getId());

                userFind.setName(user.getName());
                userFind.setLastName(user.getLastName());
                userFind.setDni(user.getDni());
                userFind.setCountry(user.getCountry());


                userRepository.save(userFind);

                return ResponseEntity.ok(userFind);
    
            } catch (Exception e) {
                // TODO: handle exception
                return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(e.getMessage());
            }
        }


        //CREATE
        public ResponseEntity<?> createUser(user user){

            try {

                user newUser = new user();

                newUser.setName(user.getName());
                newUser.setLastName(user.getLastName());
                newUser.setDni(user.getDni());
                newUser.setCountry(user.getCountry());
 
                return ResponseEntity.ok(userRepository.save(newUser));
      
            } catch (Exception e) {
                // TODO: handle exception
                return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(e.getMessage());
            }

        }


        //DELETE
        public ResponseEntity<?> deleteUser(Long id){
            try {

                user userFind = this.getUserByID(id);
                System.err.println("id -->"+ id);

                userRepository.delete(userFind);
                return ResponseEntity.ok("User eliminated" );

            } catch (Exception e) {
                // TODO: handle exception
                return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(e.getMessage());
            }
        }


}
