package com.project.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class UserPrincipal implements UserDetails {//UserDetails implemented from springframework

    //following features added from UserDetails

    private User user;
    //this user defining allowing us to pass our user.java user information to Spring security
    public UserPrincipal(User user) {
        this.user = user;
    }


    //get user.java's authorities give them to spring security
    //then SS will know what this user is allowed to do

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return stream(this.user.getAuthorities()).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }
    //get users authorities and map them
    // authorities are String array
    //We take everyone of them and create a new object of GrantedAuthority class(SimpleGrantedAuthority)
    //then we collect them into a list of string.



    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
        //this must be true if the account is non-expired so it doesnt fail  when we try to log in
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.user.isNotLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.user.isActive();
    }
}
