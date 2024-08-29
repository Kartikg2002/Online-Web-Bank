package com.incapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.incapp.model.DAO;

/**
 * Servlet implementation class transactionhistory
 */
@WebServlet("/transactionhistory")
public class transactionhistory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String pinNo = (String)session.getAttribute("pinno");
		PrintWriter out = null;	
		ArrayList<LinkedHashMap<String,String>> allHistory = new ArrayList<LinkedHashMap<String,String>>(); 
		
		try {
			out=response.getWriter();
			DAO db = new DAO();
	    	ResultSet rs = db.transactionHistory(pinNo);
	    	while(rs.next()) {
	    		LinkedHashMap<String,String> history = new LinkedHashMap<String,String>();
	    		history.put("Pin",rs.getString("pin"));
	    		history.put("Date",rs.getString("date"));
	    		history.put("Type",rs.getString("type"));
	    		history.put("Amount",rs.getString("amount"));
	    		allHistory.add(history);
	    	}
	    	
	    	session.setAttribute("allhistory",allHistory);
	    	response.sendRedirect("transactionhistory.jsp");
	    	
		}catch(Exception e){
			out.print(e);		
		}
	}

}
