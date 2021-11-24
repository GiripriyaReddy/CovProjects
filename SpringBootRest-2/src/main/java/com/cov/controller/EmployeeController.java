package com.cov.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cov.beans.Employee;
import com.cov.exception.InvalidEmployeeIdException;
import com.cov.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	static Logger logger = Logger.getLogger(EmployeeController.class);
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/{id}")
	public Employee find(@PathVariable int id) throws InvalidEmployeeIdException {
		logger.info("Finding an employee with id " + id);
		Employee employee = employeeService.findById(id);
		logger.info("Employee found with id " + id + " is" + employee.getName());
		return employee;
	}

	@GetMapping()
	public List<Employee> findAll() {
		logger.info("Finding all employees");
		return employeeService.findAll();
	}

	@PostMapping()
	public Employee insertPerson(@RequestBody Employee employee) {
		logger.info("Inserting an employee with " + employee.getName());
		return employeeService.save(employee);
	}

	@PutMapping()
	public Employee edit(@RequestBody Employee employee) throws InvalidEmployeeIdException {
		logger.info("Editing an employee with " + employee.getName());
		return employeeService.update(employee);
	}

	@DeleteMapping("/{id}")
	public Employee delete(@PathVariable int id) throws InvalidEmployeeIdException {
		logger.info("Deleting an employee with id " + id);
		return employeeService.delete(id);
	}
}