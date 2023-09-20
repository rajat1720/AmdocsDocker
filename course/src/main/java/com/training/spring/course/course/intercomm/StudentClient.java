package com.training.spring.course.course.intercomm;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.training.spring.course.course.model.Student;

//@FeignClient(name="student",url="http://localhost:8083")
@FeignClient(name="STUDENT-SERVICE")
public interface StudentClient {
	@PostMapping(value="/studapi/stud",consumes = "application/json")
	Student getStudent(@RequestBody int studId);
}
