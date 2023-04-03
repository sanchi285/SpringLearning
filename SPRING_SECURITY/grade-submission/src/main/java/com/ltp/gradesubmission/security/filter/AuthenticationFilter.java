package com.ltp.gradesubmission.security.filter;

import java.io.IOException;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ltp.gradesubmission.entity.User;

import org.springframework.security.core.*;


public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter{

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)

    {
        try{
            User user = new ObjectMapper().readValue(request.getInputStream(),User.class);
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());

        }
        catch(IOException e){
            throw new RuntimeException();
        }
        return super.attemptAuthentication(request, response);
    }
}
