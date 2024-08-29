package com.incapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
@WebServlet("/withdrawal")
public class withdrawal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String withdrawalAmount=request.getParameter("withdrawalAmount");
		PrintWriter out = null;
		Date date = new Date();
		HttpSession session = request.getSession();
		String pinNo = (String)session.getAttribute("pinno");
			
		try {
			out=response.getWriter();
			DAO db = new DAO();
	    	ResultSet rs = db.withdrawal(pinNo);
	    	int balance=0;
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
            }
            if(balance<Integer.parseInt(withdrawalAmount)){
                session.setAttribute("msg","Insufficient Balance!!!!");
                response.sendRedirect("transaction.jsp");                
            }
            else {
            	LinkedHashMap<String,String> data = new LinkedHashMap<>();
            	data.put("pinNo",pinNo);
        		data.put("date",String.valueOf(date));
        		data.put("withdrawalAmount",withdrawalAmount);
        		DAO db2 = new DAO();
        		db2.amountWithdrawal(data);
        		session.setAttribute("msg","Withdrawal Successfully");
             	response.sendRedirect("transaction.jsp");
            }
            
		}catch(Exception e){
			out.print(e);		
		}
	}

}
