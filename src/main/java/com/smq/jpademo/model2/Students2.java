package com.smq.jpademo.model2;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="t_Students2")
@Entity
public class Students2 {
	private int id;
	private String StudentName;
	private ClassTeacher2 classTeacher;
	
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
	
	@JoinColumn(name="class_teac_id")//外键名称
	@ManyToOne
	public ClassTeacher2 getClassTeacher() {
		return classTeacher;
	}
	public void setClassTeacher(ClassTeacher2 classTeacher) {
		this.classTeacher = classTeacher;
	}
	@Override
	public String toString() {
		return "Students [id=" + id + ", StudentName=" + StudentName + ", classTeacher=" + classTeacher + "]";
	}
	

}
