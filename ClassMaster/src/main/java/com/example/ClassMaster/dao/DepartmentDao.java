package com.example.ClassMaster.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ClassMaster.entity.Department;

@Repository
public class DepartmentDao {

	@Autowired
	SessionFactory factory;

	public List<Department> getAllDepartment() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Department.class);
		List<Department> list = criteria.list();
		return list;
	}

	public Department getDepartmentById(long departmentId) {
		Session session = factory.openSession();
		Department department = session.get(Department.class, departmentId);
		return department;
	}

	public boolean insertDepartment(Department department) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(department);
		transaction.commit();
		return true;
	}

	public boolean updateDepartmentNameById(long departmentId, String deptName) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Department department = session.get(Department.class, departmentId);
		if (department != null) {
			department.setDepartmentName(deptName);
		}
		return true;
	}

	public boolean deleteDepartmentById(long departmentId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Department department = session.get(Department.class, departmentId);
		if (department != null) {
			session.delete(department);
		}
		return true;
	}

}
