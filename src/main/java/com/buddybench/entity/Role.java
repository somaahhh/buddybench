package com.buddybench.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")

    @NotBlank(message="Enter role name !!")
    private String roleName;

    @ManyToMany
    @JoinTable(name = "role_responsibility", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "resp_id"))
    private Set<Responsibilities> responsibility = new HashSet<>();

    private String createdAt;
    private String updatedAt;

    private String roleResponsibility;
    private boolean status;


    public void setRoleName(){

        this.roleName = roleName;
    }

    public Set<Responsibilities> getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(Set<Responsibilities> responsibility) {
        this.responsibility = responsibility;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getRoleResponsibility() {
        return roleResponsibility;
    }

    public void setRoleResponsibility(String roleResponsibility) {
        this.roleResponsibility = roleResponsibility;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleName='" + roleName + '\'' +
                ", responsibility=" + responsibility +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", roleResponsibility='" + roleResponsibility + '\'' +
                ", status=" + status +
                '}';
    }

    public String getRoleName() {
        return roleName;
    }
}
