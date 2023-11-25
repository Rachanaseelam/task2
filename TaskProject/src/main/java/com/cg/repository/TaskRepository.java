package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
