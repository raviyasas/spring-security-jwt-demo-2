package com.app;

import com.app.entity.Employee;
import com.app.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringSecurityJwtDemo2Application  implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    private final PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtDemo2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Employee employee = new Employee();
        employee.setUsername("ryj");
        employee.setPassword(passwordEncoder.encode("123"));
        employeeRepository.save(employee);
    }
}
