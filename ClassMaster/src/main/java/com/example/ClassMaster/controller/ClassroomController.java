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

import com.example.ClassMaster.entity.Classroom;
import com.example.ClassMaster.service.ClassroomService;

@RestController
@RequestMapping("classroom")
public class ClassroomController {

	@Autowired
	private ClassroomService service;

	@GetMapping("all-classrooms")
	public List<Classroom> getAllClassrooms() {
		return service.getAllClassrooms();
	}

	@GetMapping("classroom-by-Id/{classroomId}")
	public Classroom getClassroomById(@PathVariable long classroomId) {
		return service.getClassroomById(classroomId);
	}

	@PostMapping("insert-classroom")
	public String insertClassroom(@RequestBody Classroom classroom) {
		return service.insertClassroom(classroom);
	}

	@PutMapping("update-classroom-name-by-id/{classroomId}/{classroom_name}")
	public String updateClassroom(@PathVariable long classroomId, @PathVariable String classroom_name) {
		return service.updateClassroom(classroomId, classroom_name);
	}

	@DeleteMapping("delete-classroom-by-id/{classroomId}")
	public String deleteClassroomById(@PathVariable long classroomId) {
		return service.deleteClassroomById(classroomId);
	}
}
