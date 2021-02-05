package com.example.assignment2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment2.entity.Student;
import com.example.assignment2.entity.Test;
import com.example.assignment2.exception.StudentNotFoundException;
import com.example.assignment2.repository.StudentJpaRepository;
import com.example.assignment2.repository.TestJpaRepository;

@RestController
@RequestMapping(value="/test")
public class TestController {
	
	@Autowired
	TestJpaRepository testRepository;
	@Autowired
	StudentJpaRepository studentRepository;
	
	
	@PostMapping("/{id}")
	public ResponseEntity<Object> createTest(@PathVariable("id") int id,@RequestBody Test test) throws StudentNotFoundException {
		Optional<Student> student=studentRepository.findById(id);
		
		if(!student.isPresent())
			throw new StudentNotFoundException("Student doesn't exist");
		
		Student s=student.get();
		test.setStudent(s);
		testRepository.save(test);
		return new ResponseEntity<>("Test is added successfully", HttpStatus.CREATED);

	}
	
	@GetMapping("/{sid}/test")
	public List<Test> getTestBySid(@PathVariable("sid") int sid) throws StudentNotFoundException{
		Optional<Student> student=studentRepository.findById(sid);
		if(!student.isPresent())
			throw new StudentNotFoundException("Student doesn't exist");
		return student.get().getTest();
	}
	
	@GetMapping("")
	public List<Test> getAllTest(){
		return testRepository.findAll();
	}
	
}
