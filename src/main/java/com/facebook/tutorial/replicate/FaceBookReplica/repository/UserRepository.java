package com.facebook.tutorial.replicate.FaceBookReplica.repository;

import com.facebook.tutorial.replicate.FaceBookReplica.model.user;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<user,String>{
    Optional<user> findByUserName(String userName);
}