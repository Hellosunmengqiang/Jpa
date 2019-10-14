package com.smq.jpademo.model4;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="t_student")
public class Student {
	private int id;
	private String stuName;
	private List<Course> courses;//双向多对多
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	@ManyToMany
	@JoinTable(name="t_student_course",
	joinColumns= {@JoinColumn(name="student_id",referencedColumnName="id")},
	inverseJoinColumns= {@JoinColumn(name="course_id",referencedColumnName="id")})
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	

}
