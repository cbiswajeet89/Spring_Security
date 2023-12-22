package com.nrift.springSecurity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nrift.springSecurity.entity.Employee;
import com.nrift.springSecurity.entity.EmployeeRole;
import com.nrift.springSecurity.entity.Role;
import com.nrift.springSecurity.service.EmployeeService;
import com.nrift.springSecurity.service.RoleService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/addEmployee")
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee) throws Exception {
		List<EmployeeRole> roles = new ArrayList<>();
		Role role = roleService.getRoleByRoleName("USER");
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		EmployeeRole employeeRole = new EmployeeRole();
		employeeRole.setRole(role);
		employeeRole.setEmployee(employee);
		roles.add(employeeRole);
		Employee emp = employeeService.createEmployee(employee, roles);
		if (emp != null)
			return ResponseEntity.ok(emp);
		else
			return ResponseEntity.ok("could not process");
	}

	@GetMapping("/listEmp")
	public ResponseEntity<List<Employee>> listEmployees() {
		return ResponseEntity.ok(employeeService.fetchAllEmployees());
	}
}
