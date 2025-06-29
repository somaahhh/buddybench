package com.buddybench.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="user_details")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String uuid;
    @NotEmpty(message = "*Please provide your first name !!")
    private String firstName;
    private String middleName;
    @NotEmpty(message = "*Please provide your last name !!")
    private String lastName;

    @NotEmpty(message = "*Please provide your username !!")
    private String userName;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_role", joinColumns = @JoinColumn(name = "id" ) , inverseJoinColumns = @JoinColumn(name="role_id") )
    private Set<Role> roles;
    @NotEmpty(message = "*Please provide your password !!")
    @JsonIgnore
    private String password;
    @NotEmpty(message = "*Please provide your confirm password !!")
    @JsonIgnore
    private String confirmPassword;

    @NotEmpty(message = "*Please provide your emailid !!")
    private String emailId;
    @JsonIgnore
    private String otp;
    private String loginTime;
    @JsonIgnore
    private boolean loginStatus;
    @JsonIgnore
    private String isVerified;
    private String userImage;
    @JsonIgnore
    private String createdAt;
    @JsonIgnore
    private String updated;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }


    public String getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(String isVerified) {
        this.isVerified = isVerified;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", emailId='" + emailId + '\'' +
                ", otp='" + otp + '\'' +
                ", loginTime='" + loginTime + '\'' +
                ", loginStatus='" + loginStatus + '\'' +
                ", isVerified='" + isVerified + '\'' +
                ", userImage='" + userImage + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updated='" + updated + '\'' +
                '}';
    }
}
