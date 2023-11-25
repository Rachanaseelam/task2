package com.cg.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.cg.model.Student;
import com.cg.repository.StudentRepository;

@RestController
public class StudentController {
	@Autowired
	StudentRepository studentRepository;
	
	@PostMapping("/api/students")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		return new ResponseEntity<>(studentRepository.save(student),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/api/students")
	public ResponseEntity<List<Student>> getStudents(){
		return new ResponseEntity<>(studentRepository.findAll(),HttpStatus.OK);
	}
	
	
	@GetMapping("/api/students/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable long id){
		Optional<Student> student = studentRepository.findById(id);
		if(student.isPresent()) {
			return new ResponseEntity<>(student.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
		
		@PutMapping("/api/students/{id}")
		public ResponseEntity<Student> getStudent(@PathVariable long id, @RequestBody Student stud){
			Optional<Student> student = studentRepository.findById(id);
			if(student.isPresent()) {
				student.get().setName(stud.getName());
				student.get().setEmail(stud.getEmail());
				student.get().setAddress(stud.getAddress());
			
				return new ResponseEntity<>(studentRepository.save(student.get()),HttpStatus.OK);
			}
			else {
				
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
			@DeleteMapping("/api/students/{id}")
			public ResponseEntity<Void> deleteStudent(@PathVariable long id){
				Optional<Student> student = studentRepository.findById(id);
				if(student.isPresent()) {
					studentRepository.deleteById(id);
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
	}
}
	