package qualification.example.qualification_microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import qualification.example.qualification_microservice.entities.qualification;
import qualification.example.qualification_microservice.services.serviceQualifiacion;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@Controller
@RequestMapping("/qualifications")
public class controllerQualification {

    @Autowired
    serviceQualifiacion serviceQualifiacion;

    @GetMapping("/getQualifications/{ID}")
    public ResponseEntity<?> getQualifications(@PathVariable Long ID) {
       //TODO: process GET request
       return serviceQualifiacion.searchQualification(ID);

    }

    @GetMapping("/getQualificationsbyMovie/{ID}")
    public ResponseEntity<?> getQualificationsbyMovie(@PathVariable Long ID) {
       //TODO: process GET request
       System.out.println("ID -->" + ID);
       return serviceQualifiacion.searchQualificationByMovie(ID);

    }


    @PostMapping("/CreateQualifications")
    public ResponseEntity<?> CreateQualifications(@RequestBody qualification qualification) {
        //TODO: process POST request     
        return serviceQualifiacion.createQualification(qualification);

    }


    @PutMapping("/setQualifications")
    public  ResponseEntity<?>  setQualifications(@RequestBody qualification qualification) {
        //TODO: process PUT request
        return serviceQualifiacion.setQualificationById(qualification);
   
    }


    @DeleteMapping("/deleteQualifications/{ID}")
    public ResponseEntity<?> deleteUser(@PathVariable Long ID){
        //TODO: process DELETE request
        return serviceQualifiacion.deleteQualification(ID);

      }


}
