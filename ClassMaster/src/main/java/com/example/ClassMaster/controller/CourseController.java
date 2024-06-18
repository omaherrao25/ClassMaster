package com.example.ClassMaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ClassMaster.entity.Course;
import com.example.ClassMaster.service.CourseService;

@RestController
@RequestMapping("course")
public class CourseController {

	@Autowired
	private CourseService service;

	@GetMapping("get-all-courses")
	public List<Course> getAllCourses() {
		return service.getAllCourses();
	}

	@GetMapping("get-course/{courseId}")
	public Course getCourseById(@PathVariable long courseId) {
		return service.getCourseById(courseId);
	}

	@PostMapping("insert-course")
	public String insertCourse(@RequestBody Course course) {
		return service.insertCourse(course);
	}

	@PutMapping("update-course-name/{courseId}/{courseName}")
	public String updateCourseNameById(@PathVariable long courseId, @PathVariable String courseName) {
		return service.updateCourseNameById(courseId, courseName);
	}

	@DeleteMapping("delete-course-by-id/{courseId}")
	public String deleteCourseById(@PathVariable long courseId) {
		return service.deleteCourseById(courseId);
	}
}
