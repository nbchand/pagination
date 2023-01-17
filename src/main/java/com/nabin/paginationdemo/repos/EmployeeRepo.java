package com.nabin.paginationdemo.repos;

import com.nabin.paginationdemo.models.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Narendra
 * @version 1.0
 * @since 2023-01-17
 */
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    @Query(nativeQuery = true, value = "select * from employee e where e.name ilike concat(?1,'%')")
    Page<Employee> findAllLikeName(String name, Pageable pageable);
}
