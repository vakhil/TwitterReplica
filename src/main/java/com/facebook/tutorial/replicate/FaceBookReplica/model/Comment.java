package com.facebook.tutorial.replicate.FaceBookReplica.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Comment  {
    private String commentor;
    private String comment;
    private int likes;

}
