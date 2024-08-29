<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="depositstyle.css">
</head>
<body>

     <%if(session.getAttribute("valid") == null){
	    	session.setAttribute("loginerr","Please Login or SignUp First");
	    	response.sendRedirect("index.jsp");
	    }
	  %>
	  
     <header>
        <h1>Web ATM</h1>
    </header>
    <div class="atm-container">
        <h2>Deposit Amount</h2>
        <form id="withdrawalForm" action="deposit" method="post">
            <label for="withdrawalAmount">Enter amount to deposit:</label>
            <input type="number" id="depositAmount" name="depositAmount" min="1" required>
            <button type="submit">Deposit</button>
        </form>
        <a href="transaction.jsp"><button class="back-button">Back</button></a>
    </div>
    <footer>
        <p>&copy; 2024 Web ATM. All rights reserved.</p>
    </footer>
    <script src="scripts.js"></script>
</body>
</html>