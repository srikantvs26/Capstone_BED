package com.wipro.diet.app.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {

@Id
@Column(name="userid")
private String userId;

@Column(name="fname")
private String fname;

@Column(name="lname")
private String lname;

@Column(name="email")
private String email;

@Column(name="password")
private String password;

@Column(name="type")
private String type;

@Column(name="division")
private int division;

@Column(name="doj")
private String doj ;

public User() {}
//@Override()
//public String toString()
//{
//	return "User [userId=" + userId + ",fname=" + fname +",lname=" + lname +",email=" +email + ", password=" + password +", type=" + type +",division=" + division +"]";
//	
//}

public User(String userId, String fname, String lname, String email, String password, String type, int division, String doj) {
	super();
	this.userId = userId;
	this.fname = fname;
	this.lname = lname;
	this.email = email;
	this.password = password;
	this.type = type;
	this.division = division;
	this.doj=doj;
}

public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public int getDivision() {
	return division;
}
public void setDivision(int division) {
	this.division = division;
}
public String getDoj() {
	return doj;
}
public void setDoj(String doj) {
	this.doj = doj;
}

}
