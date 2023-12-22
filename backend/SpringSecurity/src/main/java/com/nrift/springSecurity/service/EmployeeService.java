package com.nrift.springSecurity.service;

import java.util.List;

import com.nrift.springSecurity.entity.Employee;
import com.nrift.springSecurity.entity.EmployeeRole;

public interface EmployeeService {

	public Employee createEmployee(Employee employee, List<EmployeeRole> employeeRoles) throws Exception;

	public Employee getEmployee(String emailId);

	public void deleteEmployee(int id);

	public List<Employee> fetchAllEmployees();

}
