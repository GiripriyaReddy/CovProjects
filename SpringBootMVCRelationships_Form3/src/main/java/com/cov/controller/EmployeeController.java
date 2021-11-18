package com.cov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cov.beans.Employee;
import com.cov.exception.InvalidEmployeeIdException;
import com.cov.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "regemp", method = RequestMethod.GET)
	public ModelAndView newEmployee() {
		ModelAndView modelAndView = new ModelAndView("regEmployee", "employee", new Employee());
		return modelAndView;
	}

	@RequestMapping(value = "regEmp", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		ModelAndView modelAndView = new ModelAndView("savedEmployee");
		modelAndView.addObject("employee", employeeService.save(employee));
		return modelAndView;
	}

	@RequestMapping("getEmp")
	public ModelAndView findEmployees() {
		ModelAndView modelAndView = new ModelAndView("showEmployee", "emps", employeeService.findAll());
		// List<Employee> emps= employeeService.findAll();
		// modelAndView.addObject("emps",emps);
		return modelAndView;

	}

	@RequestMapping(value = "editEmployee", method = RequestMethod.GET)
	public ModelAndView editEmployee(@RequestParam int id) throws InvalidEmployeeIdException {
		Employee aaa = employeeService.findById(id);
		ModelAndView modelAndView = new ModelAndView("editEmployee", "aaa", aaa);
		return modelAndView;
	}

	@RequestMapping(value = "updateEmp", method = RequestMethod.POST)
	public ModelAndView updateeditEmployee(@ModelAttribute("aaa") Employee employee) throws InvalidEmployeeIdException {
		employeeService.update(employee);
		ModelAndView modelAndView = new ModelAndView("redirect:getEmp");
		// System.out.println("Employee update successful with id:"+employee.getId());
		return modelAndView;

	}

	@RequestMapping(value = "deleteEmployee")
	public ModelAndView deleteEmployee(@RequestParam int id) throws InvalidEmployeeIdException {
		employeeService.delete(id);
		ModelAndView modelandView = new ModelAndView("redirect:" + "getEmp");
		return modelandView;
	}

}
