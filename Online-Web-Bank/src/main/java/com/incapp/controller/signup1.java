package com.incapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.incapp.model.DAO;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Servlet implementation class signup1
 */
@WebServlet("/signup1")
public class signup1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		LinkedHashMap<String,String> data = new LinkedHashMap<>();
		data.put("name",request.getParameter("name"));
		data.put("fname",request.getParameter("fname"));
		data.put("dob",request.getParameter("dob"));
		data.put("gender",request.getParameter("gender"));
		data.put("email",request.getParameter("email"));
		data.put("mstatus",request.getParameter("mstatus"));
		data.put("address",request.getParameter("address"));
		data.put("city",request.getParameter("city"));
		data.put("state",request.getParameter("state"));
		data.put("pincode",request.getParameter("pincode"));
		data.put("formno",String.valueOf(session.getAttribute("random")));

		PrintWriter out = null;
		try {
			out=response.getWriter();
			DAO db = new DAO();
			db.signUp1(data);
	    	response.sendRedirect("signup2.jsp");
		}catch(Exception e){
			out.print(e);		
		}		
	}
}
