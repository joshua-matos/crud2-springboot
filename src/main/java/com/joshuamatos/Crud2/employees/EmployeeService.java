package com.joshuamatos.Crud2.employees;

import com.joshuamatos.Crud2.ApiEmployeeException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    //Create
    public Optional<Employee> createAEmployee(Employee employee) {
        if (employee.getName() != null && employee.getStartDate() != null) {
            employeeRepository.save(employee);
            return Optional.of(employee);
        } else return Optional.empty();
    }


    //Read
    public Optional<Employee> returnASingleEmployeeById(Long id) {
        return Optional.of(employeeRepository.getEmployeeById(id).orElseThrow(() -> new ApiEmployeeException("Employee not in database.")));
    }

    //Update
    public Optional<Employee> updateASingleEmployee(Long id, Employee employee) {
        if (!employeeRepository.existsById(id)) {
            throw new ApiEmployeeException("Employee does not exist.");
        } else {
            //Additional check - Employee is present, run updates and save
            Optional<Employee> updateEmployee = employeeRepository.getEmployeeById(id);
            if (updateEmployee.isPresent()) {
                if (employee.getName() != null && employee.getName().length() > 0) {
                    updateEmployee.get().setName(employee.getName());
                }

                if (employee.getStartDate() != null) {
                    updateEmployee.get().setStartDate(employee.getStartDate());
                }
                employeeRepository.save(updateEmployee.get());
            }
            return updateEmployee;
        }
    }

    //Delete
    public String deleteASingleEmployeeById(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return "Employee deleted. Count:" + employeeRepository.count();
        } else {
            return "Employee does not exist.";
        }
    }

    //List
    public List<Employee> returnAListOfEmployees(String filter, String sortDirection) {
//        Bonus: Add a filter based on optional Minimum and/or Maximum calories
//        Bonus 2: Add a sort parameter to allow for sorting by calories (both ASC and DESC)
        if (sortDirection == null) {
            sortDirection = "asc";
        }
        //if there is a filter, return a filtered name DESC or ASC
        if (filter != null && filter.length() > 0) {
            if (sortDirection.equals("desc")) {
                return employeeRepository.findByNameStartsWithOrderByNameDesc(filter);
            } else {
                return employeeRepository.findEmployeeByNameStartsWithOrderByNameAsc(filter);
            }
        }//if there is no filter, but they want to sort desc
        else if (sortDirection.equals("desc")) {
            return employeeRepository.findAll(Sort.by(Sort.Direction.DESC));
        }
        //if no conditions are met, return a list of employees default Asc
        return employeeRepository.findAll();
    }

}