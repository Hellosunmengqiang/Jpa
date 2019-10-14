package com.smq.jpademo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="t_classTeacher")
@Entity
public class ClassTeacher {
	private int id;
	private String ClassTeacherName;
	
	
	private List<Students> list;//单向一对多，去掉Students类的ClassTeacher属性
	
	@JoinColumn(name="stu_id")
	@OneToMany(fetch=FetchType.LAZY,cascade= {CascadeType.REMOVE})//级联删除
	public List<Students> getList() {
		return list;
	}
	public void setList(List<Students> list) {
		this.list = list;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassTeacherName() {
		return ClassTeacherName;
	}
	public void setClassTeacherName(String classTeacherName) {
		ClassTeacherName = classTeacherName;
	}
	@Override
	public String toString() {
		return "ClassTeacher [id=" + id + ", ClassTeacherName=" + ClassTeacherName + "]";
	}
	

}
