package com.login.smarttech.entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
@Entity
public class UserInformation {
    @Id
    @GeneratedValue
    private int id;
   @NotNull(message="firstname must not be null")
    private String firstName;
    private String lastName;
    @Column(unique = true)
    @NotNull(message="name must not be null")
    private String userName;
    @NotNull(message="password must not be null")
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
    public Date getEditTimestamp() {
        return editTimestamp;
    }

    public void setEditTimestamp(Date editTimestamp) {
        this.editTimestamp = editTimestamp;
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
