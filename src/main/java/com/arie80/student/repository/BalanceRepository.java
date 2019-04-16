package com.arie80.student.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.arie80.student.model.Balance;

public interface BalanceRepository extends JpaRepository<Balance, Integer>{
	Balance findByStudentId(int studentId);
}