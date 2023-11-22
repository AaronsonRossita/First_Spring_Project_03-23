package com.First_Spring_Project_0323.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/micro_service")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/id")
    Employee getEmployeeBYId(@RequestParam int id){
        return employeeService.getEmployeeById(id);
    }



}
