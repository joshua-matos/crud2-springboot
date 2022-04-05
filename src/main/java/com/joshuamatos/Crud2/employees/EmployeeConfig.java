package com.joshuamatos.Crud2.employees;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.*;
import java.util.List;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunnerEmployee(EmployeeRepository employeeRepository){
        return args -> {
            Clock clock = Clock.fixed(Instant.parse("2014-12-22T10:15:30.00Z"), ZoneId.of("UTC"));
            String dateTimeExpected = "2014-12-22T10:15:30";
            LocalDateTime dateTime = LocalDateTime.now(clock);

            Employee employee1 = new Employee("Josh", dateTime);
            Employee employee2 = new Employee("Alice", dateTime);
            Employee employee3 = new Employee("Rock", dateTime);
            employeeRepository.saveAll(List.of(employee1, employee2, employee3));
        };
    }
}