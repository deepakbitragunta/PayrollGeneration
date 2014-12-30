package com.adp.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AppointmentDAO {
	Connection con;
	Statement st;
	
	
	public AppointmentDAO(ConnectionDAO cobj) throws Exception 
	{
		//this.cobj = cobj;
			con = cobj.getConnection();
	}
	
	public boolean insertAppointmentDetails(String emp_code,String appt_no,String appt_start_date,String appt_end_date,String bu_code,String job_code,String posn_id,String reports_to ) throws SQLException 
	{
		int result;
		st = con.createStatement();
		result = st.executeUpdate("INSERT INTO appointment VALUES('"+emp_code+"','"+appt_no+"','"+appt_start_date+"','"+appt_end_date+"','"+bu_code+"','"+job_code+"','"+posn_id+"','"+reports_to+"')");
		con.close();
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
