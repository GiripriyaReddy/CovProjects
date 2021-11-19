package com.cov.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cov.beans.Department;
import com.cov.beans.Employee;
import com.cov.exception.InvalidDepartmentIdException;
import com.cov.exception.InvalidEmployeeIdException;
import com.cov.service.DepartmentService;
import com.cov.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@Autowired
	DepartmentService departmentService;

	

	@RequestMapping(value = "regEmp", method = RequestMethod.GET)
	public ModelAndView newEmployee() {
		ModelAndView modelAndView = new ModelAndView("regEmployee", "employee", new Employee());
		modelAndView.addObject("departmentService", departmentService);
		return modelAndView;
	}

	@RequestMapping(value = "regEmp", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee) throws InvalidEmployeeIdException {
		ModelAndView modelAndView = new ModelAndView("showEmployee");
		employeeService.save(employee);
		modelAndView.addObject("employees", employeeService.findAll());
		return modelAndView;
	}

	@RequestMapping(value="getEmp",method = RequestMethod.GET)
	public ModelAndView findAll() throws InvalidEmployeeIdException {
		ModelAndView modelAndView = new ModelAndView("showEmployee");
		List<Employee> employees = employeeService.findAll();
		List<Department> departments = departmentService.findAll();
		modelAndView.addObject("employees", employees);
		modelAndView.addObject("departments",departments);
		modelAndView.addObject("departmentService",departmentService);
		modelAndView.addObject("department",new Department());
		modelAndView.addObject("employeeService", employeeService);
		return modelAndView;
	}

	@RequestMapping(value = "editEmp", method = RequestMethod.GET)
	public ModelAndView editEmp(@RequestParam int id) throws InvalidEmployeeIdException {
		Employee empToEdit = employeeService.findById(id);
		ModelAndView modelAndView = new ModelAndView("editEmployee", "empToEdit", empToEdit);
		modelAndView.addObject("departmentService", departmentService);


		return modelAndView;
	}

	@RequestMapping(value = "updateEmp", method = RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute("empToEdit") Employee employee)
			throws InvalidEmployeeIdException {
		employeeService.update(employee);
		ModelAndView modelAndView = new ModelAndView("redirect:" + "getEmp");
		return modelAndView;
	}

	@RequestMapping(value = "deleteEmp")
	public ModelAndView deleteEmp(@RequestParam int id) throws InvalidEmployeeIdException {
		employeeService.delete(id);
		ModelAndView modelAndView = new ModelAndView("redirect:getEmp");
		return modelAndView;
	}
	@RequestMapping(value = "getAllEmp", method = RequestMethod.POST)
	public ModelAndView findAllEmployeeByDept(@RequestParam int deptid) throws InvalidDepartmentIdException {



	ModelAndView modelAndView = new ModelAndView("empByDept");
	modelAndView.addObject("departmentService", departmentService);
	List<Employee> employees = employeeService.findAllByDeptno(deptid);
	modelAndView.addObject("employees",employees);



	return modelAndView;



	}
}
