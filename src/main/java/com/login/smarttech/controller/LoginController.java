package com.login.smarttech.controller;


import com.login.smarttech.Dto.UserDto;
import com.login.smarttech.entity.UserInformation;
import com.login.smarttech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class LoginController {
    @Autowired
    private UserService service;
   @Autowired
   private BCryptPasswordEncoder passwordEncoder;
    @PostMapping("/enrollment")
    public void enrollment(@RequestBody UserInformation user)
    {
        String password=user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        user.setAccessApplicable(true);
        service.saveEnrollmentDetails(user);
    }

    @GetMapping("/admin")
    public String admin()
    {
        return "admin";
    }
    @GetMapping("/user")
    public String user()
    {
        return "user";
    }
    @PutMapping("/update/enrollment")
    public void update(@RequestBody UserDto details)
    {
     UserDto user=new UserDto();
     user.onCreate();
     service.updateAccessType(details.getUserName(), details.getNewAccessType(),user.getEditTimestamp());
    }
    @DeleteMapping("/enrollment/delete")
    public ResponseEntity<?> delete(@RequestBody UserDto login)
    {
        Optional<UserInformation> information=service.findByUsername(login.getUserName());


        if(information.isPresent())
        {
            Integer num= service.updateAccessApplicable(login.getUserName(),false);
            return ResponseEntity.ok(Map.of("message","user deleted"));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please enter the correct username");

    }

}
