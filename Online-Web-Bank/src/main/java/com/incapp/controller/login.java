package com.incapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.incapp.model.DAO;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cardno = request.getParameter("cardno");
		String pinno = request.getParameter("pinno");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			DAO db = new DAO();
			ResultSet rs = db.login(cardno, pinno);
			if (rs.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("cardno", cardno);
				session.setAttribute("pinno", pinno);
				session.setAttribute("valid", "valid");
				response.sendRedirect("transaction.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("msg", "Invalid Credentials !!!!");
				response.sendRedirect("index.jsp");
			}
		} catch (Exception e) {
			out.print(e);
		}
	}
}
