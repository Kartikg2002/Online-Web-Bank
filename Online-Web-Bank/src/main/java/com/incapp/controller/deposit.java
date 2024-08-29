package com.incapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.incapp.model.DAO;

/**
 * Servlet implementation class withdrawal
 */
@WebServlet("/deposit")
public class deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String depositAmount=request.getParameter("depositAmount");
		PrintWriter out = null;
		Date date = new Date();
		HttpSession session = request.getSession();
		String pinNo = (String)session.getAttribute("pinno");
		
		LinkedHashMap<String,String> data = new LinkedHashMap<>();
		data.put("pinNo",pinNo);
		data.put("date",String.valueOf(date));
		data.put("depositAmount",depositAmount);			
		try {
			out=response.getWriter();
			DAO db = new DAO();
			db.deposit(data);
	    	session.setAttribute("msg","Deposit Successfully");
	    	response.sendRedirect("transaction.jsp");
		}catch(Exception e){
			out.print(e);		
		}
	}

}
