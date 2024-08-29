package com.incapp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class DAO {
	private static String url = "jdbc:mysql://localhost:3306/bankmanagement";
	private static String username = "root";
	private static String password = "k@rtik2002";
	Connection c;

	public DAO() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		c = DriverManager.getConnection(url, username, password);
	}

	public void closeConnection() throws SQLException {
		c.close();
	}

	public ResultSet login(String cardno, String pinno) throws SQLException {
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM login WHERE cardno=" + cardno + " AND pinno=" + pinno + "");
		return rs;
	}

	public void signUp1(LinkedHashMap<String, String> data) throws SQLException {
		PreparedStatement p = c.prepareStatement("INSERT INTO signup VALUES(?,?,?,?,?,?,?,?,?,?,?)");
		p.setLong(1, Long.parseLong(data.get("formno")));
		p.setString(2, data.get("name"));
		p.setString(3, data.get("fname"));
		p.setString(4, data.get("dob"));
		p.setString(5, data.get("gender"));
		p.setString(6, data.get("email"));
		p.setString(7, data.get("mstatus"));
		p.setString(8, data.get("address"));
		p.setString(9, data.get("city"));
		p.setString(10, data.get("state"));
		p.setString(11, data.get("pincode"));
		p.executeUpdate();
	}
	
	public void signUp2(LinkedHashMap<String, String> data) throws SQLException {
		PreparedStatement p=c.prepareStatement("INSERT INTO signup2 VALUES(?,?,?,?,?,?,?,?,?,?)");
		p.setLong(1, Long.parseLong(data.get("formno")));
		p.setString(2, data.get("religion"));
		p.setString(3, data.get("category"));
		p.setString(4, data.get("income"));
		p.setString(5, data.get("eduqualification"));
		p.setString(6, data.get("occupation"));
		p.setString(7, data.get("pannumber"));
		p.setString(8, data.get("aadharnumber"));
		p.setString(9, data.get("seniorcitizen"));
		p.setString(10, data.get("exaccount"));
		p.executeUpdate();
	}
	
	public void signUp3(LinkedHashMap<String, String> data) throws SQLException {
		PreparedStatement p=c.prepareStatement("INSERT INTO signup3 VALUES(?,?,?,?,?)");
		p.setLong(1, Long.parseLong(data.get("formno")));
		p.setString(2, data.get("acctype"));
		p.setString(3, data.get("scardno"));
		p.setString(4, data.get("spinno"));
		p.setString(5, data.get("servicesrequired"));
		p.executeUpdate();
		
		PreparedStatement p2=c.prepareStatement("INSERT INTO login VALUES(?,?,?)");
		p2.setLong(1, Long.parseLong(data.get("formno")));
		p2.setString(2, data.get("scardno"));
		p2.setString(3, data.get("spinno"));
		p2.executeUpdate();
	}
	
	public ArrayList<LinkedHashMap<String, String>> accountDetail(String pinno) throws SQLException {

		ArrayList<LinkedHashMap<String, String>> allHistory = new ArrayList<LinkedHashMap<String, String>>();

		PreparedStatement p = c.prepareStatement("SELECT formno FROM signup3 WHERE pinno=?");
		p.setString(1, pinno);
		ResultSet rs = p.executeQuery();
		Long formno = null;
		if (rs.next()) {
			formno = Long.parseLong(rs.getString("formno"));
		}

		PreparedStatement p1 = c.prepareStatement("SELECT * FROM signup WHERE formno=?");
		p1.setLong(1, formno);
		ResultSet rs1 = p1.executeQuery();
		while (rs1.next()) {
			LinkedHashMap<String, String> history = new LinkedHashMap<String, String>();
			history.put("FormNo.", rs1.getString("formno"));
			history.put("Name", rs1.getString("name"));
			history.put("Father's Name", rs1.getString("fname"));
			history.put("Date Of Birth", rs1.getString("dob"));
			history.put("Gender", rs1.getString("gender"));
			history.put("Email", rs1.getString("email"));
			history.put("Marital Status", rs1.getString("marital"));
			history.put("Address", rs1.getString("address"));
			history.put("City", rs1.getString("city"));
			history.put("State", rs1.getString("state"));
			history.put("Zip Code", rs1.getString("pin"));
			allHistory.add(history);
		}

		PreparedStatement p2 = c.prepareStatement("SELECT * FROM signup2 WHERE formno=?");
		p2.setLong(1, formno);
		ResultSet rs2 = p2.executeQuery();
		while (rs2.next()) {
			LinkedHashMap<String, String> history = new LinkedHashMap<String, String>();
			history.put("Religion", rs2.getString("religion"));
			history.put("Category", rs2.getString("category"));
			history.put("Income", rs2.getString("income"));
			history.put("Occupation", rs2.getString("occupation"));
			history.put("Pan No.", rs2.getString("pan"));
			history.put("Aadhar No.", rs2.getString("aadhar"));
			history.put("Senior Citizen", rs2.getString("senoircitizen"));
			history.put("Existing Account", rs2.getString("existingaccount"));
			allHistory.add(history);
		}

		PreparedStatement p3 = c.prepareStatement("SELECT * FROM signup3 WHERE formno=?");
		p3.setLong(1, formno);
		ResultSet rs3 = p3.executeQuery();
		while (rs3.next()) {
			LinkedHashMap<String, String> history = new LinkedHashMap<String, String>();
			history.put("Account Type", rs3.getString("accounttype"));
			history.put("Card No.", rs3.getString("cardno"));
			history.put("Pin No.", rs3.getString("pinno"));
			history.put("Services", rs3.getString("services"));
			allHistory.add(history);
		}
		return allHistory;
	}
	
	public ResultSet balance(String pinNo) throws SQLException {
		PreparedStatement p1=c.prepareStatement("SELECT * FROM bank WHERE pin=?");
    	p1.setString(1, pinNo);
    	return p1.executeQuery();
	}
	
	public void deposit(LinkedHashMap<String, String> data) throws SQLException {
		PreparedStatement p=c.prepareStatement("INSERT INTO bank VALUES(?,?,?,?)");
    	p.setString(1,data.get("pinNo"));
    	p.setString(2,data.get("date"));
    	p.setString(3,"Deposit");
    	p.setString(4,data.get("depositAmount"));
    	p.executeUpdate();
	}
	
	public ResultSet transactionHistory(String pinNo) throws SQLException{	    	
    	PreparedStatement p1=c.prepareStatement("SELECT * FROM bank WHERE pin=?");
    	p1.setString(1, pinNo);
    	return p1.executeQuery();
	}
	
	public ResultSet withdrawal(String pinNo) throws SQLException{
    	PreparedStatement p1=c.prepareStatement("SELECT * FROM bank WHERE pin=?");
    	p1.setString(1, pinNo);
    	return p1.executeQuery();
	}
	
	public void amountWithdrawal(LinkedHashMap<String, String> data) throws SQLException{
		PreparedStatement p2=c.prepareStatement("INSERT INTO bank VALUES(?,?,?,?)");
    	p2.setString(1,data.get("pinNo"));
    	p2.setString(2,data.get("date"));
    	p2.setString(3,"Withdrawal");
    	p2.setString(4,data.get("withdrawalAmount"));
    	p2.executeUpdate();
	}
}
