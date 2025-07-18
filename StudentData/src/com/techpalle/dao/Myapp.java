package com.techpalle.dao;

import com.techpalle.bean.Student;

public class Myapp {

	public static void main(String[] args) {
		
		/* when i need create and insert
		 * Student s1 =new Student("Alice","Alice@gmail.com",9876543215l,"Bangalore");
		 * Dao.insertData(s1); System.out.println("inserted");
		 */
		
		//to display in console
		// Dao.Display();
		
		//to delete from table
	//	Dao.Delete(2);
		
		//to update the name 
		Dao.Update("Hary",2);
		Dao.Display();
	}

}
