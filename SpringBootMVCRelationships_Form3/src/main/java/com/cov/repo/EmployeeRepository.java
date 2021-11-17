package com.cov.repo;

import org.springframework.data.repository.CrudRepository;

import com.cov.beans.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
