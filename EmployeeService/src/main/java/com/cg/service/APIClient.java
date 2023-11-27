package com.cg.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.dto.DepartmentDto;

@FeignClient(url = "http://localhost:8080", value="DEPARTMENT-SERVICE")
public interface APIClient {
	//build get department rest api
		@GetMapping("/departments/{department-code}")
		DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);
			

}
