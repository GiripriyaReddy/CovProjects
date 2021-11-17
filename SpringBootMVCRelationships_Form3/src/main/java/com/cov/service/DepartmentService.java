package com.cov.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cov.beans.Department;

import com.cov.exception.InvalidDepartmentIdException;

import com.cov.repo.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	DepartmentRepository departmentRepository;

	public List<Department> findAll() {
// List<Employee> employee=new ArrayList<Employee>();
		return (List<Department>) departmentRepository.findAll();
// return employee;

	}

	public Department findById(Long id) throws InvalidDepartmentIdException {
		Optional<Department> deptOptional = departmentRepository.findById(id);
		if (!deptOptional.isPresent()) {
			throw new InvalidDepartmentIdException("Department Id " + id + " not existing in repository");
		}
		return deptOptional.get();

	}

	public Department save(Department department) {

		return Department.save(department);

	}

	public Department update(Department department, Object id) throws InvalidDepartmentIdException {
		Optional<Department> deptOptional = Department.findById(department.getId(id));
		if (!deptOptional.isPresent()) {
			throw new InvalidDepartmentIdException(
					"Department Id" + (department.getId() + "not existing in reposiotory"));
		}
		return Department.save(department);
	}

	public Department delete(int id) throws InvalidDepartmentIdException {
		Optional<Department> deptOptional = Department.findById(id);
		if (!deptOptional.isPresent()) {
			throw new InvalidDepartmentIdException("Department Id " + id + "not existing in repository");
		}
		Department department = deptOptional.get();
		Department.deleteById(id);
		return department;
	}
}