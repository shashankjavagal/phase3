package com.org.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.sportyshoes.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsername(String userName);
}
