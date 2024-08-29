<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Balancestyle.css">
</head>
<body>

     <%if(session.getAttribute("valid") == null){
	    	session.setAttribute("loginerr","Please Login or SignUp First");
	    	response.sendRedirect("index.jsp");
	    }
	 %>
	 
     <%int balance = (Integer)(session.getAttribute("balance")); %>
     
     <header>
        <h1>Web ATM</h1>
    </header>
    <div class="atm-container">
        <h1>Balance Enquiry</h1>
        <form id="withdrawalForm" action="withdrawal" method="post">
            <h2>YOUR TOTAL BALANCE IS <b><%=balance%></b></h2>
        </form>
        <a href="transaction.jsp"><button class="back-button">Back</button></a>
    </div>
    <footer>
        <p>&copy; 2024 Web ATM. All rights reserved.</p>
    </footer>
    <script src="scripts.js"></script>
</body>
</html>