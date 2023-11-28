package com.cg.serviceimpl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.cg.dto.APIResponseDto;
import com.cg.dto.DepartmentDto;
import com.cg.dto.EmployeeDto;
import com.cg.model.Employee;
import com.cg.repository.EmployeeRepository;
import com.cg.service.APIClient;
import com.cg.service.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
	//private RestTemplate restTemplate;
	
	private WebClient webClient;
	
	private APIClient apiClient;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee=new Employee(
				employeeDto.getId(), 
				employeeDto.getFirstName(),
				employeeDto.getLastName(),
				employeeDto.getEmail(),
				employeeDto.getDepartmentCode());
		Employee saveDEmployee=employeeRepository.save(employee);
		
		EmployeeDto savedEmployeeDto=new EmployeeDto(
				saveDEmployee.getId(),
				saveDEmployee.getFirstName(),
				saveDEmployee.getLastName(),
				saveDEmployee.getEmail(),
				saveDEmployee.getDepartmentCode()
				);
		
		return savedEmployeeDto;
	}
    @CircuitBreaker(name="{spring.boot.name}", fallbackMethod="getDefaultDepartment")
	@Override
	public APIResponseDto getEmployeeById(Long employeeId) {
		
		Employee employee=employeeRepository.findById(employeeId).get();
	
		
		//ResponseEntity<DepartmentDto> responseEntity=restTemplate.getForEntity("http://localhost:8080/departments/" + employee.getDepartmentCode(), DepartmentDto.class);
		
		//DepartmentDto departmentDto=responseEntity.getBody();
		
		
	
		
		 DepartmentDto departmentDto=webClient.get()
		 .uri("http://localhost:8080/departments/" + employee.getDepartmentCode())
		 .retrieve()
		 .bodyToMono(DepartmentDto.class)
		 .block();
		
		//DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
		EmployeeDto employeeDto=new EmployeeDto(
				employee.getId(), 
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail(),
				employee.getDepartmentCode()
				);
		APIResponseDto apiResponseDto=new APIResponseDto();
		apiResponseDto.setEmployee(employeeDto);
		apiResponseDto.setDepartment(departmentDto);
		return apiResponseDto;
    }
		public APIResponseDto getDefaultDepartment(Long employeeId) {
			Employee employee=employeeRepository.findById(employeeId).get();
			
			DepartmentDto departmentDto=new DepartmentDto();
			departmentDto.setDepartmentCode("ECEB");
			departmentDto.setDepartmentDescription("Electronics and Communication Engineering");
			departmentDto.setDepartmentName("ECE");
			
		
			EmployeeDto employeeDto=new EmployeeDto(
					employee.getId(), 
					employee.getFirstName(),
					employee.getLastName(),
					employee.getEmail(),
					employee.getDepartmentCode()
					);
			APIResponseDto apiResponseDto=new APIResponseDto();
			apiResponseDto.setEmployee(employeeDto);
			apiResponseDto.setDepartment(departmentDto);
			return apiResponseDto;
			
		
	}
	

}
