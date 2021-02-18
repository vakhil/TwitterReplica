package com.facebook.tutorial.replicate.FaceBookReplica.services;

import com.facebook.tutorial.replicate.FaceBookReplica.model.*;
import com.facebook.tutorial.replicate.FaceBookReplica.repository.PostRepository;
import com.facebook.tutorial.replicate.FaceBookReplica.repository.UserRepository;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.*;

@Service
public class TimelineRendererService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public List getPostsFromFriendsTimeline(Principal principal, Model model){
        //Name and posts Mapping
        List<ProfilePictureMap> namePostMap = new ArrayList<>();
        Map<String,String> nameProfilePictureMap = new HashMap<>();

        //Get the list of all friends
        String currentPrincipalName = principal.getName();
        Optional<user> userDetails = userRepository.findByUserName(currentPrincipalName);
        if ( userDetails.isPresent()){
            //Fetch posts of each friend
            List<String> friends = userDetails.get().getFriends();



            Query query = new Query();
            query.addCriteria(Criteria.where("postCreator").in(friends));

            List<Posts> timelineRelevantPosts = mongoTemplate.find(query, Posts.class);
            for (Posts posts : timelineRelevantPosts){
                namePostMap.add(new ProfilePictureMap(posts.getPostCreator(),posts));
            }
            //Retireve profile Picture of each friend !!!
            for (Posts post : timelineRelevantPosts){
                Optional<user> friendProfile = userRepository.findByUserName(post.getPostCreator());
                if (friendProfile.isPresent()){
                    nameProfilePictureMap.put(friendProfile.get().getUserName(),friendProfile.get().getProfilePicture());
                }
                for (Comment comment : post.getComments()){
                    Optional<user> commentorProfile = userRepository.findByUserName(comment.getCommentor());
                    if(commentorProfile.isPresent()){
                        nameProfilePictureMap.put(commentorProfile.get().getUserName(),commentorProfile.get().getProfilePicture());
                    }
                }
            }
            model.addAttribute("presentProfileDP",userDetails.get().getProfilePicture());
            model.addAttribute("namePostMap",namePostMap);
            model.addAttribute("nameProfilePictureMap",nameProfilePictureMap);
            return timelineRelevantPosts;

        } else {
            throw new UsernameNotFoundException("User does not exist !!!");
        }



    }

    public void persistTweetInSystenm(Tweet tweet,Principal principal){
        Posts posts = new Posts();
        posts.setType(tweet.getType());
        posts.setMedia(tweet.getContent());
        posts.setPostCreator(principal.getName());
        postRepository.save(posts);
        return;
    }
}
