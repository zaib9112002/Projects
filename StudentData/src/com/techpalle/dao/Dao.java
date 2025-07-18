package com.techpalle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.techpalle.bean.Student;

public class Dao {
	public static Statement s=null;
	public static PreparedStatement ps =null;
	public static Connection con =null;
	private static ResultSet rs =null;
	public static String Driver="com.mysql.cj.jdbc.Driver";
	public static String url = "jdbc:mysql://localhost:3306/palle";
	public static String user ="root";
	public static String password = "Zai@2002";
	
	public static String insert ="insert into Student(sname,email,mobile,address) values(?,?,?,?);";
	public static String select="select * from Student;";
	public static String delete="delete from student where sid=?;";
	public static String update="update student set sname=? where sid=?;";

	public  static void insertData(Student s) {
		try {
			Class.forName(Driver);
			con =DriverManager.getConnection(url,user,password);
			//dynamic query
			ps = con.prepareStatement(insert);
			//set values  get name using object class also for other
			ps.setString(1,s.getSname());
			ps.setString(2, s.getEmail());
			ps.setLong(3,s.getMobile());
			ps.setString(4, s.getAddress());
			ps.executeUpdate();
	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Driver Loading problem");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error with DriverManager connection problem");
		}
		finally {
				if(ps!=null) {
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(con!=null) {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		
	}
	
	public static void Display() {
		try {
			Class.forName(Driver);
			con =DriverManager.getConnection(url,user,password);
			s=con.createStatement();
			rs =s.executeQuery(select);
			
			System.out.println("sid  name  email  mobile  address");

			while(rs.next()==true) {
				int sid=rs.getInt("sid");
				String name=rs.getString("sname");
				String email=rs.getString("email");
				Long mobile = rs.getLong("mobile");
				String address = rs.getString("address");
				
				System.out.println(sid+"  "+name+"  "+email+ "  "+mobile+ "  "+address);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			try {
				rs.close();
				s.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	public static void Delete(int id)
	{ try {
		Class.forName(Driver);
		con =DriverManager.getConnection(url,user,password);
	    ps=con.prepareStatement(delete);
	    ps.setInt(1,id); //? only one  first id will delete
	    ps.executeUpdate();
	    System.out.println("Deleted Data");
	    
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	    
	}

	public static void Update(String sname,int id) {
			try {
				Class.forName(Driver);
				con =DriverManager.getConnection(url,user,password);
				//dynamic query
				ps = con.prepareStatement(update);
			
				ps.setString(1, sname);
	            ps.setInt(2, id);

	            int rowsAffected = ps.executeUpdate();
	            if (rowsAffected > 0) {
	                System.out.println("Student name updated successfully.");
	            } else {
	                System.out.println("No student found with SID: " +id);
	            }
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		
	}
}
