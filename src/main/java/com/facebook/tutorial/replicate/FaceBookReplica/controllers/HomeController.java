package com.facebook.tutorial.replicate.FaceBookReplica.controllers;

import com.facebook.tutorial.replicate.FaceBookReplica.services.TimelineRendererService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class HomeController {
    @Autowired
    TimelineRendererService timelineRendererService;


    @GetMapping("/")
    public List homePage(Principal principal) {
        return timelineRendererService.getPostsFromFriendsTimeline(principal);
    }
}
