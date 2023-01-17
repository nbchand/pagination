package com.nabin.paginationdemo.controllers;

import com.nabin.paginationdemo.models.Employee;
import com.nabin.paginationdemo.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Narendra
 * @version 1.0
 * @since 2023-01-17
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.save(employee), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) throws Exception {
        return new ResponseEntity<>(employeeService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<?> findPaginatedEmployees(@RequestParam(required = true) Integer pgNo,
                                                    @RequestParam(required = true) Integer size) {
        return new ResponseEntity<>(employeeService.findPaginatedEmployee(pgNo, size), HttpStatus.OK);
    }

    @GetMapping("/like/{name}")
    public ResponseEntity<?> findPaginatedEmployeesLikeName(@PathVariable("name") String name, @RequestParam(required = true) Integer pgNo,
                                                            @RequestParam(required = true) Integer size) {
        return new ResponseEntity<>(employeeService.findAllLikeName(name, pgNo, size), HttpStatus.OK);
    }
}
