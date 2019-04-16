package com.arie80.student.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arie80.student.model.Course;
import com.arie80.student.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public Iterable<Course> findAll() {
		return courseRepository.findAll();
	}

	public Optional<Course> findById(int id) {
		return courseRepository.findById(id);
	}

	public Course save(Course course) {
		return courseRepository.save(course);
	}

	public void deleteById(int id) {
		courseRepository.deleteById(id);
	}
	
	public Iterable<Course> findAllById(Iterable<Integer> id) {
		return courseRepository.findAllById(id);
	}
}
