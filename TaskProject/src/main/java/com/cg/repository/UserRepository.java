package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

}
