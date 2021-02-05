package com.example.assignment2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assignment2.entity.Test;

public interface TestJpaRepository extends JpaRepository<Test, Integer>{

}
