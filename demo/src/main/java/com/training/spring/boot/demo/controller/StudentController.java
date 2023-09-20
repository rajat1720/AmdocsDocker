package com.training.spring.boot.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.boot.demo.model.Student;
import com.training.spring.boot.demo.repository.StudentRepository;

@RestController
@RequestMapping("/studapi")
public class StudentController {
	@Autowired
	StudentRepository repository;
	
	@GetMapping("/stud")
	public List<Student> getStud() {
//		List<Student> studList = new ArrayList<>();
//		studList.add(new Student("Rajat",21,"A+"));
//		studList.add(new Student("Naman",21,"A"));
//		studList.add(new Student("Raj",21,"B+"));
//		studList.add(new Student("Aman",21,"A"));
		return repository.findAll();
	}
	@GetMapping("/stud/{id}")
	public Student getById(@PathVariable("id") long id) {
		Optional<Student> stud = repository.findById(id);
		if(stud.isPresent()) {
			return stud.get();
		}
		else {
			return null;
		}
	}
	
	@PostMapping("/stud")
	public Student getStud(@RequestBody long id) {
		Optional<Student> stud = repository.findById(id);
		if(stud.isPresent()) {
			return stud.get();
		}
		else {
			return null;
		}
	}
	
	@PutMapping("/stud/{id}")
	public void updateUser(@PathVariable("id") long id,@RequestBody Student stud) {
		Optional<Student> oldData = repository.findById(id);
		if(oldData.isPresent()) {
			Student std = oldData.get();
			std.setAge(stud.getAge());
			std.setStudName(stud.getStudName());
			std.setGrade(std.getGrade());
			repository.save(stud);
		}
		else {
			System.out.println("no data found");
		}
	}
	
	@PostMapping("/post")
	public void post(@RequestBody Student stud) {
		repository.save(stud);
	}
}
