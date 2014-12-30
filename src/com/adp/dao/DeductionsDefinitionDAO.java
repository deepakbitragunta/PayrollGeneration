package com.adp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;

public class DeductionsDefinitionDAO {

	ConnectionDAO cobj;
	Connection con;
	Statement st;
	ResultSet rs;
	
	public DeductionsDefinitionDAO(ConnectionDAO cobj) throws Exception
	{
		this.cobj = cobj;
		con = cobj.getConnection();
	}
	
	public int addDeductions(String ded_code, String ded_desc, String ded_strt_date, String ded_end_date, String er_code, String ded_taxability, float ded_dflt_amount) throws SQLException
	{
		String insertStmnt = "insert into deduction values('"+ded_code+"','"+ded_desc+"','"+ded_strt_date+"','"+ded_end_date+"','"+er_code+"','"+ded_taxability+"',"+ded_dflt_amount+")";
		Statement st = con.createStatement();
		int res = st.executeUpdate(insertStmnt);
		con.close();
		return res;
	}
	
	public int deleteDeductions(String ded_code) throws SQLException
	{
		String delStmnt = "delete from deduction where ded_code = '"+ded_code+"'";
		Statement st = con.createStatement();
		int res = st.executeUpdate(delStmnt);
		con.close();
		return res;
	}
	
	public int modifyDeductionsOnDescription(String ded_code, String ded_desc) throws SQLException
	{
		String modifyStmnt = "update deduction set ded_desc = '"+ded_desc+"' where ded_code = '"+ded_code+"'";
		Statement st = con.createStatement();
		int res = st.executeUpdate(modifyStmnt);
		return res;
	}
	
	public int modifyDeductionsOnStrtdate(String ded_code, String strt_date) throws SQLException
	{
		String modifyStmnt = "update deduction set ded_start_date = '"+strt_date+"' where ded_code = '"+ded_code+"'";
		Statement st = con.createStatement();
		int res = st.executeUpdate(modifyStmnt);
		return res;
	}
	
	public int modifyDeductionsOnEnddate(String ded_code, String strt_date) throws SQLException
	{
		String modifyStmnt = "update deduction set ded_end_date = '"+strt_date+"' where ded_code = '"+ded_code+"'";
		Statement st = con.createStatement();
		int res = st.executeUpdate(modifyStmnt);
		return res;
	}
	
	public int modifyDeductionsOnErCode(String ded_code, String er_code) throws SQLException
	{
		String modifyStmnt = "update deduction set ee_er_code = '"+er_code+"' where ded_code = '"+ded_code+"'";
		Statement st = con.createStatement();
		int res = st.executeUpdate(modifyStmnt);
		return res;
	}
	
	public int modifyDeductionsOnTaxability(String ded_code, String taxability) throws SQLException
	{
		String modifyStmnt = "update deduction set ded_taxability = '"+taxability+"' where ded_code = '"+ded_code+"'";
		Statement st = con.createStatement();
		int res = st.executeUpdate(modifyStmnt);
		return res;
	}
	
	public int modifyDeductionsOnDefaultAmnt(String ded_code, float default_amnt) throws SQLException
	{
		String modifyStmnt = "update deduction set ded_dflt_amount = '"+default_amnt+"' where ded_code = '"+ded_code+"'";
		Statement st = con.createStatement();
		int res = st.executeUpdate(modifyStmnt);
		return res;
	}
	
}
