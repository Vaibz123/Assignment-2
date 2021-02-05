package com.example.assignment2.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment2.entity.Student;
import com.example.assignment2.entity.Test;
import com.example.assignment2.repository.StudentJpaRepository;
import com.example.assignment2.repository.TestJpaRepository;
import com.example.assignment2.service.StudentService;

@RestController
@RequestMapping(value="/student")
public class StudentController {
	
	@Autowired
	StudentJpaRepository repository;
	@Autowired
	TestJpaRepository testRepository;
	@Autowired
	StudentService service;
	
	@PostMapping("")
	public ResponseEntity<Object> create(@RequestBody Student s) {
		repository.save(s);	
		return new ResponseEntity<>("Student is created successfully", HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable("id") int id,@RequestBody Student s) {
		s.setId(id);
		repository.save(s);	
		return new ResponseEntity<>("Student updated successfully", HttpStatus.CREATED);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") int id) {
		Optional<Student> studentOptional= findById(id);
		if(studentOptional.isPresent()) {
			Student s =studentOptional.get();
			List<Test> tests=s.getTest();
			tests.forEach(t->testRepository.deleteById(t.getTid()));
		}
		repository.deleteById(id);	
		return new ResponseEntity<>("Deletion successful", HttpStatus.CREATED);

	}
	
	@GetMapping("/{id}")
	public Optional<Student> findById(@PathVariable("id") int id) {
		return repository.findById(id);
	}
	
	@GetMapping("")
	public Optional<List<Student>> getTopper() {
		return service.getToppers();
	}
	@GetMapping("/all")
	public List<Student> getAll() {
		return repository.findAll();
	}
}
