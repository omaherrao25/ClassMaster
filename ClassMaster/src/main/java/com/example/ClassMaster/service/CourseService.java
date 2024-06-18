package com.example.ClassMaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ClassMaster.dao.CourseDao;
import com.example.ClassMaster.entity.Course;

@Service
public class CourseService {

	@Autowired
	private CourseDao dao;

	public List<Course> getAllCourses() {
		if (dao.getAllCourses() != null) {
			return dao.getAllCourses();
		} else {
			return null;
		}
	}

	public Course getCourseById(long courseId) {
		if (dao.getCourseById(courseId) != null) {
			return dao.getCourseById(courseId);
		} else {
			return null;
		}

	}

	public String insertCourse(Course course) {
		if (dao.insertCourse(course)) {
			return "Course inserted successfully";
		} else {
			return "Course not inserted";
		}
		
	}

	public String updateCourseNameById(long courseId, String courseName) {
		if (dao.updateCourseNameById(courseId, courseName)) {
			return "Course name updated successfully";
		} else {
			return "Course name not updated";
		}
		
	}

	public String deleteCourseById(long courseId) {
		if (dao.deleteCourseById(courseId)) {
			return "Course deleted successfully";
		} else {
			return "Course not updated";
		}
		
	}

}
