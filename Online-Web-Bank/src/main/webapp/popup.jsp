<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Custom Popup Example</title>
<style>
/* CSS for the popup */
.popup {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgba(0,123,255,0.7); /* Semi-transparent blue background */
}

/* Content of the popup */
.popup-content {
  background-color: #007bff; /* Blue background */
  color: white; /* White text */
  margin: 10% auto; /* 10% from the top and centered */
  padding: 30px;
  border: 1px solid #0056b3; /* Darker blue border */
  width: 80%; /* 80% of parent element */
  max-width: 600px; /* Max width of the popup */
  text-align: center;
  box-shadow: 0 4px 8px rgba(0,0,0,0.2); /* Box shadow for a subtle lift */
}

/* Close button */
.close {
  color: white;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: white;
  text-decoration: none;
  cursor: pointer;
}
</style>
</head>
<body>

<%
String cardno =(String)session.getAttribute("cardno");
String pin =(String)session.getAttribute("pinno");
%>

<!-- The popup box (automatically opened) -->
<div id="popup" class="popup" style="display: block;">
  <div class="popup-content">
    <h2>Thank You For The Registration</h2>
    <h3>Your Card Number and PIN is Generated:</h3>
    <form action="transaction.jsp">
      <label for="cardNumber">Card Number:</label><br>
      <label><b><%=cardno%></b></label><br><br>
      <label for="pin">PIN:</label><br>
      <label><b><%=pin%></b></label><br><br>
      <button>CLOSE</button>
    </form>
  </div>
</div>
</body>
</html>
