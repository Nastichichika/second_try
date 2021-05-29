package com.nastichichika.second_try.security;


import com.nastichichika.second_try.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        com.nastichichika.second_try.model.User user = userRepository.findByLogin(login);
        if(user == null){
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            return null;
        }

        return new User(user.getLogin(), user.getPassword(), new ArrayList<>());
    }

}
