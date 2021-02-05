package com.example.assignment2.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	
	@RequestMapping("/view-student")
	public String listStudents(){
		return "view-student";
	}
	
	@RequestMapping(value="/add-student")
	public String addStudent() {
		return "add-student";
	}

	@RequestMapping(value="/add-test")
	public String addTest() {
		return "add-test";
	}
}
