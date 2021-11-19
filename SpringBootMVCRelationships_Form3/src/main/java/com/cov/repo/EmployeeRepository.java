package com.cov.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cov.beans.Department;
import com.cov.beans.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	@Query("select employee from Employee employee where employee.department.id=?1")
	List<Employee> findAllEmployeeDeptno(int deptno);

}
