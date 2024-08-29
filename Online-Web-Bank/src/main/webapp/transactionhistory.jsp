<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="withdrawalstyle.css">
</head>
<body>

     <%if(session.getAttribute("valid") == null){
	    	session.setAttribute("loginerr","Please Login or SignUp First");
	    	response.sendRedirect("index.jsp");
	    }
	  %>
	  
	  
     <%
     List<LinkedHashMap<String,String>> allhistory=(List<LinkedHashMap<String,String>>)session.getAttribute("allhistory");    
     %>
     <header>
        <h1>Web ATM</h1>
    </header>
    <div class="atm-container">
        <h2>Transaction History</h2>
        <form id="withdrawalForm" action="withdrawal" method="post">
        <%for(LinkedHashMap<String,String> history : allhistory){
        	Set set = history.entrySet();
        	for(Object obj : set){   	
        %>	
        	 <label><%=obj%></label>       	 
        <% 
        	}
        %>	
        	<label>-------------------------------------------</label>
        <%	
        }
        %>    
        </form>
        <a href="transaction.jsp"><button class="back-button">Back</button></a>
    </div>
    <footer>
        <p>&copy; 2024 Web ATM. All rights reserved.</p>
    </footer>
    <script src="scripts.js"></script>
</body>
</html>