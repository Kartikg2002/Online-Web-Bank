<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
          
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href="indexstyle.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
        href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
        rel="stylesheet">
</head>

<body>
    
    <%
    String loginerr = (String) session.getAttribute("loginerr");
    if(loginerr != null){	
    %>
    	<div style="background-color:red;font-size:2rem;text-align:center;width:100%;"><%=loginerr%></div>  	
    <%	
       session.setAttribute("loginerr",null);
    }  
    %>
    
    <%
    String msg = (String) session.getAttribute("msg");
    if(msg != null){	
    %>
    	<div style="background-color:red;font-size:2rem;text-align:center;width:100%;"><%=msg%></div>  	
    <%	
       session.setAttribute("msg",null);
    }  
    %>
    
    <nav class="navbar">
        <div class="container">
            <h1 class="logo">YES BANK</h1>
            <ul class="nav-links">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="about.html">About Us</a></li>
                <li><a href="contact.html">Contact</a></li>
                <li><a href="WhatsNew.html">What's New</a></li>
            </ul>
        </div>
    </nav>
    <main class="mainbody">
        <div class="leftbody">
            <h1>Your Trusted Financial Partner</h1>
            <p> <span>Our Bank </span> offers different types of accounts to meet your financial goals and secure your
                future. Yes Bank is a prominent private sector bank in India, offering a wide range of banking and financial services to individual consumers, small and medium-sized enterprises (SMEs), and large corporations.
            </p>
        </div>
        <div class="right-body">
            <h1>WELCOME TO ATM</h1>
            <form action="login">
                <div class="main-input">
                    <div class="user-input">
                        <label>CARD NO.</label>
				        <input type="text" name="cardno" maxlength="16" pattern="[0-9]{16}" placeholder="Enter Your 16 Digit Card Number" required>
                    </div>
                    <div class="user-input">
                        <label>PIN NO.</label>
				        <input type="text" name="pinno" maxlength="4" pattern="[0-9]{4}" placeholder="Enter Your 4 Digit Pin Number" required>
                    </div>
                    <div class="form-btn">
                        <button>LOGIN</button>
                    </div>
                </div>
            </form>
            <div class="btns">
                <a href="signup1.jsp"><button>SIGNUP</button></a>
            </div>
        </div>
    </main>
    
    <div class="sepration"></div>
    
    <div class="lowermain">
        <div class="lowermainleft">
            <h2>Services We Provide</h2>
        </div>
        <div class="lowermainright">
            <ul style="padding-left: 20px; line-height: 1.6;">
                <li>
                    <strong>Savings Accounts:</strong> A variety of savings accounts tailored to meet your personal needs with attractive interest rates and seamless online banking.
                </li>
                <li>
                    <strong>Loans:</strong> Flexible loan options including home, personal, car, and business loans at competitive rates with easy processing and minimal documentation.
                </li>
                <li>
                    <strong>Investment Opportunities:</strong> Diversified investment options including mutual funds, fixed deposits, and bonds designed to grow your wealth effectively.
                </li>
                <li>
                    <strong>Digital Banking:</strong> Experience state-of-the-art digital banking with our mobile app and internet banking solutions, ensuring security and convenience at your fingertips.
                </li>
                <li>
                    <strong>Corporate Banking:</strong> Comprehensive solutions for businesses with services like cash management, trade finance, and working capital management.
                </li>
                <li>
                    <strong>NRI Services:</strong> Customized services for Non-Resident Indians, including NRE/NRO accounts, remittance services, and investment advisory.
                </li>
                <li>
                    <strong>Insurance Solutions:</strong> A wide range of insurance products including life, health, and general insurance to protect you and your loved ones.
                </li>
                <li>
                    <strong>Wealth Management:</strong> Tailored wealth management services with personalized investment strategies for high-net-worth individuals.
                </li>
                <li>
                    <strong>Green Banking Initiatives:</strong> Promoting sustainable banking practices through green loans and environmentally friendly projects.
                </li>
            </ul>
        </div>
    </div>
    <div class="bottomsepration">
        <div class="sepration2"></div>
    </div>
    <div class="bottommain">
        <div class="savings">
            <h2>Savings Account</h2>
            <p>Our Savings Accounts are designed to meet your financial goals with attractive interest rates and benefits. Open an account today and start saving for a secure future.</p>
        </div>
        <div class="loans">
            <h2>Loans</h2>
            <p>Explore our loan offerings for personal, home, auto, and business needs. Enjoy competitive interest rates, flexible tenures, and quick approvals with Yes Bank loans.</p>
        </div>
        <div class="investment">
            <h2>Investment Opportunities</h2>
            <p>Diversify your portfolio with our range of investment products, including mutual funds, fixed deposits, and bonds, to maximize your wealth potential.</p>
        </div>
    </div>
    <!-- Footer -->
	<footer class="footer" style="background-color: #01bfff;
	color: #fff;
	text-align: center;
	padding: 20px;
	margin-top: 40px;">
		<p style="margin:0;">© 2024 YES BANK. All rights reserved.</p>
	</footer>
</body>
</html>
