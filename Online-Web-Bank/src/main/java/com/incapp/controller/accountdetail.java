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
@WebServlet("/accountdetail")
public class accountdetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String pinno=(String)session.getAttribute("pinno");
		PrintWriter out = null;	
		try {
			out=response.getWriter();
			DAO db = new DAO();
			ArrayList<LinkedHashMap<String,String>> allHistory = db.accountDetail(pinno);
	    	session.setAttribute("allhistory",allHistory);
	    	response.sendRedirect("accountdetails.jsp");
		}catch(Exception e){
			out.print(e);
			e.printStackTrace();
		}
	}

}
