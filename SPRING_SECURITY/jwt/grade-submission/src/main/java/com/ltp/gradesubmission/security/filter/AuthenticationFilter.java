package com.ltp.gradesubmission.security.filter;

import java.io.IOException;
import java.util.Date;

import javax.management.RuntimeErrorException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ltp.gradesubmission.entity.User;
import com.ltp.gradesubmission.security.SecurityConstants;
import com.ltp.gradesubmission.security.manager.CustomAuthenticationManager;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter{
    
private CustomAuthenticationManager customAuthenticationManager;
@Override
public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
        throws AuthenticationException {

            try{
            User user  = new ObjectMapper().readValue(request.getInputStream(), User.class);
            
            Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
            return  customAuthenticationManager.authenticate(authentication);    
            }

            catch(IOException e){
                throw new RuntimeErrorException(null);
            } 
     }


@Override
protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
        AuthenticationException failed) throws IOException, ServletException {
            System.out.println("not found");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(failed.getMessage());    // <--
            response.getWriter().flush();
}


@Override
protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
        Authentication authResult) throws IOException, ServletException {
   System.out.println("Authentication Done !!!!!");

   String token = JWT.create()
                    .withSubject(authResult.getName())
                    .withExpiresAt(new Date(System.currentTimeMillis()+SecurityConstants.TOKEN_EXPIRATION*1000))
                    .sign(Algorithm.HMAC512(SecurityConstants.SECRET_KEY));
                            response.addHeader("Boss", "Bimurta Bismoy Sanchi");
                           response.addHeader(SecurityConstants.AUTHORIZATION, SecurityConstants.BEARER+token);             
}



}
