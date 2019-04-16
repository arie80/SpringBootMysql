package com.arie80.student.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "balance")
@EntityListeners(AuditingEntityListener.class)
public class Balance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "payment")
	private Double payment;
	
	@Column(name = "total_cost")
	private Double totalCost;
	
	@Column(name = "tuition_balance")
	private Double tuitionBalance;
	
    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", updatable = false)
	@CreatedDate
	private Date created;
	
	public Balance() {}
	
	public Balance(Double payment) {
		this.payment = payment;
	}
	
	public Balance(Double payment, Double totalCost, Double tuitionBalance) {
		this.payment = payment;
		this.totalCost = totalCost;
		this.tuitionBalance = tuitionBalance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getPayment() {
		return payment;
	}

	public void setPayment(Double payment) {
		this.payment = payment;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public Double getTuitionBalance() {
		return tuitionBalance;
	}

	public void setTuitionBalance(Double tuitionBalance) {
		this.tuitionBalance = tuitionBalance;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;

	}

	@Override
	public String toString() {
		return "Balance [id=" + id + ", payment=" + payment + ", totalCost=" + totalCost + ", tuitionBalance="
				+ tuitionBalance + ", created=" + created + "]";
	}
	
}
