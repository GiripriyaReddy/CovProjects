package com.cov;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cov.beans.Department;
import com.cov.beans.Employee;
import com.cov.service.DepartmentService;
import com.cov.service.EmployeeService;

@SpringBootApplication
public class SpringBootMvcFormApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctxt = SpringApplication.run(SpringBootMvcFormApplication.class, args);
		Department department1 = new Department(10, "CRM");
		Department department2 = new Department(20, "BRM");

		Employee employee1 = new Employee(101, "giripriya", department1);
		Employee employee2 = new Employee(102, "reddy", department1);
		Employee employee3 = new Employee(103, "charan", department2);

		List<Employee> employees1 = new ArrayList<>();
		List<Employee> employees2 = new ArrayList<>();

		employees1.add(employee1);
		employees1.add(employee2);

		employees2.add(employee3);

		EmployeeService employeeService = ctxt.getBean(EmployeeService.class);
		DepartmentService departmentService = ctxt.getBean(DepartmentService.class);

		departmentService.save(department1);
		departmentService.save(department2);

		employeeService.save(employee1);
		employeeService.save(employee2);
		employeeService.save(employee3);

	}

}
