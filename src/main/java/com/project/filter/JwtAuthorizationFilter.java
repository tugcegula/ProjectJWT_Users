package com.project.filter;

import com.project.constant.SecurityConstant;
import com.project.utility.JWTTokenProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//Whatever  is gonna happen into this class is gonna happen once
@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {
    private JWTTokenProvider jwtTokenProvider;

    public JwtAuthorizationFilter(JWTTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    // checking to make sure the token is valid,the user id is valid
    // then once we know we can verify these informations we'll set user as an authenticated user
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
      if(request.getMethod().equalsIgnoreCase(SecurityConstant.OPTIONS_HTTP_METHOD)){
          response.setStatus(HttpStatus.OK.value());
      }else{
          String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
          if(authorizationHeader == null || !authorizationHeader.startsWith(SecurityConstant.TOKEN_PREFIX)) {
              filterChain.doFilter(request, response);
              return;
          }
          String token = authorizationHeader.substring(SecurityConstant.TOKEN_PREFIX.length());
          String username = jwtTokenProvider.getSubject(token);

          if(jwtTokenProvider.isTokenValid(username, token) && SecurityContextHolder.getContext().getAuthentication() ==null){
              List<GrantedAuthority> authorities = jwtTokenProvider.getAuthorities(token);
              Authentication authentication = jwtTokenProvider.getAuthentication(username, authorities, request);
              SecurityContextHolder.getContext().setAuthentication(authentication);
          }else{
              SecurityContextHolder.clearContext();
          }
      }
      filterChain.doFilter(request,response);

    }
}
