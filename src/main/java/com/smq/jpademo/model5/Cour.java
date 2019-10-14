package com.smq.jpademo.model5;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="t_stu")
@Entity
public class Cour {
	private int id;
	private String courName;
	private List<StuCour> stucours;//双向一对多，这里是一；（也就是一个多对多变成两个一对多）
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourName() {
		return courName;
	}
	public void setCourName(String courName) {
		this.courName = courName;
	}
	@OneToMany(mappedBy="cour")
	public List<StuCour> getStucours() {
		return stucours;
	}
	public void setStucours(List<StuCour> stucours) {
		this.stucours = stucours;
	}
	
	
}
