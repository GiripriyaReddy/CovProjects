package com.cov.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cov.beans.Department;

import com.cov.repo.DepartmentRepository;

@TestInstance(Lifecycle.PER_CLASS)
class DepartmentServiceTest {
	@InjectMocks
	DepartmentService departmentService;
	@Mock
	DepartmentRepository departmentRepository;
	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);
		List<Department> departments = new ArrayList<>();
		departments.add(new Department(1, "Java"));
		departments.add(new Department(2, "C"));
		departments.add(new Department(3, "HR"));
		departments.add(new Department(4, "BRM"));
		when(departmentRepository.findAll()).thenReturn(departments);
		Department departmentExisting = new Department(2, "python");
		when(departmentRepository.findById(2)).thenReturn(Optional.of(departmentExisting));
	}

	@Test
	void testFindAll() {

		List<Department> perList = departmentService.findAll();
		assertNotNull(perList);
		assertEquals(4, perList.size());
	}

	@Test
	void testFindById() {

		Department department = departmentRepository.findById(2).get();
		assertNotNull(department);
		assertSame(department.getName(), "HR");

		assertEquals(department.getId(), 3);
	}

	@Test
	void testInsert() {
		Department department = new Department(5, "CRM");
		when(departmentRepository.save(department)).thenReturn(department);
		Department dept = departmentRepository.save(department);
		assertNotNull(dept);
		assertSame(dept.getName(), "CRM");
		assertEquals(dept.getId(), 5);
	}

	@Test
	void testUpdate() {
		Department department = new Department(4, "testing");
		when((departmentRepository.findById(department.getId()))).thenReturn(Optional.of(department));
		when(departmentRepository.save(department)).thenReturn(department);
		Department d = departmentRepository.save(department);
		assertNotNull(d);
		assertSame(d.getName(), "testing");
		assertEquals(d.getId(), 4);
	}

}