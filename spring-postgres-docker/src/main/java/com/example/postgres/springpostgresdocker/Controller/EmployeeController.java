package com.example.postgres.springpostgresdocker.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.postgres.springpostgresdocker.Model.Employee;
import com.example.postgres.springpostgresdocker.Repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	 	@Autowired
	    private EmployeeRepository employeeRepository;

	    @PostMapping("/employees")
	    public Employee addEmployee(@RequestBody Employee employee) {
	        return employeeRepository.save(employee);
	    }


	    @GetMapping("/employees")
	    public ResponseEntity<List<Employee>> getAllEmployees() {
	        return ResponseEntity.ok(employeeRepository.findAll());
	    }

	    @GetMapping("employees/{id}")
	    public ResponseEntity<Employee> findEmployeeById(@PathVariable(value = "id") Integer employeeId) {
	        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
	                () -> new ResouceNotFoundException("Employee not found" + employeeId));
	        return ResponseEntity.ok().body(employee);
	    }

	    @PutMapping("employees/{id}")
	    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Integer employeeId,
	                                                   @RequestBody Employee employeeDetails) {
	        Employee employee = employeeRepository.findById(employeeId)
	                .orElseThrow(() -> new ResouceNotFoundException("Employee not found for this id :: " + employeeId));
	        employee.setName(employeeDetails.getName());
	        final Employee updatedEmployee = employeeRepository.save(employee);
	        return ResponseEntity.ok(updatedEmployee);

	    }

	    @DeleteMapping("employees/{id}")
	    public ResponseEntity<Void> deleteEmployee(@PathVariable(value = "id") Integer employeeId) {
	        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
	                () -> new ResouceNotFoundException("Employee not found" + employeeId));
	        employeeRepository.delete(employee);
	        return ResponseEntity.ok().build();
	    }
}
