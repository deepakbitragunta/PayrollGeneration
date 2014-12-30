package com.adp.action;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class payrollValidationAction {
	
	ResultSet validemps;
	
	public boolean checkStatus(String s1,String s2,String s3) throws SQLException
	{
		return s1.equalsIgnoreCase("current") && s2.equalsIgnoreCase("current") && s3.equalsIgnoreCase("current");
	}	
	
	public boolean checkDates(Date hire,Date start,Date term,Date end)
	{
	   return hire.before(start) && term.after(end);
	}
		
	public boolean checkEarnDates(Date earn_start,Date ded_start,Date earn_end,Date ded_end,Date pay_start,Date pay_end)
	{
	   return earn_start.before(pay_start) && earn_end.after(pay_end) && ded_start.before(pay_start) && ded_end.after(pay_end) ;
	}
}
