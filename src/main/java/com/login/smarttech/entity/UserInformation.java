package com.login.smarttech.entity;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
public class UserInformation {
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    private String firstName;
    private String lastName;
    @Column(unique = true)
    @NotNull
    private String userName;
    @NotNull
    private String password;
    private boolean accessApplicable;
    private String currentAccessType;
    private String newAccessType;
    @OneToMany(cascade= CascadeType.ALL,fetch= FetchType.EAGER)
    @JoinColumn
    private List<RoleInformation> roles;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAndTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date editTimestamp;
    @PrePersist
    private void onCreate()
    {

        dateAndTime=new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAccessApplicable() {
        return accessApplicable;
    }

    public void setAccessApplicable(boolean accessApplicable) {
        this.accessApplicable =accessApplicable;
    }

    public String getCurrentAccessType() {
        return currentAccessType;
    }

    public void setCurrentAccessType(String currentAccessType) {
        this.currentAccessType = currentAccessType;
    }

    public String getNewAccessType() {
        return newAccessType;
    }

    public void setNewAccessType(String newAccessType) {
        this.newAccessType = newAccessType;
    }

    public List<RoleInformation> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleInformation> roles) {
        this.roles = roles;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }


}
