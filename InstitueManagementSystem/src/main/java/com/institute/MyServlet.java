package com.institute;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.institute.bean.User;
import com.institute.bean.Student;
import com.institute.model.Dao;
/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public MyServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path=request.getServletPath();
		switch(path){
		case "/reg":registeruser(request,response);
			break;
		case "/login":validateuser(request,response);
			break;
		case "/studenthome":
					String action=request.getParameter("action");
					switch(action) {
					
					case "Add Student": addstudent(request,response);
						break;
					case "Display": displayStudentData(request,response);
						break;
					case "Update": updateStudent(request,response);
						break;
					case "Delete":deletestudent(request,response);
						break;
					}
					break;
		case "/savestudent":saveStudentDetails(request,response);
			break;
		case "/showStudentdatatoupdate":showStudentdatatoupdate(request,response);
			break;
		case "/updatestudentdata":updatestudentdata(request,response);
		break;
		case "/Deletestudent":deletestudentdata(request,response);
		break;
		}
	}
	
	private void deletestudent(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect("delete.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	private void deletestudentdata(HttpServletRequest request, HttpServletResponse response) {
		
		 int id=Integer.parseInt( request.getParameter("id"));
		  
		 Dao d = new Dao();
		 boolean isDeleted = d.deletestudentdata(id);
		  
		  if(isDeleted) { 
			  request.setAttribute("message", "Student with ID " + id +" deleted successfully."); 
			  displayStudentData(request,response);
		  }else 
		  { 
			  request.setAttribute("message", "No student found with ID " + id); 
			}
		  RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
		  try {
			  rd.forward(request, response);
			  } catch (Exception e) 
		  { // TODOAuto-generated catch block 
				  e.printStackTrace();
		  request.setAttribute("message", "Something went wrong while deleting.");
		  }
		 			
}

	private void updatestudentdata(HttpServletRequest request, HttpServletResponse response) {
		String nam = request.getParameter("name");
		int age =Integer.parseInt(request.getParameter("age"));
		long mobile = Long.parseLong(request.getParameter("mobile"));	
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String course = request.getParameter("course");
		
		Student s= new Student(nam,age,mobile,address,email,course);
		
		Dao d =new Dao();
		d.updatestudentdata(s);
		request.setAttribute("message","updated Successfully");
		RequestDispatcher rd =request.getRequestDispatcher("update.jsp");
		try {
		rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void showStudentdatatoupdate(HttpServletRequest request, HttpServletResponse response) {
		
		Long mobile=Long.parseLong(request.getParameter("mobile"));
		 
		Student s = new Student(mobile);
		Dao d = new Dao();
		Student obj = d.showStudentDataToUpdate(s);
		if(obj !=null) {
		request.setAttribute("student data", obj);
		RequestDispatcher rd =request.getRequestDispatcher("update.jsp");
		try {
		rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else {
			request.setAttribute("student data", "Invalid Mobile number");
			RequestDispatcher rd =request.getRequestDispatcher("update.jsp");
			try {
			rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		}
	
	private void updateStudent(HttpServletRequest request, HttpServletResponse response) {

		try {
			response.sendRedirect("update.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void displayStudentData(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Dao d=new Dao();
		ArrayList<Student> alist=d.getData();
		
		request.setAttribute("Student List", alist);
		RequestDispatcher rd=request.getRequestDispatcher("display.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	private void saveStudentDetails(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String nam = request.getParameter("name");
		int agg =Integer.parseInt(request.getParameter("age"));
		long mobile = Long.parseLong(request.getParameter("mobile"));	
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String course = request.getParameter("course");
		
		Student s= new Student(nam,agg,mobile,address,email,course);
		
		Dao d=new Dao();
		boolean isdataPresent = d.insertStudent(s);
		if(isdataPresent) {
			request.setAttribute("message", "Mobile number or email id is already exixts");
			RequestDispatcher rd=request.getRequestDispatcher("studentform.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				response.sendRedirect("studentform.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		}
	}
	private void addstudent(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			response.sendRedirect("studentform.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void validateuser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String user=request.getParameter("username");
		String pass=request.getParameter("password");
		
		User u=new User(user,pass);
		Dao d=new Dao();
		boolean isDataPresent=d.ValidUser(u);
		
		if(isDataPresent) {
			try {
				response.sendRedirect("home.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		}
		else {
			request.setAttribute("message", "User does not exist");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void registeruser(HttpServletRequest request, HttpServletResponse response) 
	{
		// TODO Auto-generated method stub
		String nam=request.getParameter("name");
		String em=request.getParameter("email");
		String pass=request.getParameter("password");
		//to pass bean class
		User u =new User(nam,em,pass);
		//user data pass to DAO class
		Dao d=new Dao();
		boolean isDatainserted=d.insert(u);
		response.setContentType("text/html");
		
		@SuppressWarnings("unused")
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isDatainserted) {
			try {
				response.sendRedirect("login.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			//out.println("<h2>Email already exists</h2>");
			//display in register page
		request.setAttribute("message","Email id already exist");
		RequestDispatcher rd =request.getRequestDispatcher("register.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
