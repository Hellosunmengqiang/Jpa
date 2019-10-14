package com.smq.jpademo.model;


import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Table(name="t_user")
@Entity
public class User {
	private int id;
	private String username;
	private String pasword;
	/*@Temporal(TemporalType.DATE)//time/timestamp
	private Date date;//天*/
	
	//@Basic(fetch = FetchType.LAZY)//EAGER
	//private UserInfo info;   //mybatis 默认关闭懒加载，hibernate默认开启懒加载，jpa默认开启立即加载
	
	@Transient
	private String age;//jpa生成表时忽略此字段
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="user_name")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", pasword=" + pasword + "]";
	}
	public User() {
		super();
	}
	
	

}
