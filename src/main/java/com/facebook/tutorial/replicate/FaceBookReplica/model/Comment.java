package com.facebook.tutorial.replicate.FaceBookReplica.model;

import lombok.Data;

@Data
public class Comment {
    private String commentor;
    private String comment;
    private int likes;

}
