package com.facebook.tutorial.replicate.FaceBookReplica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class FaceBookReplicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FaceBookReplicaApplication.class, args);
	}

}
