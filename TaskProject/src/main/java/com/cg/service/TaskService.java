package com.cg.service;

import java.util.List;

import com.cg.payload.TaskDto;

public interface TaskService {
	public TaskDto saveTask(long userid, TaskDto taskDto);
	public List<TaskDto> getAllTasks(long userid);

}
