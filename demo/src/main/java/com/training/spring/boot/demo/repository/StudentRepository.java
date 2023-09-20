package com.training.spring.boot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.spring.boot.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
