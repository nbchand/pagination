package com.nabin.paginationdemo.services.impl;

import com.nabin.paginationdemo.models.Employee;
import com.nabin.paginationdemo.repos.EmployeeRepo;
import com.nabin.paginationdemo.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Narendra
 * @version 1.0
 * @since 2023-01-17
 */
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Override
    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Employee findById(Integer id) throws Exception {
        return employeeRepo.findById(id)
                .orElseThrow(() -> new Exception("Invalid employee id"));
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Page<Employee> findPaginatedEmployee(Integer pageNumber, Integer size) {
        Pageable pageable = PageRequest.of(pageNumber, size, Sort.by("designation"));
        return employeeRepo.findAll(pageable);
    }

    @Override
    public Page<Employee> findAllLikeName(String name, Integer pageNumber, Integer size) {
        Pageable pageable = PageRequest.of(pageNumber, size, Sort.by("name"));
        return employeeRepo.findAllLikeName(name, pageable);
    }
}
