package com.arie80.student.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arie80.student.model.Balance;
import com.arie80.student.repository.BalanceRepository;

@Service
public class BalanceService {

	@Autowired
	private BalanceRepository balanceRepository;
	
	public Iterable<Balance> findAll() {
		return balanceRepository.findAll();
	}

	public Optional<Balance> findById(int id) {
		return balanceRepository.findById(id);
	}

	public Balance save(Balance balance) {
		return balanceRepository.save(balance);
	}

	public void deleteById(int id) {
		balanceRepository.deleteById(id);
	}

	public Balance findByStudentId(int studentId) {
		return balanceRepository.findByStudentId(studentId);
	}
}
