package com.collegefest.debate.service;

import java.util.List;

import com.collegefest.debate.model.Student;

public interface StudentService {

	Student get();

	public List<Student> findAll();

	public Student findById(long theId);

	public void save(Student theStudent);

	public void deleteById(long theId);
}