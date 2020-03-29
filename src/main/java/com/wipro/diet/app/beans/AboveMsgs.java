package com.wipro.diet.app.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Abovemsgs")
public class AboveMsgs {


	@Column(name="time")
	private String time;
	
	@Column(name="fname")
	private  String fname;
	
	@Column(name="msg")
	private String msg;
	
	@Column(name="access")
	private String access;
	
	@Id
	@GeneratedValue
	@Column(name="slno")
	private int slno;

	public AboveMsgs() {
		super();
		// TODO Auto-generated constructor 
	}

	
	public AboveMsgs(String fname, String msg, String time, String access) {
		super();
		this.fname = fname;
		this.msg = msg;
		this.time = time;
		this.access = access;

	}
	
	
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}


	public int getSlno() {
		return slno;
	}


	public void setSlno(int slno) {
		this.slno = slno;
	}

}
