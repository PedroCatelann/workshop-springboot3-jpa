package com.pedrocatelan.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrocatelan.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
