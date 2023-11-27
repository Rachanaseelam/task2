package com.cg.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.DepartmentDto;
import com.cg.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	private DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}
	//buid the get department rest api
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
		DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
		return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
	}
	
	//build get department rest api
	@GetMapping("{department-code}")
	public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
		DepartmentDto departmentDto=departmentService.getDepartmentByCode(departmentCode);
		return new ResponseEntity<>(departmentDto, HttpStatus.OK);
	}

}
