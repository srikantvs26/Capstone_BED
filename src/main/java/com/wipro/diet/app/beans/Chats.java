package com.wipro.diet.app.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Chats")
public class Chats {



	@Column(name="time")
	private String time;
	
	@Column(name="f")
	private String f;
	@Column(name="fmail")
	private String fmail;
	@Column(name="t")
	private String t;
	@Column(name="tmail")
	private String tmail;
	
	@Column(name="msg")
	private String msg;
	
	@Column(name="status")
	private String status;
	
	@Id
	@GeneratedValue
	@Column(name="slno")
	private int slno;

	public Chats() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Chats(String time, String f, String fmail, String t, String tmail, String msg) {
		super();
		
		this.time = time;
		this.f = f;
		this.fmail = fmail;
		this.t = t;
		this.tmail = tmail;
		this.msg = msg;

	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getF() {
		return f;
	}


	public void setF(String f) {
		this.f = f;
	}


	public String getFmail() {
		return fmail;
	}


	public void setFmail(String fmail) {
		this.fmail = fmail;
	}


	public String getT() {
		return t;
	}


	public void setT(String t) {
		this.t = t;
	}


	public String getTmail() {
		return tmail;
	}


	public void setTmail(String tmail) {
		this.tmail = tmail;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getSlno() {
		return slno;
	}

	public void setSlno(int slno) {
		this.slno = slno;
	}
	
	
}
