package com.wipro.diet.app.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Belowmsgs")
public class BelowMsgs {
		public BelowMsgs() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Column(name="time")
	private String time;
	
	@Column(name="fname")
	private String fname;
	
	@Column(name="msg")
	private String msg;
	
	@Column(name="access")
	private String access;
	
	@Id
	@GeneratedValue
	@Column(name="slno")
	private int slno;

	public BelowMsgs(String fname, String msg,String time,String access) {
		super();
		this.time = time;
		this.fname = fname;
		this.msg = msg;
		this.access = access;

	}



	
	
	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
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


	public String getAccess() {
		return access;
	}


	public void setAccess(String access) {
		this.access = access;
	}


	@Override
	public String toString() {
		return "BelowMsgs [time=" + time + ", fname=" + fname + ", msg=" + msg + ", access=" + access + "]";
	}





	public int getSlno() {
		return slno;
	}





	public void setSlno(int slno) {
		this.slno = slno;
	}
}
