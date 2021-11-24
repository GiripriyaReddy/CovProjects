package com.cov.service;

import java.util.List;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cov.beans.Department;
import com.cov.exception.InvalidDepartmentIdException;
import com.cov.repo.DepartmentRepository;

@Service
public class DepartmentService {
	Logger logger = Logger.getLogger(DepartmentService.class);
	@Autowired
	DepartmentRepository departmentRepository;

	public List<Department> findAll() {

		return (List<Department>) departmentRepository.findAll();

	}

	public Department findById(int id) throws InvalidDepartmentIdException {
		logger.info("Finding department with ID : " + id);
		Optional<Department> deptOptional = departmentRepository.findById(id);
		if (!deptOptional.isPresent()) {
			logger.debug("Department not found with ID : " + id);
			InvalidDepartmentIdException invalidDepartmentIdException = new InvalidDepartmentIdException(
					"Employee ID not found");
			logger.warn(invalidDepartmentIdException);
			throw new InvalidDepartmentIdException("Department Id " + id + " not existing in repository");
		}
		return deptOptional.get();

	}

	public Department insert(Department department) {

		return departmentRepository.save(department);

	}

	public Department update(Department department) throws InvalidDepartmentIdException {
		logger.info("Updating employee with Name : " + department);
		Optional<Department> deptOptional = departmentRepository.findById(department.getId());
		logger.debug("Employee not found with Name : " + department);
		InvalidDepartmentIdException invalidDepartmentIdException = new InvalidDepartmentIdException(
				"Department  not found");
		logger.warn(invalidDepartmentIdException);
		if (!deptOptional.isPresent()) {
			throw new InvalidDepartmentIdException(
					"Department Id" + department.getId() + "not existing in reposiotory");
		}
		logger.info(
				"Department found with name " + department + " is " + department.getId() + " " + department.getName());
		return departmentRepository.save(department);
	}

	public Department save(Department department) {
		logger.info("Inserting a new department");
		InvalidDepartmentIdException invalidDepartmentIdException = new InvalidDepartmentIdException(
				"Department id not found");
		logger.warn(invalidDepartmentIdException);
		return departmentRepository.save(department);
	}

	public Department delete(int id) throws InvalidDepartmentIdException {
		logger.info("Deleting department with Id : " + id);
		Optional<Department> deptOptional = departmentRepository.findById(id);
		logger.debug("Department not found with ID : " + id);
		if (!deptOptional.isPresent()) {
			throw new InvalidDepartmentIdException("Department Id " + id + "not existing in repository");
		}
		Department department = deptOptional.get();
		departmentRepository.deleteById(id);
		return department;
	}

}