package com.adp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JobDetailsDAO {

	ConnectionDAO cobj;
	Connection con;
	Statement st;
	ResultSet rs;
	public JobDetailsDAO(ConnectionDAO cobj) throws Exception 
	{
		this.cobj = cobj;
		con = cobj.getConnection();
	}
	public boolean addUser(String job_code , String job_title ,String job_description) throws Exception
	{
		
			st = con.createStatement();
		int rt = st.executeUpdate("INSERT INTO job VALUES('"+job_code+"','"+job_title+"','"+job_description+"')");
		if(rt > 0 )
			return true;
		else
			return false;
	
	
	}
		
			
}
