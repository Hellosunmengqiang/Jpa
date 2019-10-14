package com.smq.jpademo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="t_Students")
@Entity
public class Students {
	private int id;
	private String StudentName;
	private ClassTeacher classTeacher;//单向多对一
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	@ManyToOne(fetch=FetchType.LAZY) //开启懒加载
	@JoinColumn(name="class_teac_id")//外键名称
	public ClassTeacher getClassTeacher() {
		return classTeacher;
	}
	public void setClassTeacher(ClassTeacher classTeacher) {
		this.classTeacher = classTeacher;
	}
	@Override
	public String toString() {
		return "Students [id=" + id + ", StudentName=" + StudentName + ", classTeacher=" + classTeacher + "]";
	}
	

}
