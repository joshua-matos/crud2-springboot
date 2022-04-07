package com.joshuamatos.Crud2.employees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> getEmployeeById(Long id);

    List<Employee> findAllByNameStartsWith(String startsWithFilter);

    List<Employee> findEmployeeByNameStartsWithOrderByNameAsc(@Param("filter") String name);

    List<Employee> findByNameStartsWithOrderByNameDesc(@Param("filter") String name);
}