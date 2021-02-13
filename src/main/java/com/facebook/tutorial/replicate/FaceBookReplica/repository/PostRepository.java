package com.facebook.tutorial.replicate.FaceBookReplica.repository;

import com.facebook.tutorial.replicate.FaceBookReplica.model.Posts;
import com.facebook.tutorial.replicate.FaceBookReplica.model.user;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends MongoRepository<Posts,String> {
    Optional<List<Posts>> findByPostCreator(String name);
}
