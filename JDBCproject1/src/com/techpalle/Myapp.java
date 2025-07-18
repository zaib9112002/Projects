package com.techpalle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Myapp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Crud c =new Crud();
	//  c.CreateTable();
	//	c.InsertData();
		c.Display();
	}

}
class Crud {
	
	String driverload="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/palle";
	String user="root";String password="Zai@2002";
	
	public void CreateTable() 
	{
		Connection con = null;
		Statement s =null;
		//loading driver
		try {
	    	Class.forName(driverload);
		//establish connection
		    con = DriverManager.getConnection(url,user,password);
			System.out.println("Connected successfully");
		//prepare sql statement
			s =con.createStatement();
		//create a table
			s.executeUpdate("create table employee(eid int primary key auto_increment, ename varchar(50),age int,salary int,dept varchar(40),doj date );");
			System.out.println("created table employee");
				
			} catch (ClassNotFoundException e) {
				System.out.println("DRIVER IS NOT PROPERLY LOADED");
				e.printStackTrace();
			} catch(SQLException e) {
			System.out.println(" something went wrong with database");
				e.printStackTrace();
			}finally {
					if(s!=null) {
						try {
							s.close();
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
	public void InsertData() 
	{
		Connection c=null;
		PreparedStatement ps = null;
		
		try 
		{
	    	Class.forName(driverload);
			c = DriverManager.getConnection(url,user,password);
			System.out.println("connected successfully to insert");
			ps =c.prepareStatement("INSERT INTO employee (ename,age,salary,dept,doj)VALUES(?,?,?,?,?);");
			ps.setString(1, "Alice");
			ps.setInt(2, 26);
			ps.setInt(3, 15000);
			ps.setString(4, "Project Manager");
			ps.setString(5, "2022-03-20");
			ps.executeUpdate();
			ps.setString(1, "Bob");
			ps.setInt(2, 30);
			ps.setInt(3, 20000);
			ps.setString(4, "Sales HR");
			ps.setString(5, "2022-12-08");
			ps.executeUpdate();
			System.out.println("Inserted successfully");
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Driver not uploaded properly");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			try {
				if(ps!=null) {
				ps.close();}
			} catch (SQLException e) {
				System.out.println("closing problem in ps");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {if(c!=null) {
				c.close();}
			} catch (SQLException e) {
				System.out.println("closing problem in c");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void Display()
	{
		Connection con = null;
		Statement s =null;
		//loading driver
		try {
			Class.forName(driverload);
			//establish connection
			con = DriverManager.getConnection(url,user,password);
			System.out.println("Connected to read successfully");
			//prepare statement
			 s =con.createStatement();
			/* String view ="select * from employee";
			 s.executeQuery(view); 
		// above line fetch only one data and to get next row also we need pointer
		 * so use resultset ;
* A ResultSet object maintains a cursor pointing
* to its current row of data
		 */
			 ResultSet r=s.executeQuery("select * from employee");	
			 while(r.next()==true) {
				 // means next row is there ...so read row
			 System.out.println("Displaying");
			 System.out.println("eid = "+r.getInt(1));
			 System.out.println("ename = "+r.getString(2));
			 System.out.println("age = "+r.getInt(3));
			 System.out.println("salary = " + r.getInt(4));
			 System.out.println("dept = "+r.getString(5));
			 System.out.println("doj ="+r.getDate(6));
			 System.out.println("****************************************************************");
			 }
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER IS NOT PROPERLY LOADED");
			e.printStackTrace();
		} catch(SQLException e) {
		System.out.println(" something went wrong with database");
			e.printStackTrace();
		}finally {
				if(s!=null) {
					try {
						s.close();
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
}