package com.joshuamatos.Crud2.employees;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/employees")
    public Optional<Employee> createAEmployeeWithJSONRequest(@RequestBody Employee employee,
                                                             @RequestParam(required = false) boolean sort) {
        return employeeService.createAEmployee(employee);
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> returnASingleEmployeeByPathVarId(@PathVariable Long id) {
        return employeeService.returnASingleEmployeeById(id);
    }

    @PatchMapping("/employees/{id}")
    public Optional<Employee> patchASingleEmployeeByPathVarId(
            @PathVariable Long id,
            @RequestBody(required = false) Employee employee) {
        return employeeService.updateASingleEmployee(id, employee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteASingleEmployeeById(@PathVariable Long id) {
        return employeeService.deleteASingleEmployeeById(id);
    }

    @GetMapping("/employees")
    public List<Employee> returnAllEmployeesUsingList(@RequestParam(required = false) String filter,
                                                      @RequestParam(required = false) String sortDirection) {
        return employeeService.returnAListOfEmployees(filter, sortDirection);
    }
}