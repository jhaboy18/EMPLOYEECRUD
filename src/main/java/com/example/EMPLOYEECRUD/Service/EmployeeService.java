package com.example.EMPLOYEECRUD.Service;

import com.example.EMPLOYEECRUD.Entities.Employee;
import com.example.EMPLOYEECRUD.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
   private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    // create Employee

    public Employee createEmployee(Employee employee){
        Employee empployeeres=employeeRepository.save(employee);
        return empployeeres;
    }
    // get 1 employee
    public Employee getoneemployee(Long id){
        Optional<Employee> findemp=employeeRepository.findById(id);
        if(findemp.isEmpty()){
            return null;
        }
        return findemp.get();

    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
