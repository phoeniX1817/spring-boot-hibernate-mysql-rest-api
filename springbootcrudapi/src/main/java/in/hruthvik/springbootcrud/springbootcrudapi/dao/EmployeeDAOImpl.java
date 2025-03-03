package in.hruthvik.springbootcrud.springbootcrudapi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.context.spi.CurrentSessionContext;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.hruthvik.springbootcrud.springbootcrudapi.model.Employee;
import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Employee> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);       // Employee , model class name
		List<Employee> list = query.getResultList();
		return list;
	}

	@Override
	public Employee get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employeeobj=currentSession.get(Employee.class,id);
		return employeeobj;
	}

	@Override
	public void save(Employee employee) {
		
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
	}

	@Override
	public void delete(int id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Employee employeeobj=currentSession.get(Employee.class,id);
		currentSession.delete(employeeobj);
		
		
	}

}
