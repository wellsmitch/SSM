package com.song.pojo;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String username;
	private String sex;
	private String address;
	private Date date;



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", sex=" + sex + ", address=" + address + ", date=" + date
				+ "]";
	}

}
