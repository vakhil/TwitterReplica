package com.facebook.tutorial.replicate.FaceBookReplica.model;

import lombok.Data;

@Data
public class ProfilePictureMap {
    String name;
    Posts posts;

    public ProfilePictureMap(String postCreator, Posts posts) {
        this.name = postCreator;
        this.posts = posts;
    }
}

