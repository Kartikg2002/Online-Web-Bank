<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%java.util.Random r = new java.util.Random();
  Long random = Math.abs((r.nextLong()%90000L)+10000L);
  session.setAttribute("random",random);
 %>
 
<!DOCTYPE html>
<html lang="en">
<head>
  
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ATM</title>
    <link rel="stylesheet" href="signup1style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" >
    <link
        href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
        rel="stylesheet">
</head>
<body>

    <div class="container">
        <h1>APPLICATION FORM NO :<%=random%></h1>
    <h2> PERSONAL DETAILS</h2>
    <br>
    <form action="signup1" method="post">
      <div class="main-input-box">
        <div class="user-input-box">
           <label class="details">NAME:</label>
           <input type="text" maxlength="100" name="name" required>
        </div>
        <div class="user-input-box">
           <label class="details">FATHER'S NAME:</label>
           <input type="text" maxlength="100" name="fname" required>
        </div>
        <div class="user-input-box">
           <label class="details">DATE OF BIRTH:</label>
           <input type="date" name="dob" required>
        </div>
        <div class="user-input-box">
           <label class="details">GENDER:</label>
           <label for="male" class="radiobtn1"><input type="radio" id="male" name="gender" value="Male" required>&nbsp;MALE</label>
           <label for="female" class="radiobtn1"><input type="radio" id="female" name="gender" value="Female" required>&nbsp;FEMALE</label>
        </div>
        <div class="user-input-box">
           <label class="details">EMAIL ADDRESS:</label>
           <input type="email" name="email" required>
        </div>
        <div class="user-input-box">
           <label class="details">MARTIAL STATUS:</label>
           <label for="married" class="radiobtn2"><input type="radio" id="married" name="mstatus" value="Married" required>&nbsp;MARRIED</label>
           <label for="unmarried" class="radiobtn2"><input type="radio" id="unmarried" name="mstatus" value="Unmarried" required>&nbsp;UNMARRIED</label>
        </div>
        <div class="user-input-box">
           <label class="details">ADDRESS:</label>
           <input type="text" maxlength="500" name="address" required>
        </div>
        <div class="user-input-box">
           <label class="details">CITY:</label>
           <input type="text" maxlength="100" name="city" required>
        </div>
        <div class="user-input-box">
           <label class="details">STATE:</label>
           <input type="text" maxlength="100" name="state" required>
        </div> 
        <div class="user-input-box">  
           <label class="details">PINCODE:</label>
           <input type="text" pattern="[0-9]{6}" name="pincode" required>
        </div>
        <div class="user-input-btn">
           <button>NEXT</button>
        </div>
      </div>
    </form>
    </div>
</body>
</html>