package com.darmi.employeesystemapi.controller;

import com.darmi.employeesystemapi.model.Employee;
import com.darmi.employeesystemapi.services.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
//@RequestMapping("/api/v1")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("employees/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable long id){
        Boolean deleted = false;
        deleted = employeeService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", deleted);
        return ResponseEntity.ok(response);
    }

    @GetMapping("employees/{id}")
    public  ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("employees/{id}")
    public  ResponseEntity<Employee> update(@PathVariable long id,
            @RequestBody Employee employee){
        employee = employeeService.update(id, employee);
        return ResponseEntity.ok(employee);
    }
}
