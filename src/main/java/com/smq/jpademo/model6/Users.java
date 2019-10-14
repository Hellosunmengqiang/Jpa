package com.smq.jpademo.model6;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(name="asas",query="select u from Users u where u.id=?1")//命名查询
@Table(name="t_users")
@Entity
public class Users {
	private int id;
	private String userName;
	private String pasword;
	private String address;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="user_name")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", pasword=" + pasword + ", address=" + address + "]";
	}
	public Users() {
		super();
	}
	public Users(String userName, String address) {
		super();
		this.userName = userName;
		this.address = address;
	}
	

}
