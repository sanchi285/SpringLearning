package com.ltp.gradesubmission.security.filter;

import java.io.IOException;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ltp.gradesubmission.entity.User;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter{
    
@Override
public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
        throws AuthenticationException {

            try{
            User user  = new ObjectMapper().readValue(request.getInputStream(), User.class);
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
            }

            catch(IOException e){
                throw new RuntimeErrorException(null);
            }
    // TODO Auto-generated method stub
    return super.attemptAuthentication(request, response);
}


}
