package com.nabin.paginationdemo.services;

import com.nabin.paginationdemo.models.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author Narendra
 * @version 1.0
 * @since 2023-01-17
 */
public interface EmployeeService {
    Employee save(Employee employee);
    Employee findById(Integer id) throws Exception;
    List<Employee> findAll();
    Page<Employee> findPaginatedEmployee(Integer pageNumber, Integer size);
    Page<Employee> findAllLikeName(String name, Integer pageNumber, Integer size);
}
