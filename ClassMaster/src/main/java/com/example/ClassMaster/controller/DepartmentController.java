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

import com.example.ClassMaster.entity.Department;
import com.example.ClassMaster.service.DepartmentService;

@RestController
@RequestMapping("department")
public class DepartmentController {

	@Autowired
	private DepartmentService service;

	@GetMapping("all-departments")
	public List<Department> getAllDepartment() {
		return service.getAllDepartment();
	}

	@GetMapping("department-by-id/{departmentId}")
	public Department getDepartmentById(@PathVariable long departmentId) {
		return service.getDepartmentById(departmentId);
	}

	@PostMapping("insert-department")
	public String insertDepartment(@RequestBody Department department) {
		return service.insertDepartment(department);
	}

	@PutMapping("update-department-name/{departmentId}/{deptName}")
	public String updateDepartmentNameById(@PathVariable long departmentId, @PathVariable String deptName) {
		return service.updateDepartmentNameById(departmentId, deptName);
	}

	@DeleteMapping("delete-department-by-id/{departmentId}")
	public String deleteDepartmentById(@PathVariable long departmentId) {
		return service.deleteDepartmentById(departmentId);
	}
}
