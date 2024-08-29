package com.incapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.incapp.model.DAO;

/**
 * Servlet implementation class signup3
 */
@WebServlet("/signup3")
public class signup3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        Random ran =new Random();
		String scardno=""+ Math.abs((ran.nextLong()%90000000L)+5040936000000000L);
		int pin=(int)(Math.random()*9000) + 1000;
		String spinno = ""+pin;
		
		LinkedHashMap<String,String> data = new LinkedHashMap<>();
		data.put("acctype",request.getParameter("acctype"));
		data.put("servicesrequired",String.valueOf(Arrays.asList(request.getParameterValues("servicesrequired"))));
		data.put("scardno",scardno);
		data.put("spinno",spinno);
		data.put("formno",String.valueOf(session.getAttribute("random")));

		session.setAttribute("cardno", scardno);
	    session.setAttribute("pinno",spinno);
	    session.setAttribute("valid","valid");

		PrintWriter out = null;
		try {
			out=response.getWriter();
			DAO db = new DAO();
			db.signUp3(data);
	    	response.sendRedirect("popup.jsp");
		}catch(Exception e){	
			out.print(e);		
		}
	
	}

}
