package com.login.smarttech.service;

import com.login.smarttech.entity.UserInformation;
import com.login.smarttech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void saveEnrollmentDetails(UserInformation user)
    {
        repository.save(user);
    }

    public void updateAccessType(String name, String accessType, Date dt)
    {
        repository.updateNewAccessType(name,accessType,dt);
    }

    public Integer updateAccessApplicable(String userName,boolean access)
    {

       return repository.updateAccessApplicable(userName,access);
    }
    public Optional<UserInformation> findByUsername(String username)
    {
        return repository.findByUserName(username);
    }


}
