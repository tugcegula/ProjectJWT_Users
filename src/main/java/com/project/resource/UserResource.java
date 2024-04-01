package com.project.resource;

import com.project.exception.ExceptionHandling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserResource extends ExceptionHandling {

    @GetMapping("/home")
    public String showUser(){
        return "application works";
    }
}
