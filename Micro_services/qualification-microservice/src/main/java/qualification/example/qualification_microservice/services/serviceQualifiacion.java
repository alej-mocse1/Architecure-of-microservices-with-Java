package qualification.example.qualification_microservice.services;

import java.util.List;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import qualification.example.qualification_microservice.entities.qualification;
import qualification.example.qualification_microservice.repositories.qualificationRepository;

@Service
public class serviceQualifiacion {

    @Autowired
    private qualificationRepository qualificationRepository;

    //GET
    public qualification getQualificationByID(Long id){

        return  qualificationRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Product with ID: not found " + id));

    }
    

    //GET
    public  ResponseEntity<?> searchQualification(Long id){

        try {

            qualification qualificationFind = this.getQualificationByID(id);
                       
            return  ResponseEntity.ok(qualificationFind);

        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(e.getMessage());

        }

    }

    //GET
    public  ResponseEntity<?> searchQualificationByMovie(Long id){

        try {

           List<qualification> qualificationsFind = qualificationRepository.findAllBymovieId(id);

           System.out.println("qualificationsFind --> " + qualificationsFind);
  
            return  ResponseEntity.ok(qualificationsFind);

        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(e.getMessage());

        }

    }
    

    //UPDATE
    public ResponseEntity<?> setQualificationById (qualification Qualification){

        try {

            // Long idSeach = Long.parseLong(Qualification.getId());
            qualification qualificationFind = this.getQualificationByID(Qualification.getId());
        
             qualificationFind.setMovieId(Qualification.getMovieId());
             qualificationFind.setName(Qualification.getName());
             qualificationFind.setPoints(Qualification.getPoints());
    

            qualificationRepository.save(qualificationFind);
    
            return ResponseEntity.ok(qualificationFind);           
        } catch (Exception e) {
            // TODO: handle exception
             return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(e.getMessage());
        }

    }

    //CREATE
    public ResponseEntity<?> createQualification(qualification Qualification){

        try {
            
            qualification newQualification = new qualification();

            newQualification.setMovieId(Qualification.getMovieId());
            newQualification.setName(Qualification.getName());
            newQualification.setPoints(Qualification.getPoints());

            qualificationRepository.save(newQualification);


            return ResponseEntity.ok(newQualification);

        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(e.getMessage());
        }

    }

    //DELETE
    public ResponseEntity<?> deleteQualification(Long id){

        try {
            
           qualification qualificationFind = this.getQualificationByID(id);

           qualificationRepository.delete(qualificationFind);
           return ResponseEntity.ok("Qualification eliminated");

        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(e.getMessage());
        }

    }


}
