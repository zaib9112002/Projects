package com.techpalle.bean;

public class Student {

	private int sid;
	private String sname;
	private String email;
	private long mobile;
	private String address;
	
	//to store values in table
	public Student(int sid, String sname, String email, long mobile, String address) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
	}
		
	//this is because sid is autoincrement
	public Student(String sname, String email, long mobile, String address) {
		super();
		this.sname = sname;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
	}

	//accessing data we need getter n setter

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
