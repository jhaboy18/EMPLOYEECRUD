package com.example.EMPLOYEECRUD.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class EmployeeDto {
    @NotBlank(message = "Name cannot be null")
    @Size(min = 2,max = 50 ,message = "Student name must be withing 50 char longs")
    private String name;
    @NotEmpty(message = "Depaartment cannot be empty")
    private String department;
  @NotEmpty
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
