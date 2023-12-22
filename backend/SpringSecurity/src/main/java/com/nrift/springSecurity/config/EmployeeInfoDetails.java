package com.nrift.springSecurity.config;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.nrift.springSecurity.entity.Employee;
import com.nrift.springSecurity.entity.Role;

public class EmployeeInfoDetails implements UserDetails {

	
	private String username;
	private String password;
	private List<GrantedAuthority> authorities;
	
	public EmployeeInfoDetails(Employee employee) {
		this.username = employee.getEmail();
		this.password = employee.getPassword();
		this.authorities = employee.getRoles().stream()
							.map(role -> new SimpleGrantedAuthority(role.getRoleName()))
							.collect(Collectors.toList());
//		this.authorities = Arrays.stream(employee.getRoles().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		System.out.println("auths: "+authorities);
	}
	private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
