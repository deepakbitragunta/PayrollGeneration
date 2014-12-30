package com.adp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;

public class EarningsDefinitionDAO {

	ConnectionDAO cobj;
	Connection con;
	Statement st;
	ResultSet rs;
	
	public EarningsDefinitionDAO(ConnectionDAO cobj) throws Exception
	{
		this.cobj = cobj;
		con = cobj.getConnection();
	}
	
	public int addEarnings(String earn_code, String earn_desc, String earn_strt_date, String earn_end_date, String earn_taxability, float earn_dflt_amount) throws SQLException
	{
		String insertStmnt = "insert into earning values('"+earn_code+"','"+earn_desc+"','"+earn_strt_date+"','"+earn_end_date+"','"+earn_taxability+"',"+earn_dflt_amount+")";
		st = con.createStatement();
		int res = st.executeUpdate(insertStmnt);
		return res;
	}
	
	public int deleteEarnings(String earn_code) throws SQLException
	{
		String delStmnt = "delete from earning where earn_code = '"+earn_code+"'";
		st = con.createStatement();
		int res = st.executeUpdate(delStmnt);
		return res;
	}
	
	public int modifyEarnings(String earn_code, String earn_desc, String earn_strt_date, String earn_end_date, String earn_taxability, float earn_dflt_amount) throws SQLException
	{
		String modifyStmnt = "update earning set earn_desc = '"+earn_desc+"',earn_start_date = '"+earn_strt_date+"',earn_end_date ='"+earn_end_date+"',earn_taxability = '"+earn_taxability+"',earn_dflt_amount = "+earn_dflt_amount+" where earn_code = '"+earn_code+"'";
		st = con.createStatement();
		int res = st.executeUpdate(modifyStmnt);
		System.out.println(modifyStmnt);
		System.out.println(res);
		return res;
	}
	
	public String[] getAllDetails(String earn_code) throws SQLException
	{
		String[] alldetails = new String[7];
		String stmnt = "select * from earning where earn_code = '"+earn_code+"'";
		st = con.createStatement();
		rs = st.executeQuery(stmnt);
		int i =1;
		while(rs.next())
		{
			for(i = 1;i < 6; i++)
			{
			alldetails[i-1] = rs.getString(i);
			}
			alldetails[i-1] = Integer.toString(rs.getInt(i));
		}
		
		return alldetails;
	}
}
