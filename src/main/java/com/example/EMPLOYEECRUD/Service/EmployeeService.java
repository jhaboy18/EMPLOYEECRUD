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
        employee.setDeleted(false);
        Employee empployeeres=employeeRepository.save(employee);
        return empployeeres;
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

    public Employee update(Long id,Employee employee) {
        Optional<Employee> employeeres=employeeRepository.findByIdAndDeletedIsFalse(id);
        if(employeeres.isEmpty()){
            return null;
        }
        Employee updatedemployee=employeeres.get();
        updatedemployee.setName(employee.getName());
        updatedemployee.setDepartment(employee.getDepartment());
        updatedemployee.setSalary(employee.getSalary());

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
