package com.project.service;


import com.project.exception.EmailExistException;
import com.project.exception.UserNotFoundException;
import com.project.exception.UsernameExistException;
import com.project.model.User;

import java.util.List;

//Controller is gonna call UserService and this service's return will call the repository
// JPA gonna access the DB and get the information that we want
public interface UserService {

    User register(String name, String surname, String username, String email) throws UserNotFoundException, EmailExistException, UsernameExistException;
    List<User> getUsers();
    User findUserByUsername(String username);
    User findUserByEmail(String email);

}
