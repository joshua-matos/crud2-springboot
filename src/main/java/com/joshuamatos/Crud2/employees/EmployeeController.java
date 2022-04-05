package com.joshuamatos.Crud2.employees;

import com.joshuamatos.Crud2.books.Book;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/employees")
    public Optional<Employee> createAEmployeeWithJSONRequest(@RequestBody Employee employee){
        return employeeService.createAEmployee(employee);
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> returnASingleEmployeeByPathVarId(@PathVariable Long id){
        return employeeService.returnASingleEmployeeById(id);
    }

    @PatchMapping("/employees/{id}")
    public Optional<Employee> patchASingleEmployeeByPathVarId(
            @PathVariable Long id,
            @RequestBody Employee employee) {
        return employeeService.updateASingleEmployee(id, employee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteASingleEmployeeById(@PathVariable Long id){
        return employeeService.deleteASingleEmployeeById(id);
    }

    @GetMapping("/employees")
    public List<Employee> returnAllEmployeesUsingList() {
        return  employeeService.returnAListOfEmployees();
    }
}