package com.collegefest.debate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//import com.collegefest.debate.model.Student;

@SpringBootApplication(scanBasePackages = "com.collegefest.debate")
public class SpringMvcLabSolutionApplication extends SpringBootServletInitializer implements CommandLineRunner {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringMvcLabSolutionApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcLabSolutionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * Student student = new Student();
		 * 
		 * student.setStudentId(1); student.setStudentName("Anubhav");
		 * student.setStudentDept("IT"); student.setCountry("India");
		 * System.out.println("Student " + student);
		 */

	}
}
