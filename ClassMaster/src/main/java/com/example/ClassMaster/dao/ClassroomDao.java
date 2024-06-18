package com.example.ClassMaster.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ClassMaster.entity.Classroom;

@Repository
public class ClassroomDao {

	@Autowired
	private SessionFactory factory;

	public List<Classroom> getAllClassrooms() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Classroom.class);
		List<Classroom> list = criteria.list();
		return list;
	}

	public Classroom getClassroomById(long classroomId) {
		Session session = factory.openSession();
		Classroom classroom = session.get(Classroom.class, classroomId);
		return classroom;
	}

	public boolean insertClassroom(Classroom classroom) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(classroom);
		transaction.commit();
		return true;
	}

	public boolean updateClassroom(long classroomId, String classroom_name) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Classroom classroom = session.get(Classroom.class, classroomId);
		if (classroom != null) {
			classroom.setClassroomName(classroom_name);
		}
		transaction.commit();
		return true;
	}

	public boolean deleteClassroomById(long classroomId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Classroom classroom = session.get(Classroom.class, classroomId);
		if (classroom != null) {
			session.delete(classroom);;
		}
		transaction.commit();
		return true;
	}

}
