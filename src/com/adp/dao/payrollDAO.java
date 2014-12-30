package com.adp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class payrollDAO {
	
	
	Connection con;
	Statement st,st2;
	ResultSet rs;
	
	
	public payrollDAO(ConnectionDAO cobj) throws Exception 
	{
		//this.cobj = cobj;
			con = cobj.getConnection();
	}
	
	public ResultSet getEmployment() throws SQLException
	{
		st = con.createStatement();
		rs = st.executeQuery("SELECT employee_code,emp_hire_date,emp_term_date,ee_status FROM employment");
		return rs;
	}
	public ResultSet getPayCalendar(int pay_period_no,int tax_year,String pay_frequency) throws SQLException
	{
		st = con.createStatement();
		rs = st.executeQuery("SELECT pay_period_start,pay_period_end FROM pay_calendar WHERE pay_period_no= "+pay_period_no+" AND tax_year = "+tax_year+" AND pay_frequency = '"+pay_frequency+"' ");
		return rs;
	}
	public ResultSet getEmpEarning() throws SQLException
	{
		st = con.createStatement();
		rs = st.executeQuery("SELECT ee_earn_status_code, ee_earn_start_date, ee_earn_end_date FROM ee_earning");
		return rs;
	}
	
	public ResultSet getEmpDeduciton() throws SQLException
	{
		st = con.createStatement();
		rs = st.executeQuery("SELECT ee_ded_status_code, ee_ded_start_date, ee_ded_end_date FROM ee_deduction");
		return rs;
	}
	public void copyEarnAmt(String employee_code,String pay_frequency,int tax_year,int pay_period_no) throws SQLException
	{
		st = con.createStatement();
		st2 = con.createStatement();
		st2.executeUpdate("DELETE FROM ee_earn_result where pay_frequency = '"+pay_frequency+"'and tax_year = "+tax_year+" and pay_period_no = "+pay_period_no+" and employee_code = '"+employee_code+"'");
		rs = st.executeQuery("SELECT earn_code,ee_earn_dflt_amt FROM ee_earning where employee_code = '"+employee_code+"' ");
		while(rs.next()) {
		st2.executeUpdate("INSERT INTO ee_earn_result VALUES('"+employee_code+"','"+pay_frequency+"',"+tax_year+","+pay_period_no+",'"+rs.getString(1)+"',"+rs.getFloat(2)+",10)");
		}
	}
	public void copyDedAmt(String employee_code,String pay_frequency,int tax_year,int pay_period_no) throws SQLException
	
	{
		st = con.createStatement();
		st2 = con.createStatement();
		st2.executeUpdate("DELETE FROM ee_ded_result where pay_frequency = '"+pay_frequency+"'and tax_year = "+tax_year+" and pay_period_no = "+pay_period_no+" and employee_code = '"+employee_code+"'");
		rs = st.executeQuery("SELECT ded_code,ee_ded_dflt_amt FROM ee_deduction where employee_code ='"+employee_code+"'");
		while(rs.next()) {	
		st2.executeUpdate("INSERT INTO ee_ded_result VALUES('"+employee_code+"','"+pay_frequency+"',"+tax_year+","+pay_period_no+",'"+rs.getString(1)+"',"+rs.getFloat(2)+",10) ");		
		}
	}
	
	
	public float getEarnResultAmt(String emp_code,String pay_frequency,int tax_year,int pay_period_no) throws SQLException
	{
		st = con.createStatement();
		
		rs = st.executeQuery("SELECT SUM(ee_earn_amt) FROM ee_earn_result WHERE pay_frequency = '"+pay_frequency+"'and tax_year = "+tax_year+" and pay_period_no = "+pay_period_no+" and employee_code = '"+emp_code+"'");
		rs.next();
		return rs.getFloat(1);
	}
	public float getDedResultAmt(String emp_code,String pay_frequency,int tax_year,int pay_period_no) throws SQLException
	{
		st = con.createStatement();
		rs = st.executeQuery("SELECT SUM(ee_ded_amt) FROM ee_ded_result WHERE pay_frequency = '"+pay_frequency+"'and tax_year = "+tax_year+" and pay_period_no = "+pay_period_no+" and employee_code = '"+emp_code+"'");
		rs.next();
		return rs.getFloat(1);
	}
	
	public void insertTaxResults(String emp_code,String pay_frequency,int tax_year,int pay_period,float tax_amt,float tax) throws SQLException
	{
		
		st = con.createStatement();
		st.executeUpdate("DELETE FROM ee_tax_result where pay_frequency = '"+pay_frequency+"'and tax_year = "+tax_year+" and pay_period_no = "+pay_period+" and employee_code = '"+emp_code+"'");
		st.executeUpdate("INSERT INTO ee_tax_result VALUES('"+emp_code+"','"+pay_frequency+"',"+tax_year+","+pay_period+","+tax_amt+","+tax+")"); 
	}
	
	

}
