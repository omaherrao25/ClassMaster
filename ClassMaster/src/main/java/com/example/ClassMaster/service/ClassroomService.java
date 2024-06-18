package com.example.ClassMaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ClassMaster.dao.ClassroomDao;
import com.example.ClassMaster.entity.Classroom;

@Service
public class ClassroomService {

	@Autowired
	private ClassroomDao dao;

	public List<Classroom> getAllClassrooms() {
		if (dao.getAllClassrooms() != null) {
			return dao.getAllClassrooms();
		} else {
			return null;
		}

	}

	public Classroom getClassroomById(long classroomId) {
		if (dao.getClassroomById(classroomId) != null) {
			return dao.getClassroomById(classroomId);
		} else {
			return null;
		}

	}

	public String insertClassroom(Classroom classroom) {
		if (dao.insertClassroom(classroom)) {
			return "Classroom inserted successfully...";
		} else {
			return "Classroom not inserted";
		}

	}

	public String updateClassroom(long classroomId, String classroom_name) {
		if (dao.updateClassroom(classroomId, classroom_name)) {
			return "Classroom name updated successfully...";
		} else {
			return "Classroom name not updated";
		}

	}

	public String deleteClassroomById(long classroomId) {
		if (dao.deleteClassroomById(classroomId)) {
			return "Classroom deleted successfully";
		} else {
			return "Classroom not deleted";
		}
	}

}
