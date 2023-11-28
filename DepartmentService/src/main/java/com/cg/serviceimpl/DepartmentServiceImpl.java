package com.cg.serviceimpl;

import org.springframework.stereotype.Service;

import com.cg.dto.DepartmentDto;
import com.cg.model.Department;
import com.cg.repository.DepartmentRepository;
import com.cg.service.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	private DepartmentRepository departmentRepository;
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}
	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		
		//convert deparment dto to department jpa
		Department department=new Department(
				departmentDto.getId(),
				departmentDto.getDepartmentName(),
				departmentDto.getDepartmentDescription(),
				departmentDto.getDepartmentCode()
				);
		Department savedDepartment=departmentRepository.save(department);	
		
		DepartmentDto savedDepartmentDto=new DepartmentDto(
				savedDepartment.getId(),
				savedDepartment.getDepartmentName(),
				savedDepartment.getDepartmentDescription(),
				savedDepartment.getDepartmentCode()
				);
				
		return savedDepartmentDto;
	}
	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) {
		Department department=departmentRepository.findByDepartmentCode(departmentCode);
		DepartmentDto departmentDto=new DepartmentDto(
				department.getId(),
				department.getDepartmentName(),
				department.getDepartmentDescription(),
				department.getDepartmentCode()
				);
				
		
		return departmentDto;
	}
	

}
