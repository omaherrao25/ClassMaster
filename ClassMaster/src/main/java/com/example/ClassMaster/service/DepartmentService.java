package com.example.ClassMaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ClassMaster.dao.DepartmentDao;
import com.example.ClassMaster.entity.Department;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentDao dao;

	public List<Department> getAllDepartment() {
		if (dao.getAllDepartment() != null) {
			return dao.getAllDepartment();
		} else {
			return null;
		}

	}

	public Department getDepartmentById(long departmentId) {
		if (dao.getDepartmentById(departmentId) != null) {
			return dao.getDepartmentById(departmentId);
		} else {
			return null;
		}

	}

	public String insertDepartment(Department department) {
		if (dao.insertDepartment(department)) {
			return "Department inserted successfully";
		} else {
			return "Department not inserted";
		}

	}

	public String updateDepartmentNameById(long departmentId, String deptName) {
		if (dao.updateDepartmentNameById(departmentId, deptName)) {
			return "Department name updated successfully";
		} else {
			return "Department name not updated";
		}

	}

	public String deleteDepartmentById(long departmentId) {
		if (dao.deleteDepartmentById(departmentId)) {
			return "Department deleted successfully";
		} else {
			return "Department not deleted";
		}
	}

}
