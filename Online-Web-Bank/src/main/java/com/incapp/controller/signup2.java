package com.incapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.incapp.model.DAO;

/**
 * Servlet implementation class signup2
 */
@WebServlet("/signup2")
public class signup2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
		
		LinkedHashMap<String,String> data = new LinkedHashMap<>();
		data.put("religion",request.getParameter("religion"));
		data.put("category",request.getParameter("category"));
		data.put("income",request.getParameter("income"));
		data.put("eduqualification",request.getParameter("eduqualification"));
		data.put("occupation",request.getParameter("occupation"));
		data.put("pannumber",request.getParameter("pannumber"));
		data.put("aadharnumber",request.getParameter("aadharnumber"));
		data.put("seniorcitizen",request.getParameter("seniorcitizen"));
		data.put("exaccount",request.getParameter("exaccount"));
		data.put("formno",String.valueOf(session.getAttribute("random")));
		
		PrintWriter out = null;
		try {
			out=response.getWriter();
			DAO db = new DAO();
			db.signUp2(data);
	    	response.sendRedirect("signup3.jsp");
		}catch(Exception e){
			out.print(e);		
		}
	}
}
