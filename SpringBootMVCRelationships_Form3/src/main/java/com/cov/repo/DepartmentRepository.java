package com.cov.repo;

import org.springframework.data.repository.CrudRepository;

import com.cov.beans.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

}
