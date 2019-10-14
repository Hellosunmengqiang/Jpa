package com.smq.jpademo.model5;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="t_stu_cour")
@Entity
public class StuCour {
	private int id;	
	private Stu stu;  //多的这个
	private Cour cour;//多的这个
	private int score;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name="stu_id")
	public Stu getStu() {
		return stu;
	}
	public void setStu(Stu stu) {
		this.stu = stu;
	}
	@ManyToOne
	@JoinColumn(name="cour_id")
	public Cour getCour() {
		return cour;
	}
	public void setCour(Cour cour) {
		this.cour = cour;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	

}
