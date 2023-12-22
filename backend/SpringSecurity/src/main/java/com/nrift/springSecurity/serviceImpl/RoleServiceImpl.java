package com.nrift.springSecurity.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrift.springSecurity.entity.Role;
import com.nrift.springSecurity.repository.RoleRepository;
import com.nrift.springSecurity.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role getRoleByRoleName(String roleName) {
		// TODO Auto-generated method stub
		return roleRepository.findByRoleName(roleName);
	}

}
