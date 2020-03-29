package com.wipro.diet.app.beans;


import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="Dailylogs")
public class DailyLogs {

	  @Id
	  @GeneratedValue
	  @Column(name = "id")
	  private Long id;
	  
	  @Column(name = "datelog")
	  private String datelog;
	  
	  @Column(name = "fname")
	  private String fname;
	  
	  @Column(name = "email")
	  private String email;
	  
	  @Column(name = "name")
	  private String name;
	    
	  @Column(name = "mimetype")
	  private String mimetype;
	  
	  @Lob
	  @Column(name="file")
	  private byte[] pic;
	  
	  @Column(name = "zone")
	  private int zone;
	  
	  public DailyLogs() {
			super();
			// TODO Auto-generated constructor stub
		}

		public DailyLogs(String date, String fname, String email,String name, String mimetype, byte[] pic, int zone) {
			super();
			this.datelog = date;
			this.fname=fname;
			this.name = name;
			this.email = email;
			this.mimetype = mimetype;
			this.pic = pic;
			this.zone = zone;
		}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDatelog() {
		return datelog;
	}

	public void setDatelog(String date) {
		this.datelog = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMimetype() {
		return mimetype;
	}

	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public int getZone() {
		return zone;
	}

	public void setZone(int zone) {
		this.zone = zone;
	}

	@Override
	public String toString() {
		return "DailyLogs [id=" + id + ", datelog=" + datelog + ", name=" + name + ", email=" + email + ", mimetype="
				+ mimetype + ", pic=" + Arrays.toString(pic) + ", zone=" + zone + "]";
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}
	  

}
