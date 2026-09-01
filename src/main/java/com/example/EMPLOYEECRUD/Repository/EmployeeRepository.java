package com.example.EMPLOYEECRUD.Repository;

import com.example.EMPLOYEECRUD.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
