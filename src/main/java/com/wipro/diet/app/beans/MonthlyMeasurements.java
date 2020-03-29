package com.wipro.diet.app.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="Monthlymeasures")
public class MonthlyMeasurements {

	

	@Id
	  @GeneratedValue
	  @Column(name = "id")
	  private Long id;
	  
	  @Column(name = "fname")
	  private String fname;
	  
	  @Column(name = "email")
	  private String email;
	  
	  @Column(name = "firstname")
	  private String nameFirstF;
	  @Lob
	  @Column(name="firstfile")
	  private byte[] fileFirst;
	  @Column(name = "mimetypefirst")
	  private String mimetypeF;
	  
	  @Column(name = "secondname")
	  private String nameSecondF;
	  @Lob
	  @Column(name="secondfile")
	  private byte[] fileSecond;
	  @Column(name = "mimetypesecond")
	  private String mimetypeS;
	  
	  @Column(name = "thirdname")
	  private String nameThirdF;
	  @Lob
	  @Column(name="thirdfile")
	  private byte[] fileThird;
	  @Column(name = "mimetypethird")
	  private String mimetypeT;
	  
	  @Column(name = "zone")
	  private int zone;
	    
	public MonthlyMeasurements() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MonthlyMeasurements(String fname, String email, String nameFirstF,String nameSecondF,String nameThirdF,int zone) {
		super();
		this.fname = fname;
		this.email = email;
		this.zone = zone;
		this.nameFirstF = nameFirstF;
		this.nameSecondF = nameSecondF;
		this.nameThirdF = nameThirdF;
		this.zone = zone;
	}
	public MonthlyMeasurements(Long id, String fname, String email, String nameFirstF, byte[] fileFirst, String mimetypeF,
			String nameSecondF, byte[] fileSecond, String mimetypeS, String nameThirdF, byte[] fileThird, String mimetypeT, int zone) {
		super();
		this.id = id;
		this.fname = fname;
		this.email = email;
		this.nameFirstF = nameFirstF;
		this.fileFirst = fileFirst;
		this.mimetypeF = mimetypeF;
		this.nameSecondF = nameSecondF;
		this.fileSecond = fileSecond;
		this.mimetypeS = mimetypeS;
		this.nameThirdF = nameThirdF;
		this.fileThird = fileThird;
		this.mimetypeT = mimetypeT;
		this.zone = zone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String name) {
		this.fname = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getFileFirst() {
		return fileFirst;
	}

	public void setFileFirst(byte[] fileFirst) {
		this.fileFirst = fileFirst;
	}

	public byte[] getFileSecond() {
		return fileSecond;
	}

	public void setFileSecond(byte[] fileSecond) {
		this.fileSecond = fileSecond;
	}

	public byte[] getFileThird() {
		return fileThird;
	}

	public void setFileThird(byte[] fileThird) {
		this.fileThird = fileThird;
	}

	public int getZone() {
		return zone;
	}

	public void setZone(int zone) {
		this.zone = zone;
	}

	public String getNameFirstF() {
		return nameFirstF;
	}

	public void setNameFirstF(String nameFirstF) {
		this.nameFirstF = nameFirstF;
	}

	public String getNameSecondF() {
		return nameSecondF;
	}

	public void setNameSecondF(String nameSecondF) {
		this.nameSecondF = nameSecondF;
	}

	public String getNameThirdF() {
		return nameThirdF;
	}

	public void setNameThirdF(String nameThirdF) {
		this.nameThirdF = nameThirdF;
	}
	public String getMimetypeF() {
		return mimetypeF;
	}
	public void setMimetypeF(String mimetypeF) {
		this.mimetypeF = mimetypeF;
	}
	public String getMimetypeS() {
		return mimetypeS;
	}
	public void setMimetypeS(String mimetypeS) {
		this.mimetypeS = mimetypeS;
	}
	public String getMimetypeT() {
		return mimetypeT;
	}
	public void setMimetypeT(String mimetypeT) {
		this.mimetypeT = mimetypeT;
	}

}
