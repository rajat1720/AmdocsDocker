package com.training.spring.course.course.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.course.course.intercomm.StudentClient;
import com.training.spring.course.course.model.Course;
import com.training.spring.course.course.model.Student;
import com.training.spring.course.course.repository.CourseRepository;

@RestController
@RequestMapping("/courseapi")
public class CourseController {
	@Autowired
	CourseRepository repo;
	@Autowired
	StudentClient studClient;
	
	@GetMapping("/course")
	public ResponseEntity<List<Course>> getCourse(){
		List<Course> course =  repo.findAll();
		return new ResponseEntity<>(course,HttpStatus.OK);
	}
	@GetMapping("/course/{id}")
	public Course getById(@PathVariable("id") long id) {
		Optional<Course> course = repo.findById(id);
		if(course.isPresent()) {
			return course.get();
		}
		else {
			return null;
		}
	}
	
	@PutMapping("/course/{id}")
		public void UpdateCourse(@PathVariable("id") long id, @RequestBody Course course) {
			Optional<Course> oldData = repo.findById(id);
			if(oldData.isPresent()) {
				Course cr = oldData.get();
				cr.setCourseName(cr.getCourseName());
				cr.setCourseCredit(cr.getCourseCredit());
				repo.save(cr);
			}
			else {
				System.out.println("no data found");
			}
		}
	@PostMapping("/post")
	public ResponseEntity post(@RequestBody Course course) {
		repo.save(course);
		return new ResponseEntity<>(repo.save(course),HttpStatus.CREATED);
	}
	
	@GetMapping("/service/stud/{studId}")
	public Student getStud(@PathVariable int studId) {
		return studClient.getStudent(studId);
	}
}
