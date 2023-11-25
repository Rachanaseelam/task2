package com.cg.serviceimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.Task;
import com.cg.model.Users;
import com.cg.payload.TaskDto;
import com.cg.repository.TaskRepository;
import com.cg.repository.UserRepository;
import com.cg.service.TaskService;
@Service
public class TaskServiceImpl implements TaskService {
	@Autowired
    private ModelMapper modelMapper;
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	@Override
	public TaskDto saveTask(long userid, TaskDto taskDto) {
		userRepository.findById(userid).get();
		Task task=modelMapper.map(taskDto, Task.class);
		//task.setUsers(user);
		Task savedTask=taskRepository.save(task);
		return modelMapper.map(savedTask, TaskDto.class);
	}

	@Override
	public List<TaskDto> getAllTasks(long userid) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
