<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ATM</title>
    <link rel="stylesheet" href="signup2style.css">
</head>
<body>
  
    <div class="container">
        <h1>APPLICATION FORM NO :<%=session.getAttribute("random") %></h1>
    <h2>ADDITIONAL DETAILS</h2>
    <br>
    <form action="signup2" method="post">
      <div class="main-input-box">
        <div class="user-input-box">
           <label class="details">RELIGION:</label>
           <select name="religion" required>
              <option value="Hindu">HINDU</option>
              <option value="Muslim">MUSLIM</option>
              <option value="Sikh">SIKH</option>
              <option value="Christian">CHRISTIAN</option>
              <option value="Other">Other</option>
            </select>
        </div>
        <div class="user-input-box">
           <label class="details">CATEGORY:</label>
           <select name="category" required>
              <option value="General">GENERAL</option>
              <option value="OBC">OBC</option>
              <option value="SC">SC</option>
              <option value="ST">ST</option>
              <option value="Other">Other</option>
            </select>
        </div>
        <div class="user-input-box">
           <label class="details">INCOME:</label>
           <select name="income" required>
              <option value="null">NULL</option>
              <option value="<1,50,000">LESS THAN 1,50,000</option>
              <option value="<2,50,000">LESS THAN 2,50,000</option>
              <option value="<5,00,000">LESS THAN 5,00,000</option>
              <option value="Upto 10,00,000">UPTO 10,00,000</option>
              <option value ="Above 10,00,000">ABOVE 10,00,000</option>
            </select>
        </div>
        <div class="user-input-box">
           <label class="details">EDUCATION QUALIFICATION:</label>
           <select name="eduqualification" required>
              <option value="Non-Graduate">NON-GRADUATE</option>
              <option value="Graduate">GRADUATE</option>
              <option value="Post-Graduate">POST-GRADUATE</option>
              <option value="Doctrate">DOCTRATE</option>
              <option value="Others">OTHERS</option>
            </select>
        </div>
        <div class="user-input-box">
           <label class="details">OCCUPATION:</label>
           <select name="occupation" required>
              <option value="Salaried">SALARIED</option>
              <option value="Self-Employed">SELF-EMPLOYED</option>
              <option value="Business">BUSINESS</option>
              <option value="Student">STUDENT</option>
              <option value="Retired">RETIRED</option>
              <option value="Others">OTHERS</option>
            </select>
        </div>
        <div class="user-input-box">
           <label class="details">PAN NUMBER:</label>
           <input type="text" maxlength="10" name="pannumber" required>
        </div>
        <div class="user-input-box">
           <label class="details">AADHAR NUMBER:</label>
           <input type="text" pattern=[0-9]{12} name="aadharnumber" required>
        </div>
        <div class="user-input-box">
           <label class="details">SENIOR CITIZEN:</label>
           <label for="yes" class="radiobtn1"><input type="radio" id="yes" name="seniorcitizen" value="Yes" required>&nbsp;Yes</label>
           <label for="no" class="radiobtn1"><input type="radio" id="no" name="seniorcitizen" value="No" required>&nbsp;No</label>
        </div>
        <div class="user-input-box">
           <label class="details">EXISTING ACCOUNT:</label>
           <label for="yes" class="radiobtn1"><input type="radio" id="yes" name="exaccount" value="Yes" required>&nbsp;Yes</label>
           <label for="no" class="radiobtn1"><input type="radio" id="no" name="exaccount" value="No" required>&nbsp;No</label>
        </div>
         <div class="user-input-btn">
           <button>NEXT</button>
        </div>
      </div>
    </form>
    </div>
</body>
</html>