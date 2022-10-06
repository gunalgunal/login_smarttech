package com.login.smarttech.Dto;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class UserDto {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private boolean accessApplicable;



    private String currentAccessType;
    private String newAccessType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date editTimestamp;
    @PrePersist
    public void onCreate()
    {

        editTimestamp=new Date();

    }
    public Date getEditTimestamp() {
        return editTimestamp;
    }

    public void setEditTimestamp(Date editTimestamp) {
        this.editTimestamp = editTimestamp;
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
        this.accessApplicable = accessApplicable;
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


}
