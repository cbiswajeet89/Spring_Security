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
import com.nrift.springSecurity.entity.Role;
import com.nrift.springSecurity.repository.EmployeeRepository;

@Service
public class EmployeeUserDetailsService implements UserDetailsService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Employee> emp = employeeRepository.findByEmail(username);
		System.out.println("emp="+emp);
		return new User(emp.get().getEmail(), emp.get().getPassword(), mapRolesToAuthorities(emp.get().getRoles()));
//		return emp.map(EmployeeInfoDetails::new)
//		.orElseThrow(()->new UsernameNotFoundException(username+" not found"));
	}

	private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }
	
	
}
