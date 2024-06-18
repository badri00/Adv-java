package com.automobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.automobile.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "select u from User u where u.username = :username")
	public User findByUsername(String username);
}
