package com.facebook.tutorial.replicate.FaceBookReplica.controllers;

import com.facebook.tutorial.replicate.FaceBookReplica.model.Posts;
import com.facebook.tutorial.replicate.FaceBookReplica.model.Tweet;
import com.facebook.tutorial.replicate.FaceBookReplica.services.TimelineRendererService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    TimelineRendererService timelineRendererService;


    @GetMapping("/")
    public String homePage(Principal principal, Model model) {
        List<Posts> newsFeedPosts =  timelineRendererService.getPostsFromFriendsTimeline(principal,model);
        model.addAttribute("timelinePosts",newsFeedPosts);
        return "index";
    }




}
