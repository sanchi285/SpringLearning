package com.ltp.contacts.Security;


import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.security.Security;
@AllArgsConstructor
@Configuration
public class SecurityConfig {

    private BCryptPasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
                http
                        .csrf().disable()
                        .authorizeRequests()
                        .antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                        .antMatchers(HttpMethod.POST).hasAnyRole("ADMIN","USER")
                        .antMatchers(HttpMethod.GET).permitAll()
                        .anyRequest().authenticated()
                        .and()
                        .httpBasic()
                        .and()
                        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                return http.build();
    }

    @Bean
    public UserDetailsService user(){
        UserDetails admin = User.builder()
                .username("sanchi")
                .password(passwordEncoder.encode("admin-pass"))
                .roles("ADMIN")
                .build();

        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder.encode("user-pass"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin,user);
    }

}
