package com.nrift.springSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nrift.springSecurity.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	public Role findByRoleName(String roleName);
}
