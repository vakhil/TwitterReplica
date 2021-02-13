package com.facebook.tutorial.replicate.FaceBookReplica.services;

import com.facebook.tutorial.replicate.FaceBookReplica.model.Posts;
import com.facebook.tutorial.replicate.FaceBookReplica.model.user;
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

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TimelineRendererService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public List getPostsFromFriendsTimeline(Principal principal){
        //Get the list of all friends
        String currentPrincipalName = principal.getName();
        Optional<user> userDetails = userRepository.findByUserName(currentPrincipalName);
        if ( userDetails.isPresent()){
            //Fetch posts of each friend
            List<String> friends = userDetails.get().getFriends();


            Query query = new Query();
            query.addCriteria(Criteria.where("postCreator").in(friends));

            List<Posts> timelineRelevantPosts = mongoTemplate.find(query, Posts.class);

            return timelineRelevantPosts;

//            for (String friend: friends){
//                //Get all posts when postCommentor in {X,Y,Z} and order by timestamp !!!
//                //Get the posts of each friend !!!
//                Optional<List<Posts>> postsByFriend =  postRepository.findByPostCreator(friend);
//                if(postsByFriend.isPresent()){
//                    //Pass this to UI
//                }else {
//                    //throw a proper Exception !!
//                    continue;
//                }
//
//                //Pass the post information to UI
//            }
        } else {
            throw new UsernameNotFoundException("User does not exist !!!");
        }



    }
}
