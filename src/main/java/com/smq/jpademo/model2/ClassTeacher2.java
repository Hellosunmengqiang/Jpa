package com.smq.jpademo.model2;

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

@Table(name="t_classTeacher2")
@Entity
public class ClassTeacher2 {
	private int id;
	private String ClassTeacherName;
	
	
	private List<Students2> students2s;//双向一对多==多对一
	

	@OneToMany(mappedBy="classTeacher")//mapperBy维护多的这边，此时不需要JoinColunm("student_id"),也就是一放弃维护
	public List<Students2> getStudents2s() {
		return students2s;
	}
	public void setStudents2s(List<Students2> students2s) {
		this.students2s = students2s;
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
