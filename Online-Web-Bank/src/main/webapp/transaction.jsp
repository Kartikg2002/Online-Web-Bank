<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Web ATM</title>
    <link rel="stylesheet" href="transactionstyle.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>

     <%if(session.getAttribute("valid") == null){
	    	session.setAttribute("loginerr","Please Login or SignUp First");
	    	response.sendRedirect("index.jsp");
	    }
	  %>
	 
	  
    <%if(session.getAttribute("msg") != null){
    	if(session.getAttribute("msg")=="Insufficient Balance!!!!"){
    %>
    	<div style=background-color:red;font-size:2rem;text-align:center;width:100%;><%=session.getAttribute("msg")%></div>  	
    <%	
    	}
    	else{
    %>
    	<div style=background-color:green;font-size:2rem;text-align:center;width:100%;><%=session.getAttribute("msg")%></div>
    <%	}
       session.setAttribute("msg",null);
    }  
    %>
    
    <header>
        <h1>Web ATM</h1>
    </header>
    <div class="atm-container">
        <div class="button-container">
            <a class="innerAnchor" href="Balance">
                <i class="fas fa-wallet"></i>
                <span>Balance Check</span>
            </a>
            <a class="innerAnchor" href="withdrawal.jsp">
                <i class="fas fa-money-bill-wave"></i>
                <span>Withdrawal</span>
            </a>
            <a class="innerAnchor" href="deposit.jsp">
                <i class="fas fa-piggy-bank"></i>
                <span>Deposit</span>
            </a>
            <a class="innerAnchor" href="accountdetail">
                <i class="fas fa-user-circle"></i>
                <span>Account Details</span>
            </a>
            <a class="innerAnchor" href="transactionhistory">
                <i class="fas fa-history"></i>
                <span>Transaction History</span>
            </a>
            <a class="innerAnchor" href="Logout">
                <i class="fas fa-sign-out-alt"></i>
                <span>Logout</span>
            </a>
        </div>
    </div>
    <footer>
        <p>&copy; 2024 Web ATM. All rights reserved.</p>
    </footer>
    <script src="scripts.js"></script>
</body>
</html>