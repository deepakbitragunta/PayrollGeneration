package com.adp.dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class EmploymentDAO {

		
		Connection con;
		Statement st;
		
		
		public EmploymentDAO(ConnectionDAO cobj) throws Exception 
		{
			//this.cobj = cobj;
				con = cobj.getConnection();
		}
		
		public boolean insertEmploymentDetails(String emp_code,String hire_date,String emp_term_date,String ee_status,String full_part_time,String permanent_temp,String leaving_reason,String notice_period,String prob_period,String notice_period_unit,String prob_period_unit,String pay_frequency ) throws SQLException 
		{
			int result;
			st = con.createStatement();
			result = st.executeUpdate("INSERT INTO employment VALUES('"+emp_code+"','"+hire_date+"','"+emp_term_date+"','"+ee_status+"','"+full_part_time+"','"+permanent_temp+"','"+leaving_reason+"','"+notice_period+"','"+notice_period_unit+"','"+prob_period+"','"+prob_period_unit+"','"+pay_frequency+"')");
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
