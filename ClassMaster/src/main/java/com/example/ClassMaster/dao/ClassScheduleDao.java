package com.example.ClassMaster.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ClassMaster.entity.ClassSchedule;

@Repository
public class ClassScheduleDao {

	@Autowired
	private SessionFactory factory;

	public List<ClassSchedule> getAllClassSchedules() {
		System.err.println(13);
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(ClassSchedule.class);
		List<ClassSchedule> list = criteria.list();
		System.err.println(22);
		System.err.println(list);
		return list;
	}

	public ClassSchedule getClassScheduleById(long classScheduleId) {
		Session session = factory.openSession();
		ClassSchedule classSchedule = session.get(ClassSchedule.class, classScheduleId);
		return classSchedule;
	}

	public boolean insertClassSchedule(ClassSchedule classSchedule) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(classSchedule);
		transaction.commit();
		return true;
	}

	public boolean updateClassSchedule(long classScheduleId, String dayOfWeek) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		ClassSchedule classSchedule = session.get(ClassSchedule.class, classScheduleId);
		if (classSchedule != null) {
			classSchedule.setDayOfWeek(dayOfWeek);
		}
		transaction.commit();
		return true;
	}

	public boolean deleteClassSchedule(long classScheduleId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		ClassSchedule classSchedule = session.get(ClassSchedule.class, classScheduleId);
		if (classSchedule != null) {
			session.delete(classSchedule);
		}
		transaction.commit();
		return true;
	}

}
