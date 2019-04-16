package com.arie80.student.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "course")
@EntityListeners(AuditingEntityListener.class)
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int Id;
	
	@Size(min=2, max=30, message="Name should have atleast 2 characters")
	@Column(name = "name")
	private String name;

	@Column(name = "cost")
	private Double cost;

	@ManyToMany(mappedBy = "courses")
	private Set<Student> students = new HashSet<>();

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", updatable = false)
	@CreatedDate
	private Date created;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified")
	@LastModifiedDate
	private Date modified;

	@Transient
	private String selected;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Set<Student> getUsers() {
		return students;
	}

	public void setUsers(Set<Student> students) {
		this.students = students;
	}

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

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	@Override
	public String toString() {
		return "Course [Id=" + Id + ", name=" + name + ", cost=" + cost + ", created=" + created + ", modified="
				+ modified + ", selected=" + selected + "]";
	}
}
