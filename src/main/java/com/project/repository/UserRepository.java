package com.project.repository;

import com.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
//we need to pass in two things we need to pass in the object or the class
//User is the object that we wanna manage. Long -> we specify the type of the primary key
public interface UserRepository extends JpaRepository<User, Long> {

    //findUserByUserName-> JPA gonna built query from this. select user by username
    User findUserByUsername(String username);
    User findUserByEmail(String email);


}
