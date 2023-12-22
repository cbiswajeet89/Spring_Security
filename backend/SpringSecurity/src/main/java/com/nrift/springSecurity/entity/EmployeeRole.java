package com.nrift.springSecurity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployeeRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeRoleId;

	@ManyToOne(fetch = FetchType.EAGER)
	private Employee employee;

	@ManyToOne
	private Role role;

}
