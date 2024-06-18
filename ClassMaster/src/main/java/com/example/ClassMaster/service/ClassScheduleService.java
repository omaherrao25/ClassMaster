package com.example.ClassMaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ClassMaster.dao.ClassScheduleDao;
import com.example.ClassMaster.entity.ClassSchedule;

@Service
public class ClassScheduleService {

	@Autowired
	private ClassScheduleDao dao;

	public List<ClassSchedule> getAllClassSchedules() {
		System.err.println(12);

		return dao.getAllClassSchedules();
	}

	public ClassSchedule getClassScheduleById(long classScheduleId) {
		if (dao.getClassScheduleById(classScheduleId) != null) {
			return dao.getClassScheduleById(classScheduleId);
		} else {
			return null;
		}
	}

	public String insertClassSchedule(ClassSchedule classSchedule) {
		if (dao.insertClassSchedule(classSchedule)) {
			return "Class Schedule inserted successfully";
		} else {
			return "Class schedule not inserted";
		}
	}

	public String updateClassSchedule(long classScheduleId, String dayOfWeek) {
		if (dao.updateClassSchedule(classScheduleId, dayOfWeek)) {
			return "Class Schedule day updated successfully";
		} else {
			return "Class Schedule day not updated";
		}
	}

	public String deleteClassSchedule(long classScheduleId) {
		if (dao.deleteClassSchedule(classScheduleId)) {
			return "Class schedule deleted successfully";
		} else {
			return "Class schedule not deleted";
		}
		
	}

}
