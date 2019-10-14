package com.smq.jpademo.model5;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Table(name="t_cour")
@Entity
public class Stu {
	private int id;
	private String stuName;
	private List<StuCour> stucours;//双向一对多，这里是一；（也就是一个多对多变成两个一对多）
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
	@OneToMany(mappedBy="stu")
	public List<StuCour> getStucours() {
		return stucours;
	}
	public void setStucours(List<StuCour> stucours) {
		this.stucours = stucours;
	}
	
	

}
