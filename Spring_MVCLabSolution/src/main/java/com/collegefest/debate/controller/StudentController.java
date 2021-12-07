package com.collegefest.debate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.collegefest.debate.model.Student;
import com.collegefest.debate.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/info")
	@ResponseBody
	public Student get() {
		return studentService.get();
	}

	@RequestMapping("/list")
	public String listStudents(Model theModel) {
		List<Student> theStudents = studentService.findAll();
		theModel.addAttribute("Students", theStudents);
		return "list-students";
	}

	@RequestMapping("/show-add-form")
	public String showAddForm(Model theModel) {
		Student theStudent = new Student();
		theModel.addAttribute("Student", theStudent);
		return "edit-student";
	}

	@RequestMapping("/show-update-form")
	public String showUpdateForm(@RequestParam("studentId") int theId, Model theModel) {
		Student theStudent = studentService.findById(theId);
		theModel.addAttribute("Student", theStudent);
		return "edit-student";
	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {
		System.out.println(id);
		Student theStudent;
		if (id != 0) {
			theStudent = studentService.findById(id);
			theStudent.setName(name);
			theStudent.setDepartment(department);
			theStudent.setCountry(country);
		} else {
			theStudent = new Student();
			theStudent.setName(name);
			theStudent.setDepartment(department);
			theStudent.setCountry(country);
		}
		studentService.save(theStudent);
		return "redirect:/students/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {
		studentService.deleteById(theId);
		return "redirect:/students/list";
	}
}
