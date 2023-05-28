package com.ltp.gradesubmission.security.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.ltp.gradesubmission.exception.EntityNotFoundException;

public class ExceptionHandelerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        try{
            filterChain.doFilter(request, response);
        }

        catch(EntityNotFoundException en){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("Entity not found");    // <--
            response.getWriter().flush();
        }

        catch(RuntimeException e){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("BAD Request Dude");    // <--
            response.getWriter().flush();
        }
    }
    
}
