package com.login.smarttech.controller;


import com.login.smarttech.entity.Login;
import com.login.smarttech.entity.PutDetails;
import com.login.smarttech.entity.UserInformation;
import com.login.smarttech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public void update(@RequestBody PutDetails details)
    {

        service.updateAccessType(details.getUserName(), details.getNewAccessType(),details.getEditTimestamp());
    }
    @DeleteMapping("/enrollment/delete")
    public ResponseEntity<?> delete(@RequestBody Login login)
    {
        Optional<UserInformation> information=service.findByUsername(login.getUsername());


        if(information.isPresent())
        {
            Integer num= service.updateAccessApplicable(login.getUsername(),false);
            return ResponseEntity.ok(Map.of("message","user deleted"));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please enter the correct username");

    }

}
