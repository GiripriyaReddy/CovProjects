package com.cov;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cov.beans.Department;
import com.cov.repo.DepartmentRepository;
import com.cov.repo.EmployeeRepository;

@SpringBootApplication
public class SpringBootMvcFormApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcFormApplication.class, args);
	}
		@Bean
	    public CommandLineRunner mappingDemo(DepartmentRepository departmentRepository,
	                                           EmployeeRepository employeeRepository) {
	        return args -> {

	            
	            Department department = new Department(101,"Java");

	            departmentRepository.save(department);

	         
	            departmentRepository.save(new Department(102,"C"));
	            departmentRepository.save(new Department(103,"python"));
	            departmentRepository.save(new Department(104,"c++"));
	        };
	    }
	}


