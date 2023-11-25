package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.payload.TaskDto;
import com.cg.service.TaskService;

@RestController
@RequestMapping("/api")
public class TaskController {
	@Autowired
	private TaskService taskService;

	//save the task
	@PostMapping("/{userid}/tasks")
	public ResponseEntity<TaskDto> saveTask(
			@PathVariable(name="userid") long userid,
			@RequestBody TaskDto taskDto){
		return new ResponseEntity<>(taskService.saveTask(userid,  taskDto), HttpStatus.CREATED);
	}
	
	//get all task
	
	//get indiv task
	

	//del indiv task

}
