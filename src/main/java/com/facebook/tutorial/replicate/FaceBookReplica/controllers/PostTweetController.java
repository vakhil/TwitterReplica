package com.facebook.tutorial.replicate.FaceBookReplica.controllers;

import com.facebook.tutorial.replicate.FaceBookReplica.model.Tweet;
import com.facebook.tutorial.replicate.FaceBookReplica.services.TimelineRendererService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class PostTweetController {

    @Autowired
    TimelineRendererService timelineRendererService;


    @PostMapping("/post/tweet")
    @ResponseBody
    public void persistTweeet(@RequestBody Tweet tweet, Principal principal){
        timelineRendererService.persistTweetInSystenm(tweet,principal);
    }
}
