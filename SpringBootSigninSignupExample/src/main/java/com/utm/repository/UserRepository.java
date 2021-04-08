package com.utm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.utm.model.User;

@Repository("userReposistory")
public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);
}
