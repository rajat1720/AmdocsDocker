package com.training.spring.boot.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity
//@Table(name="STUD") -> If we want to give table name different than class name
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long StudId;
	private String studName;
	private int age;
//	@Column(name = "stud_grade")  // If we want to given column name different than variable name
	private String grade;
	
	public Student(String studName,int age, String grade){
		super();
		this.studName = studName;
		this.age = age;
		this.grade = grade;
	}
//	public Student(){
//	}
}
