/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.saleweb.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author duonghuuthanh
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 3L;
    public static final String USER = "ROLE_USER";
    public static final String ADMIN = "ROLE_ADMIN";
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "first_name")
    @Size(min = 1, max=45, message = "{user.firstName.error.sizeMsg}")
    private String firstName;
    
    @Column(name = "last_name")
    @Size(min = 1, max = 45, message = "{user.lastName.error.sizeMsg}")
    private String lastName;
    
    @Column(name = "email")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "{user.email.error.invalidMsg}")
    private String email;
    
    @Column(name = "phone")
    @Pattern(regexp = "\\d{10}", message = "{user.phone.error.invalidMsg}")
    private String phone;
    
    @Column(name = "active")
    private boolean active;
    
    @Column(name = "user_role")
    private String userRole;
    
    @Column(name = "username")
    @Size(min = 1, max = 45, message = "{user.username.error.sizeMsg}")
    private String username;
    
    @Column(name = "password")
    @NotEmpty(message = "{user.password.error.sizeMsg}")
    private String password;
    
    @Transient
    private String confirmPassword;
    
    {
        active = true;
        userRole = USER;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * @return the role
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * @param role the role to set
     */
    public void setUserRole(String role) {
        this.userRole = role;
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
