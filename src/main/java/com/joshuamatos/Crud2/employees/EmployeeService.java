package com.joshuamatos.Crud2.employees;

import lombok.AllArgsConstructor;
import org.springframework.cglib.core.EmitUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    //Create
    public Optional<Employee> createAEmployee(Employee employee) {
        if(employee.name != null || employee.startDate != null) {
            employeeRepository.save(employee);
            return Optional.of(employee);
        }
        else return Optional.empty();
    }


    //Read
    public Optional<Employee> returnASingleEmployeeById(Long id){
        if(employeeRepository.existsById(id)){
            return employeeRepository.findById(id);
        }
        else {
            return Optional.empty();
        }
    }

    //Update
    public Optional<Employee> updateASingleEmployee(Long id, Employee employee){
        if(employeeRepository.existsById(id)){
            Employee updateEmployee = employeeRepository.getById(id);

            if(employee.name != null && employee.name.length() > 0) {
                updateEmployee.setName(employee.getName());
            }

            if(employee.startDate != null) {
                updateEmployee.setStartDate(employee.getStartDate());
            }
            return  Optional.of(updateEmployee);
        }
        else {
            return Optional.empty();
        }
    }

    //Delete
    public String deleteASingleEmployeeById(Long id) {
        if(employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return  "Employee deleted. Count:" + employeeRepository.count();
        } else {
            return "Employee does not exist.";
        }
    }

    //List
    public List<Employee> returnAListOfEmployees() {
        return employeeRepository.findAll();
    }

}