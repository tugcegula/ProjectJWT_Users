package com.project.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity//JPA entity
//convert this variables into a table in a database
public class User implements Serializable {//because we transfer this datas to db????
    @Id// for marking the private user id as the primary key
    @GeneratedValue(strategy = GenerationType.AUTO)//???????????
    @Column(nullable = false,updatable = false)
    private long id;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    private String[] roles; //User,Admin
    private String[] authorities;
    private boolean isActive;
    private boolean isNotLocked;

    //    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "USER_ROLES",
//            joinColumns = {
//                    @JoinColumn(name = "USER_ID")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "ROLE_ID") })
    // private Set<Role> roles;




    public User(long id, String name, String surname, String username, String email, String password, String[] roles, String[] authorities, boolean isActive, boolean isNotLocked) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.authorities = authorities;
        this.isActive = isActive;
        this.isNotLocked = isNotLocked;
    }

    public User() {
    }//the default constructer so that we can create a null objectd

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }


    public String[] getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String[] authorities) {
        this.authorities = authorities;
    }


    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isNotLocked() {
        return isNotLocked;
    }

    public void setNotLocked(boolean notLocked) {
        isNotLocked = notLocked;
    }

}
