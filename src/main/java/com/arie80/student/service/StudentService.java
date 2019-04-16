package com.arie80.student.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arie80.student.model.Student;
import com.arie80.student.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public Iterable<Student> findAll() {
		return studentRepository.findAll();
	}

	public Optional<Student> findById(int id) {
		return studentRepository.findById(id);
	}

	public Student save(Student student) {
		/*
		 * Generate Student Id first time created
		 */
		if (student.getId() == 0)  {
			student.setStudentId(generateStudentId(student));
		}
		return studentRepository.save(student);
	}

	public void deleteById(int id) {
		studentRepository.deleteById(id);
	}
	
	private String generateStudentId(Student student) {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyMM");
		String dateFormat = df.format(date);
		int randomNum = (int) (Math.random() * Math.pow(10, 3));
		return "000" + dateFormat + randomNum;
	}
}
