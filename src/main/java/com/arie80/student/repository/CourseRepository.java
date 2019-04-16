package com.arie80.student.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.arie80.student.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}