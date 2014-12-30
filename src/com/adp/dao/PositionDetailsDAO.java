package com.adp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PositionDetailsDAO {
	ConnectionDAO cobj;
	Connection con;
	Statement st;
	ResultSet rs;
	ResultSet ps;
	int rt;
	public PositionDetailsDAO(ConnectionDAO cobj) throws Exception 
	{
		this.cobj = cobj;
			con = cobj.getConnection();
	}
	public boolean addUser(String bu_name,String job_title,String posn_id,String posn_title ,String startYear,String startMonth,String startDay,String endYear,String endMonth,String endDay,String posn_status_code) throws SQLException 
	{
		String name = null;
			st = con.createStatement();
		
			String insrtStmnt = "Insert into positn values('"+bu_name+"','"+job_title+"','"+posn_id+"','"+posn_title+"','"+startYear+"-"+startMonth+"-"+startDay+"','"+endYear+"-"+endMonth+"-"+endDay+"','"+posn_status_code+"')";
			System.out.println(insrtStmnt);
			rt = st.executeUpdate(insrtStmnt);
		
		if(rt > 0 )
			return true;
		else
			return false;
	}

}
