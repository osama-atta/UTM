package com.utm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utm.model.Role;

@Repository("roleReposistory")
public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	Role findByRole(String role);

}
