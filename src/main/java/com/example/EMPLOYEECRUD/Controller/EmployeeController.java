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

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updatemployee(@PathVariable Long id,@RequestBody Employee employeereq){
        Employee employeeres=employeeService.update(id,employeereq);
        return ResponseEntity.ok(employeeres);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {

        Employee employeeres = employeeService.delete(id);

        if (employeeres == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(true);
    }
    @PatchMapping("/delete-soft/{id}")
    public ResponseEntity<String> deletedsoftly(@PathVariable Long id) {

        Boolean isdeleted = employeeService.deletestuydentsoftly(id);

        if (!isdeleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Student deleted");
    }
}
