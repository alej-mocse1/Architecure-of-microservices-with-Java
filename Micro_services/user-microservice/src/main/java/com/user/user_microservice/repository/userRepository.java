package com.user.user_microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.user.user_microservice.entities.user;
import jakarta.transaction.TransactionScoped;

@TransactionScoped
@Repository
public interface userRepository extends JpaRepository<user, Long> {

}
