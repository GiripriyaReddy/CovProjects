package com.cov.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cov.beans.Department;
import com.cov.beans.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
	List<Employee> findByDepartment(Department department);

}
