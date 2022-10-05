package com.login.smarttech.entity;

import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class PutDetails {
    private String userName;
    private String currentAccessType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date editTimestamp;
    @PrePersist
    private void onCreate()
    {

        editTimestamp=new Date();
    }

    public Date getEditTimestamp() {
        return editTimestamp;
    }

    public void setEditTimestamp(Date editTimestamp) {
        this.editTimestamp = editTimestamp;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    private String newAccessType;
}
