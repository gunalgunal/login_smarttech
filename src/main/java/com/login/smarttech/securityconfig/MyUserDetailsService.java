package com.login.smarttech.securityconfig;


import com.login.smarttech.entity.UserInformation;
import com.login.smarttech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<UserInformation> user= repository.findByUserName(username);

       if(!user.isPresent())
           throw new UsernameNotFoundException("Invalid credentials");

        return new MyUserDetails(user.get());
    }
}
