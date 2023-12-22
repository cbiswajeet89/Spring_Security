package com.nrift.springSecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nrift.springSecurity.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public Optional<Employee> findByEmail(String email);

	public Employee findByName(String employeeName);

}
