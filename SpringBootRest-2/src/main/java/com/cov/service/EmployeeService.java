package com.cov.service;

import java.util.List;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cov.beans.Employee;
import com.cov.exception.InvalidDepartmentIdException;
import com.cov.exception.InvalidEmployeeIdException;
import com.cov.repo.EmployeeRepository;

@Service
public class EmployeeService {
	Logger logger = Logger.getLogger(EmployeeService.class);

	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> findAll() {

		return (List<Employee>) employeeRepository.findAll();

	}

	public Employee findById(int id) throws InvalidEmployeeIdException {
		logger.info("Finding employee with ID : " + id);
		Optional<Employee> empOptional = employeeRepository.findById(id);
		if (!empOptional.isPresent()) {
			logger.debug("Employee not found with ID : " + id);
			InvalidEmployeeIdException invalidEmployeeIdException = new InvalidEmployeeIdException(
					"Employee ID not found");
			logger.warn(invalidEmployeeIdException);
			throw new InvalidEmployeeIdException();
		}
		Employee employee = empOptional.get();
		return employee;

	}

	public Employee insert(Employee employee) {

		return employeeRepository.save(employee);

	}

	public Employee update(Employee employee) throws InvalidEmployeeIdException {
		logger.info("Updating employee with Name : " + employee);
		Optional<Employee> empOptional = employeeRepository.findById(employee.getId());
		logger.debug("Employee not found with Name : " + employee);
		InvalidEmployeeIdException invalidEmployeeIdException = new InvalidEmployeeIdException(
				"Employee name not found");
		logger.warn(invalidEmployeeIdException);
		if (!empOptional.isPresent()) {
			throw new InvalidEmployeeIdException("Employee Id" + employee.getId() + "not existing in reposiotory");
		}
		logger.info(
				"Employee found with name " + employee + " is " + employee.getName() + " " + employee.getDepartment());
		return employeeRepository.save(employee);
	}

	public Employee delete(int id) throws InvalidEmployeeIdException {
		logger.info("Deleting employee with Id : " + id);
		Optional<Employee> empOptional = employeeRepository.findById(id);
		logger.debug("Employee not found with ID : " + id);
		InvalidEmployeeIdException invalidEmployeeIdException = new InvalidEmployeeIdException("Employee Id not found");
		logger.warn(invalidEmployeeIdException);
		if (!empOptional.isPresent()) {
			throw new InvalidEmployeeIdException("Employee Id" + id + "not existing in repository");
		}
		Employee employee = empOptional.get();
		employeeRepository.deleteById(id);
		return employee;
	}
	public Employee save(Employee employee) {
		logger.info("Inserting a new employee");
		InvalidEmployeeIdException invalidEmployeeIdException = new InvalidEmployeeIdException("Employee id not found");
		logger.warn(invalidEmployeeIdException);
		return employeeRepository.save(employee);
		}

	public List<Employee> findAllByDeptno(int deptno) throws InvalidDepartmentIdException {
		logger.info(" employee with department : " + deptno);
		List<Employee> employee = employeeRepository.findAllEmployeeDeptno(deptno);
		if (employee.isEmpty()) {
			throw new InvalidDepartmentIdException("Department Id " + deptno + "not existing in repository");
		}

		return employee;
	}

	
}