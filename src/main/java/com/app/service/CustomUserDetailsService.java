package com.app.service;

import com.app.entity.Employee;
import com.app.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

@Configuration
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByUsername(username);

        if(employee != null){
            return new User(employee.getUsername(), employee.getPassword(), new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
