package com.example.assignment2.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.assignment2.entity.Student;
import com.example.assignment2.entity.Test;
import com.example.assignment2.exception.StudentNotFoundException;
import com.example.assignment2.repository.StudentJpaRepository;

@Component
public class StudentService {
	@Autowired
	StudentJpaRepository repository;
	
	public String calculateGrade(int id) throws StudentNotFoundException{
		Optional<Student> optional=repository.findById(id);
		if(!optional.isPresent()) {
			throw new StudentNotFoundException("Student not found");
		}
		int sum=0;
		List<Test> tests=optional.get().getTest();
		Iterator it=tests.iterator();
		int total=tests.size();
		while(it.hasNext()) {
			Test test=(Test)it.next();
			sum+=test.getMarks();
		}
		if(tests.size()==0)
			return "Q";
		int grade=sum/total;
		
		if(grade>80)
			return "A";
		return "Q";
	}
	
	public Optional<List<Student>> getToppers() {
		List<Student> students=repository.findAll();
		List<Student> toppers=new ArrayList<Student>();
		if(students.size()>0)
		{
			students.forEach(s->{
				String g;
				try {
					g = calculateGrade(s.getId());
					if(g.equals("A"))
						toppers.add(s);
					
				} catch (StudentNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			});
		}
		
		return Optional.of(toppers);
	}
}
