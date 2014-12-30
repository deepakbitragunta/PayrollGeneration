package com.adp.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpEarnDedDAO {
	Connection con;
	Statement st;
	
	
	public EmpEarnDedDAO(ConnectionDAO cobj) throws Exception 
	{
			con = cobj.getConnection();
	}
	
	public boolean insertEmpEarnings(String emp_code,String earn_code,String earn_start_date,String ee_earn_end_date,String ee_earn_status_code,int ee_earn_dflt_amt) throws SQLException 
	{
		int result;
		st = con.createStatement();
		result = st.executeUpdate("INSERT INTO ee_earning VALUES('"+emp_code+"','"+earn_code+"','"+earn_start_date+"','"+ee_earn_end_date+"','"+ee_earn_status_code+"',"+ee_earn_dflt_amt+")");
		if(result > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean insertEmpDeductions(String emp_code,String ded_code,String ded_start_date,String ee_ded_end_date,String ee_ded_status_code,int ee_ded_dflt_amt) throws SQLException 
	{
		int result;
		st = con.createStatement();
		result = st.executeUpdate("INSERT INTO ee_deduction VALUES('"+emp_code+"','"+ded_code+"','"+ded_start_date+"','"+ee_ded_end_date+"','"+ee_ded_status_code+"',"+ee_ded_dflt_amt+")");
		if(result > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
