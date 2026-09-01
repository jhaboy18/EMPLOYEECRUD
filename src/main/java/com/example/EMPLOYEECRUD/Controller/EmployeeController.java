package com.example.EMPLOYEECRUD.Controller;

import com.example.EMPLOYEECRUD.Entities.Employee;
import com.example.EMPLOYEECRUD.Service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")

    public ResponseEntity<Employee> addemployee(@RequestBody Employee employee){
        Employee employee1=employeeService.createEmployee(employee);
        return ResponseEntity.ok(employee1);
    }

    // get one employee
    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getoneemployee(@PathVariable Long id){
        Employee findemp=employeeService.getoneemployee(id);
        if(findemp==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(findemp);
    }


    // find all
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAll() {
        List<Employee> employees = employeeService.getAll();
        return ResponseEntity.ok(employees);
    }
    // upate ka put and dletye ka bhi likely same hi hoga maien bahut kiya hai mern me aisa waise ye acha lg rha hai
}
