package com.example.assignment2.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Test {

	@GeneratedValue
	@Id
	private int tid;
	private String name;
	private int marks;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private Student student;


	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Test(int tid, String name, int marks, Student student) {
		super();
		this.tid = tid;
		this.name = name;
		this.marks = marks;
		this.student = student;
	}


	public int getTid() {
		return tid;
	}


	public void setTid(int tid) {
		this.tid = tid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getMarks() {
		return marks;
	}


	public void setMarks(int marks) {
		this.marks = marks;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
}

