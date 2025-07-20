package com.calculator;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Calc")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CalculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int number1=Integer.parseInt(request.getParameter("num1"));
		int number2=Integer.parseInt(request.getParameter("num2"));		
		String operation = request.getParameter("operation");
		double result=0;
		switch(operation){
		case "add":
			result=number1 + number2;
			break;
		case "sub":
			result=number1 - number2;
		break;
		case "mul":
			result=number1 * number2;
		break;
		case "div":
			result=number1 / number2;
		break;
		}
		request.setAttribute("output", result);
		RequestDispatcher rd =request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}

}
