package com.example.assignment2.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table
public class Student {
	
	@GeneratedValue
	@Id
	private int id;
	private String name;
	private int age;
	
	@OneToMany(mappedBy="student")
	private List<Test> test;
	
	

	public Student() {
		
	}



	public Student(int id, String name, int age, List<Test> test) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.test = test;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public List<Test> getTest() {
		return test;
	}



	public void setTest(List<Test> test) {
		this.test = test;
	}
	
	
	
}
