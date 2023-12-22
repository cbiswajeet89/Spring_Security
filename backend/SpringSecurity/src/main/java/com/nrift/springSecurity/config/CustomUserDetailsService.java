package com.nrift.springSecurity.config;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nrift.springSecurity.entity.Employee;
import com.nrift.springSecurity.entity.EmployeeRole;
import com.nrift.springSecurity.repository.EmployeeRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Employee> emp = employeeRepository.findByEmail(username);
		return new User(emp.get().getEmail(), emp.get().getPassword(),
				mapRolesToAuthorities(emp.get().getEmployeeRoles()));
	}

	private Collection<GrantedAuthority> mapRolesToAuthorities(List<EmployeeRole> roles) {
		return roles.stream().map(mapper -> new SimpleGrantedAuthority(mapper.getRole().getRoleName()))
				.collect(Collectors.toList());
	}

}
