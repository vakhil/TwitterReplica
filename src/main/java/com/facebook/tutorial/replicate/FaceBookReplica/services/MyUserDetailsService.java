package com.facebook.tutorial.replicate.FaceBookReplica.services;

import com.facebook.tutorial.replicate.FaceBookReplica.repository.UserRepository;
import com.facebook.tutorial.replicate.FaceBookReplica.model.MyUserDetails;
import com.facebook.tutorial.replicate.FaceBookReplica.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<user> user = userRepository.findByUserName(userName);
        if(user.isPresent())
            return new MyUserDetails(user.get());
        else
            throw new UsernameNotFoundException("User does not exist");
    }
}
