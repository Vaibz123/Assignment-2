package com.example.assignment2.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.assignment2.entity.Student;


public interface StudentJpaRepository extends JpaRepository<Student, Integer> {

}
