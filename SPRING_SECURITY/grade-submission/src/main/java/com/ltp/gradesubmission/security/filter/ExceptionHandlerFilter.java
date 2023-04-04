package com.ltp.gradesubmission.security.filter;

import java.io.IOException;

import javax.management.RuntimeErrorException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.ltp.gradesubmission.exception.EntityNotFoundException;

public class ExceptionHandlerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        try{
            filterChain.doFilter(request, response);
        }
        catch(EntityNotFoundException e){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("User Name not found");
            response.getWriter().flush();

        }
        catch(RuntimeException e){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }
    
    
}
