package com.arie80.student.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "student")
@EntityListeners(AuditingEntityListener.class)
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Size(min = 2, max = 30, message = "Name should have atleast 2 characters")
	@Column(name = "name")
	private String name;

	@Column(name = "grade")
	private String grade;

	@Column(name = "status")
	private Boolean status;

	@Column(name = "student_id", updatable = false)
	private String studentId;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
	private Set<Course> courses;

	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Balance balance;

	
	  @Transient private Double payment;
	  
	  @Transient private Double totalCost;
	  
	  @Transient private Double tuitionBalance;
	 

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", updatable = false)
	@CreatedDate
	private Date created;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified")
	@LastModifiedDate
	private Date modified;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Balance getBalance() {
		return balance;
	}

	public void setBalance(Balance balance) {
		this.balance = balance;
	}

	
	  public Double getPayment() { return payment; }
	  
	  public void setPayment(Double payment) { this.payment = payment; }
	  
	  public Double getTotalCost() { return totalCost; }
	  
	  public void setTotalCost(Double totalCost) { this.totalCost = totalCost; }
	  
	  public Double getTuitionBalance() { return tuitionBalance; }
	  
	  public void setTuitionBalance(Double tuitionBalance) { this.tuitionBalance =
	  tuitionBalance; }
	  
	 
	
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", grade=" + grade + ", status=" + status + ", studentId="
				+ studentId + ", courses=" + courses + ", payment=" + payment + ", totalCost=" + totalCost
				+ ", tuitionBalance=" + tuitionBalance + ", created=" + created + ", modified=" + modified + "]";
	}

}
