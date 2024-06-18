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

import com.example.ClassMaster.entity.ClassSchedule;
import com.example.ClassMaster.service.ClassScheduleService;

@RestController
@RequestMapping("ClassSchedule")
public class ClassScheduleController {

	@Autowired
	private ClassScheduleService service;

	@GetMapping("all-schedules")
	public List<ClassSchedule> getAllClassSchedules() {
		System.out.println(11);
		return service.getAllClassSchedules();
	}

	@GetMapping("class-schedule-by-id/{classScheduleId}")
	public ClassSchedule getClassScheduleById(@PathVariable long classScheduleId) {
		return service.getClassScheduleById(classScheduleId);
	}

	@PostMapping("insert-class-schedule")
	public String insertClassSchedule(@RequestBody ClassSchedule classSchedule) {
		return service.insertClassSchedule(classSchedule);
	}

	@PutMapping("update-class-schedule-day/{classScheduleId}/{dayOfWeek}")
	public String updateClassSchedule(@PathVariable long classScheduleId, @PathVariable String dayOfWeek) {
		return service.updateClassSchedule(classScheduleId, dayOfWeek);
	}

	@DeleteMapping("delete-class-schedule/{classScheduleId}")
	public String deleteClassSchedule(@PathVariable long classScheduleId) {
		return service.deleteClassSchedule(classScheduleId);
	}
}
