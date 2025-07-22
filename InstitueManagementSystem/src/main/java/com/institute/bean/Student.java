package com.institute.bean;

public class Student {
	private int id;	
	private String Name;
	private int Age;
	private long Mobile;
	private String Address;
	private String Email;
	private String Course;
	
	public Student() {
		
	}
	public Student(int id) {
		super();
		this.id = id;
	}
	public Student(long mobile) {
		super();
		Mobile = mobile;
	}

	public Student(int id, String name, int age, long mobile, String address, String email, String course) {
		super();
		this.id = id;
		Name = name;
		Age = age;
		Mobile = mobile;
		Address = address;
		Email = email;
		Course = course;
	}
	public Student(String name, int age, long mobile, String address, String email, String course) {
		super();
		Name = name;
		Age = age;
		Mobile = mobile;
		Address = address;
		Email = email;
		Course = course;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public long getMobile() {
		return Mobile;
	}

	public void setMobile(long mobile) {
		Mobile = mobile;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getCourse() {
		return Course;
	}

	public void setCourse(String course) {
		Course = course;
	}
	
	
}
