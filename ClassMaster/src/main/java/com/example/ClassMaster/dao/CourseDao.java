package com.example.ClassMaster.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ClassMaster.entity.Course;

@Repository
public class CourseDao {

	@Autowired
	private SessionFactory factory;

	public List<Course> getAllCourses() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Course.class);
		List<Course> list = criteria.list();
		return list;
	}

	public Course getCourseById(long courseId) {
		Session session = factory.openSession();
		Course course = session.get(Course.class, courseId);
		return course;
	}

	public boolean insertCourse(Course course) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(course);
		transaction.commit();
		return true;
	}

	public boolean updateCourseNameById(long courseId, String courseName) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Course course = session.get(Course.class, courseId);
		if (course!=null) {
			course.setCourseName(courseName);
			session.update(course);
		}
		transaction.commit();
		return true;
	}

	public boolean deleteCourseById(long courseId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Course course = session.get(Course.class, courseId);
		if (course!=null) {
			session.delete(course);
		}
		transaction.commit();
		return true;
	}

}
