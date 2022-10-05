package com.login.smarttech.securityconfig;

import com.login.smarttech.entity.UserInformation;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {

    private UserInformation use;
    public MyUserDetails()
    {

    }
    public MyUserDetails(UserInformation use)
    {
        this.use=use;
    }

    public UserInformation getUse() {
        return use;
    }

    public void setUse(UserInformation use) {
        this.use = use;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       List<GrantedAuthority> list=new ArrayList<>();
   //     return use.getRole().stream().map(role -> new SimpleGrantedAuthority("ROLE_"+role)).collect(Collectors.toList());
          // list.add(new SimpleGrantedAuthority());
    //    });
        if(use.getNewAccessType()!=null)
         list.add(new SimpleGrantedAuthority("ROLE_"+use.getNewAccessType()));
       else
           list.add(new SimpleGrantedAuthority("ROLE_"+use.getCurrentAccessType()));
     //   list=Arrays.stream(use.getRole())
     //           .map(SimpleGrantedAuthority::new)
     //           .collect(Collectors.toList());
        //for(RoleForm role:use.getRole())
     // {
      //    System.out.println(role.getRoles());
         // list.add(new SimpleGrantedAuthority("ADMIN"));
      // }
        return list;
    }

    @Override
    public String getPassword() {

        return use.getPassword();
    }

    @Override
    public String getUsername() {

        return use.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override
    public boolean isEnabled() {

        return use.isAccessApplicable();
    }
}
