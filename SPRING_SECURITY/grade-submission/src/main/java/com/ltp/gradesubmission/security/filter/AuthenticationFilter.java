package com.ltp.gradesubmission.security.filter;

import java.io.IOException;
import java.util.Date;

import javax.naming.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ltp.gradesubmission.entity.User;
import com.ltp.gradesubmission.security.SecurityConstants;

import antlr.Token;
import lombok.AllArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.*;

@AllArgsConstructor
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter{

    private AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)

    {
        try{
            User user = new ObjectMapper().readValue(request.getInputStream(),User.class);
           
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
            Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
            return authenticationManager.authenticate(authentication);
        }
        catch(IOException e){
            throw new RuntimeException();
        }
      //  return super.attemptAuthentication(request, response);
    }

  

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
            org.springframework.security.core.AuthenticationException failed) throws IOException, ServletException {
                System.out.println("Voohooo Authentication worked");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write(failed.getMessage());
                response.getWriter().flush();
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        String token  = JWT.create()
                        .withSubject(authResult.getName())
                        .withExpiresAt(new Date(System.currentTimeMillis()+SecurityConstants.TOKEN_EXPIRATION))
                        .sign(Algorithm.HMAC512(SecurityConstants.SECRET_KEY)); 
                        
               response.addHeader(SecurityConstants.AUTHORIZATION, SecurityConstants.BEARER +token);         
        System.out.println("Wooho Authentication worked");
    }



    
}
