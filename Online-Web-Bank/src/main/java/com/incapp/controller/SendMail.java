package com.incapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SendMail
 */
@WebServlet("/SendMail")
public class SendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			// Get parameters from the request
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String subject = request.getParameter("subject");
			String content = request.getParameter("message");

			// Email account details for sending email
			String sEmail = "k.guleria2002@gmail.com";
			String sPassword = "naoy oqcu zwzp ieoy";
			
			// Set up the mail server properties
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");

			// Get a mail session
			Session ses = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(sEmail, sPassword);
					}
				}
			);

			// Compose the message
			Message message = new MimeMessage(ses);
			message.setFrom(new InternetAddress(sEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject(subject);

			// Create a formatted message including the sender's name and email
			String formattedContent = "<h2>You have received a new message from Yes ATM</h2>"
				+ "<p><strong>From:</strong> " + name + " (" + email + ")</p>"
				+ "<p><strong>Subject:</strong> " + subject + "</p>"
				+ "<p><strong>Message:</strong><br>" + content + "</p>";

			message.setContent(formattedContent, "text/html");

			// Send the message
			Transport.send(message);

			// Set a session attribute and redirect
			HttpSession session = request.getSession();
			session.setAttribute("msg", "Mail Sent Successfully!");
			response.sendRedirect("index.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
			out.print(e);
		}
	}
}
