package com.nrift.springSecurity.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrift.springSecurity.entity.Employee;
import com.nrift.springSecurity.entity.EmployeeRole;
import com.nrift.springSecurity.repository.EmployeeRepository;
import com.nrift.springSecurity.repository.RoleRepository;
import com.nrift.springSecurity.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Employee getEmployee(String email) {
		// TODO Auto-generated method stub
		return employeeRepository.findByEmail(email).get();
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
		;
	}

	@Override
	public List<Employee> fetchAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee createEmployee(Employee employee, List<EmployeeRole> employeeRoles) throws Exception {
		for (EmployeeRole er : employeeRoles) {
			roleRepository.save(er.getRole());
		}
		employee.getEmployeeRoles().addAll(employeeRoles);
		return employeeRepository.save(employee);

	}

}
