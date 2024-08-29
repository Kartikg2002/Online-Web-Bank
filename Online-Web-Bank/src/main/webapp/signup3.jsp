<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ATM</title>
    <link rel="stylesheet" href="signup3style.css">
</head>

<body>
	  
    <div class="container">
        <h1>APPLICATION FORM NO :<%=session.getAttribute("random") %></h1>
        <h2>ACCOUNT DETAILS</h2>
        <br>
        <form action="signup3" method="post">
            <div class="main-input-box">
                <div class="user-input-box">
                    <label class="details">ACCOUNT TYPE:</label>
                    <label for="yes" class="radiobtn1"><input type="radio" id="yes" name="acctype"
                            value="Savings Account" required>&nbsp;Savings Account</label>
                    <label for="no" class="radiobtn1"><input type="radio" id="no" name="acctype"
                            value="Fixed Deposit Account" required>&nbsp;Fixed Deposit Account</label>
                    <label for="no" class="radiobtn1"><input type="radio" id="no" name="acctype" value="Current Account"
                            required>&nbsp;Current Account</label>
                    <label for="no" class="radiobtn1"><input type="radio" id="no" name="acctype"
                            value="Recurring Deposit Account" required>&nbsp;Recurring Deposit Account</label>

                </div>
                <div class="user-input-box">
                    <label class="card-details">CARD NO :</label> <label class="c-no">XXXX-XXXX-XXXX-8765</label>
                    <br>
                    <label class="sub-details">(Your 16-Digit Card Number)</label>


                </div>
                <div class="user-input-box">
                    <label class="pin-details">PIN NO :</label> <label class="p-no">XXXX</label>
                    <br>
                    <label class="sub-details">(Your 4-Digit Pin)</label>

                </div>
                <div class="service-user-input-box">
                    <label class="service-details">SERVICES REQUIRED</label><br>
                    <label class="service-label" for="ATM CARD"><input type="checkbox" id="ATM CARD" name="servicesrequired" value="ATM CARD">&nbsp;ATM CARD </label>
                    <label class="service-label" for="INTERNET BANKING"> <input type="checkbox" id="INTERNET BANKING" name="servicesrequired"
                            value="INTERNET BANKING">&nbsp;INTERNET BANKING</label>
                    <label class="service-label" for="INTERNET BANKING"><input type="checkbox" id="MOBILE BANKING" name="servicesrequired"
                            value="MOBILE BANKING">&nbsp;MOBILE BANKING </label>
                    <label class="service-label" for="CHEQUE BOOK"><input type="checkbox" id="CHEQUE BOOK" name="servicesrequired"
                            value="CHEQUE BOOK">&nbsp;CHEQUE BOOK </label>
                    <label class="service-label" for="EMAIL & SMS ALERT"><input type="checkbox" id="EMAIL & SMS ALERT" name="servicesrequired"
                            value="EMAIL & SMS ALERT">&nbsp;EMAIL & SMS ALERT </label>
                    <label class="service-label" for="E-STATEMENT"><input type="checkbox" id="E-STATEMENT" name="servicesrequired"
                            value="E-STATEMENT">&nbsp;E-STATEMENT </label>
                </div>
                
                <div class="declaration-input-box">
                    <input type="checkbox" id="decleration" required> <label for="decleration">I HERBY DECLARES THAT THE
                        ABOVE ENTERED DETAILS ARE CORRECT TO THE BEST OF MY KNOWLEDGE</label>
                </div>

                <div class="user-input-btn">
                    <button>NEXT</button>
                </div>
            </div>
        </form>
        <div class="user-input-btn">
            <a href="index.jsp"><button>CANCEL</button></a>
        </div>
        </div>
</body>

</html>