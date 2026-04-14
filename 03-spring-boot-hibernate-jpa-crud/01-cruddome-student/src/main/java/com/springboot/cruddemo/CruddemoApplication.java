package com.springboot.cruddemo;

import com.springboot.cruddemo.dao.StudentDao;
import com.springboot.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner ->{
			//createStudent(studentDao);
			createMultipleStudents(studentDao);
			//readStudent(studentDao);
			//queryForStudents(studentDao);
			//queryForStudentsByLastName(studentDao);
			//updateStudent(studentDao);
			//deleteStudent(studentDao);
			//deleteAllStudents(studentDao);
		};
	}

	private void deleteAllStudents(StudentDao studentDao) {
		System.out.println("Deleting all students");
		int count = studentDao.deleteAll();
		System.out.println("Deleted " + count + " students");
	}

	private void deleteStudent(StudentDao studentDao) {
		int studentId = 3;
		System.out.println("Deleting student: " + studentId);
		studentDao.delete(studentId);
	}

	private void updateStudent(StudentDao studentDao) {
		//retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student student = studentDao.findById(studentId);

		//change first name to "Scooby"
		System.out.println("Updating student...");
		student.setFirstName("Scooby");

		//update the student
		studentDao.update(student);

		//display the updated student
		System.out.println("Updating student: " + student);
	}

	private void queryForStudentsByLastName(StudentDao studentDao) {
		//get a list of students
		List<Student> students = studentDao.findByFirstName("Luna");
		//display list of students
		for(Student student : students) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDao studentDao) {
		//get a list of students
		List<Student> students = studentDao.findAll();

		//display the list of student
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDao studentDao) {
		//create a student object
		System.out.println("Creating 3 student object...");
		Student tempStudent = new Student("Daffy", "Dao", "daffy@gmail.com");

		//save the student
		System.out.println("Saving the student object...");
		studentDao.save(tempStudent);

		//display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student with id " + theId);

		//retrieve student based on the id: primary key
		System.out.println("Retrieving student with id " + theId);
		Student myStudent = studentDao.findById(theId);

		//display student
		System.out.println("Found student " + myStudent);
	}

	private void createMultipleStudents(StudentDao studentDao) {
		//create multiple students
		System.out.println("Creating 3 student object...");
		Student tempStudent1 = new Student("John", "Dao", "john@gmail.com");
		Student tempStudent2 = new Student("Mary", "Dao", "mary@gmail.com");
		Student tempStudent3 = new Student("Luna", "Dao", "luna@gmail.com");
		//save the student object
		System.out.println("Saving the student object...");
		studentDao.save(tempStudent1);
		studentDao.save(tempStudent2);
		studentDao.save(tempStudent3);
	}

	private void createStudent(StudentDao studentDao) {
		//create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul", "Dao", "paul@gmail.com");

		//save the student object
		System.out.println("Saving the student object...");
		studentDao.save(tempStudent);

		//display id of the saved student
		System.out.println("Save student. Generated id: " + tempStudent.getId());
	}

}
