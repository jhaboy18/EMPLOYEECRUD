package com.example.EMPLOYEECRUD.Service;

import com.example.EMPLOYEECRUD.DTO.EmployeeDto;
import com.example.EMPLOYEECRUD.Entities.Employee;
import com.example.EMPLOYEECRUD.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
   private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    // create Employee

    public Employee createEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee();

        employee.setName(employeeDto.getName());
        employee.setDepartment(employeeDto.getDepartment());
        employee.setSalary(employeeDto.getSalary());

        employee.setDeleted(false);
        employee.setCreatedAt(LocalDateTime.now());

        Employee employeeResponse = employeeRepository.save(employee);

        return employeeResponse;
    }
    // get 1 employee
    public Employee getoneemployee(Long id){
        Optional<Employee> findemp=employeeRepository.findByIdAndDeletedIsFalse(id);
        if(findemp.isEmpty()){
            return null;
        }
        return findemp.get();

    }

    public List<Employee> getAll() {
        return employeeRepository.findByDeletedIsFalse();
    }

    public Employee update(Long id, EmployeeDto employeeDto) {

        Optional<Employee> employeeres =
                employeeRepository.findByIdAndDeletedIsFalse(id);

        if (employeeres.isEmpty()) {
            return null;
        }

        Employee updatedemployee = employeeres.get();

        updatedemployee.setName(employeeDto.getName());
        updatedemployee.setDepartment(employeeDto.getDepartment());
        updatedemployee.setSalary(employeeDto.getSalary());

        updatedemployee.setUpdatedAt(LocalDateTime.now());

        return employeeRepository.save(updatedemployee);
    }

    public Employee delete(Long id) {

        Optional<Employee> employeeres = employeeRepository.findById(id);

        if (employeeres.isEmpty()) {
            return null;
        }

        Employee employee = employeeres.get();

        employeeRepository.deleteById(id);

        return employee;
    }

    public Boolean deletestuydentsoftly(Long id) {

        Optional<Employee> existing = employeeRepository.findByIdAndDeletedIsFalse(id);

        if (existing.isEmpty()) {
            return false;
        }

        Employee employee = existing.get();

        employee.setDeleted(true);

        employeeRepository.save(employee);

        return true;
    }
}
