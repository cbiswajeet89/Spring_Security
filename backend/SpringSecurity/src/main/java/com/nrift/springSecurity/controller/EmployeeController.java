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
import com.nrift.springSecurity.entity.Role;
import com.nrift.springSecurity.repository.EmployeeRepository;
import com.nrift.springSecurity.repository.RoleRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp){
		System.out.println("add emp	");
		System.out.println(emp.getPassword());
		emp.setPassword(passwordEncoder.encode(emp.getPassword()));
		System.out.println(emp.getPassword());
		List<Role> roles = roleRepository.findAll();
		emp.setRoles(roles);
		return ResponseEntity.ok(employeeRepository.save(emp));
	}
	@GetMapping("/listEmp")
	public ResponseEntity<List<Employee>> listEmployees(){
		System.out.println("see emp	");
		return ResponseEntity.ok(employeeRepository.findAll());
	}
}
