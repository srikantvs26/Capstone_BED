package com.wipro.diet.app.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Newuser")
public class NewUser {

	@Id
	@Column(name="email")
	private String email;

	//---------------
	@Column(name="userid")
	private String userid;
	
	
	
	
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="password")
	private String password;
	//---------
	@Column(name="fname")
	private  String fname;

	@Column(name="lname")
	private String lname;

	@Column(name="age")
	private int age;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="mobile")
	private String mobile;

	@Column(name="address")
	private String address;
	
	@Column(name="city")
	private String city;

	@Column(name="state")
	private String state;
	
	@Column(name="country")
	private String country;

	@Column(name="pincode")
	private int pincode;

	@Column(name="height")
	private int height;
	
	@Column(name="weight")
	private int weight;

	@Column(name="medical")
	private String medical;
	
	@Column(name="dietary")
	private String dietary;
	
	@Column(name="food")
	private String food;
	
	@Column(name="referral")
	private String referral;
	
	@Column(name="status")
	String status="pending";
	
	public NewUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getMedical() {
		return medical;
	}

	public void setMedical(String medical) {
		this.medical = medical;
	}

	public String getDietary() {
		return dietary;
	}

	public void setDietary(String dietary) {
		this.dietary = dietary;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getReferral() {
		return referral;
	}

	public void setReferral(String referral) {
		this.referral = referral;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public NewUser(String email, String userid, String password, String fname, String lname, int age, String gender,
			String mobile, String address, String city, String state, String country, int pincode, int height,
			int weight, String medical, String dietary, String food, String referral, String status) {
		super();
		this.email = email;
		this.userid = userid;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.gender = gender;
		this.mobile = mobile;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.height = height;
		this.weight = weight;
		this.medical = medical;
		this.dietary = dietary;
		this.food = food;
		this.referral = referral;
		this.status = status;
	}

	@Override
	public String toString() {
		return "NewUser [email=" + email + ", userid=" + userid + ", password=" + password + ", fname=" + fname
				+ ", lname=" + lname + ", age=" + age + ", gender=" + gender + ", mobile=" + mobile + ", address="
				+ address + ", city=" + city + ", state=" + state + ", country=" + country + ", pincode=" + pincode
				+ ", height=" + height + ", weight=" + weight + ", medical=" + medical + ", dietary=" + dietary
				+ ", food=" + food + ", referral=" + referral + ", status=" + status + "]";
	}
	
	
}
