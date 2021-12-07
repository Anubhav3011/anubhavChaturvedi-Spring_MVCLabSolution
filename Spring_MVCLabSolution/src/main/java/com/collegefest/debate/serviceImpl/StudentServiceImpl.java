package com.collegefest.debate.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegefest.debate.model.Student;
import com.collegefest.debate.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Override
	public Student get() {
		Student student = new Student();
		student.setId(1);
		student.setName("Anubhav");
		student.setDepartment("IT");
		student.setCountry("India");
		return student;
	}

	@SuppressWarnings("unused")
	private SessionFactory sessionFactory;

	private Session session;

	@Autowired
	StudentServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
	}

	@Transactional
	@Override
	public List<Student> findAll() {
		Transaction tx = session.beginTransaction();
		// find all the records from the database table
		@SuppressWarnings("unchecked")
		List<Student> students = session.createQuery("from Student").list();
		tx.commit();
		return students;
	}

	@Transactional
	@Override
	public Student findById(long id) {
		Student student = new Student();
		Transaction tx = session.beginTransaction();
		student = session.get(Student.class, id);
		tx.commit();
		return student;
	}

	@Transactional
	@Override
	public void save(Student theStudent) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(theStudent);
		tx.commit();
	}

	@Transactional
	@Override
	public void deleteById(long id) {
		Transaction tx = session.beginTransaction();
		Student student = session.get(Student.class, id);
		session.delete(student);
		tx.commit();
	}
}
