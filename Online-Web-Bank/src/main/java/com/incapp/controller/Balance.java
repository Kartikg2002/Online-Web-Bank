package com.incapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.incapp.model.DAO;

/**
 * Servlet implementation class Balance
 */
@WebServlet("/Balance")
public class Balance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = null;
		HttpSession session = request.getSession();
		String pinNo = (String)session.getAttribute("pinno");		
		try {
		out=response.getWriter();
		DAO db = new DAO();
    	ResultSet rs = db.balance(pinNo);
    	int balance=0;
        while(rs.next()){
            if(rs.getString("type").equals("Deposit")){
                balance+=Integer.parseInt(rs.getString("amount"));
            }
            else{
                balance-=Integer.parseInt(rs.getString("amount"));
            }
        }
        session.setAttribute("balance", balance);
        response.sendRedirect("Balance.jsp");
		}catch(Exception e) {
			out.print(e);
		}
	}

}
