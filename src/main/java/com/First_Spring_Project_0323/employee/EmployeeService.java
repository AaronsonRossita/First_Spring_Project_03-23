package com.First_Spring_Project_0323.employee;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
        name = "employeeServices",
        url = "${employee.url}"
)
public interface EmployeeService {

    @GetMapping(path = "/employee/all")
    List<Employee> getAllEmployees();

    @GetMapping(path = "/employee/by_id/{id}")
    Employee getEmployeeById(@PathVariable Integer id);

    @GetMapping(path = "/employee/job_title")
    List<Employee> getByJobTitle(@RequestParam(value = "job_title") String jobTitle);


}
