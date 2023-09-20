package com.training.spring.course.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.spring.course.course.model.Course;

public interface CourseRepository extends JpaRepository<Course,Long> {

}
