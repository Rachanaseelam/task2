package com.cg.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.APIResponseDto;
import com.cg.dto.EmployeeDto;
import com.cg.service.EmployeeService;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	//build save employee rest api
	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto savedEmployee=employeeService.saveEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	
	//build get employee rest api
	@GetMapping("{id}")
	public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id")Long employeeId){
		APIResponseDto apiResponseDto=employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
		
	}
	
	

}
