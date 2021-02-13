package com.facebook.tutorial.replicate.FaceBookReplica.model;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "posts")
@Data
public class Posts {

    @Id
    public ObjectId _id;
    private String type;
    private String postCreator;
    private String media;
    private int likes;
    private List<Comment> comments;

    public String get_id() {
        return _id.toHexString();
    }
    public void set_id(ObjectId _id) {
        this._id = _id;
    }

}
