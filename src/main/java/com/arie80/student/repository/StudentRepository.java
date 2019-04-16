package com.arie80.student.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.arie80.student.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
