package com.institute.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;

import com.institute.bean.*;

public class Dao {

	String driverClass = "com.mysql.cj.jdbc.Driver";
	Connection con = null;
	Statement s =null;
	PreparedStatement ps=null;
	String url = "jdbc:mysql://localhost:3306/mvc";
	String user = "root";
	String password = "Zai@2002";
	String insertQuery ="insert into user (name,email,password) values(?,?,?);";
	String tableData="select * from user;";
	
	String insertStudent="insert into student (name,age,mobile,address,email,course) values (?,?,?,?,?,?);";
	String studenttabledata= "select * from student;";
	
	//before run the application make sure to create Database in mysql as mvc then create 2 tables user and student
	/*
		create table user(
		uid int primary key auto_increment,
		name varchar(20),
		email varchar(20) unique,
		password varchar(30)
		);
		create table Student(
		id int primary key auto_increment,
		name varchar(20),
		age int,
		mobile bigint unique,
		address varchar(50),
		email varchar(20) unique,
		course varchar(20)
		); 
	 */
	public boolean insert(User u) {
		boolean isDataInserted = true;
		try {
			Class.forName(driverClass);
			con = DriverManager.getConnection(url,user,password);
			
			s= con.createStatement();
			ResultSet rs=s.executeQuery("select * from user;");
			while (rs.next()) {
				if(u.getEmail().equals(rs.getString("email"))) {
					isDataInserted = false;
					break;
				}
			}
			if(isDataInserted==true)
			{	ps=con.prepareStatement(insertQuery);
				ps.setString(1, u.getName());
				ps.setString(2, u.getEmail());
				ps.setString(3, u.getPassword());
				ps.executeUpdate();
			}
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("class forname = driver problem");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(" Driver Manager con= Connection problem");
			e.printStackTrace();
		}
		finally {
			try {
				if(ps!=null && con!=null) 
				{
					ps.close();
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("closing problem");
				e.printStackTrace();
			}
		}
		return isDataInserted;
	
	}
	
	public boolean ValidUser(User u ) {
		boolean isDataPresent=false;

		try {
			Class.forName(driverClass);
			con = DriverManager.getConnection(url,user,password);
			s=con.createStatement();
			ResultSet rs=s.executeQuery(tableData);
			while(rs.next()) {
				if(u.getEmail().equals(rs.getString("email"))&&u.getPassword().equals(rs.getString("password"))) {
					isDataPresent = true;
					break;
				}
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isDataPresent;
			}

	public boolean insertStudent(Student stu) {
		boolean isDataInserted=false;

		try {
			Class.forName(driverClass);
			con = DriverManager.getConnection(url,user,password);
			s= con.createStatement();
			ResultSet rs=s.executeQuery(studenttabledata);
			while (rs.next()) {
				if(stu.getMobile()==rs.getLong("mobile") && stu.getEmail().equals(rs.getString("email"))) {
					isDataInserted = true;
					break;
				}
			}
			if(!isDataInserted)
			{	
				ps=con.prepareStatement(insertStudent);
				ps.setString(1, stu.getName());
				ps.setInt(2, stu.getAge());
				ps.setLong(3, stu.getMobile());
				ps.setString(4, stu.getAddress());
				ps.setString(5, stu.getEmail());
				ps.setString(6, stu.getCourse());
				ps.executeUpdate();
			} 
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isDataInserted;
		
		}

	public ArrayList<Student> getData() {
		// TODO Auto-generated method stub
		ArrayList<Student> al=new ArrayList<>();

		try {
			Class.forName(driverClass);
			con = DriverManager.getConnection(url,user,password);
			s= con.createStatement();
			ResultSet rs=s.executeQuery(studenttabledata);
			while(rs.next()) {
				int sid=rs.getInt("id");
				String name=rs.getString("name");
				int age=rs.getInt("age");
				long mobile=rs.getLong("mobile");
				String addr=rs.getString("address");
				String email=rs.getString("email");
				String course=rs.getString("course");
				
				Student st=new Student(sid, name, age, mobile, addr, email, course);
				
				al.add(st);
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;	
	}

	public void updatestudentdata(Student s2) {
		try {
			Class.forName(driverClass);
			con = DriverManager.getConnection(url,user,password);
			ps=con.prepareStatement("update student set name=?,age=?, mobile=?, address=?, email=?, course=? where mobile=?;");
			ps.setString(1, s2.getName());
			ps.setInt(2, s2.getAge());
			ps.setLong(3, s2.getMobile());
			ps.setString(4,s2.getAddress());
			ps.setString(5, s2.getEmail());
			ps.setString(6, s2.getCourse());
			ps.setLong(7, s2.getMobile());
			ps.executeUpdate();
						
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Student showStudentDataToUpdate(Student s2) {
		// TODO Auto-generated method stub
		Student s4 = null;
		
		try {
			Class.forName(driverClass);
			con = DriverManager.getConnection(url,user,password);
			ps= con.prepareStatement("select * from Student where mobile=?;");
			ps.setLong(1,s2.getMobile());
			ResultSet rs=ps.executeQuery();
			//only one record check
			if(rs.next()) {
				String name=rs.getString("name");
				int age=rs.getInt("age");
				long mobile=rs.getLong("mobile");
				String addr=rs.getString("address");
				String email=rs.getString("email");
				String course=rs.getString("course");
				
				s4= new Student(name, age, mobile, addr, email, course);
				//return s4 which has updated value
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s4;
		
	}
	
	public boolean deletestudentdata(int id) {
		boolean rowDeleted=false;
		try {
			Class.forName(driverClass);
			con=DriverManager.getConnection(url,user,password);
			ps = con.prepareStatement("Delete from Student where id=?;");
			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			rowDeleted = (rows > 0);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	        try {
	            if (ps != null) ps.close();
	            if (con != null) con.close();
	        } catch (Exception e2) {
	            e2.printStackTrace();
	        }
	    }
		return rowDeleted;
				
		
	}
}
