package com.adp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;

public class PaySlipDAO {

	ConnectionDAO cobj;
	Connection con;
	Statement st;
	ResultSet rs;
	
	public PaySlipDAO(ConnectionDAO cobj) throws Exception
	{
		this.cobj = cobj;
		con = cobj.getConnection();
	}
	
	public String[][] getDetails(String code, int periodno, int taxyear) throws Exception
	{
		String result[][] = new String[20][10];
		st = con.createStatement();
		float sum_earn = 0, sum_ded = 0;
		int i;
		String selctStmnt = "select employee_code, first_name, middle_name, last_name from employee_info where employee_code = '"+code+"'";
		rs = st.executeQuery(selctStmnt);
		while(rs.next())
		{
			result[0] = new String[10];
			for(i = 0; i<4; i++ )
			{
				result[0][i] = rs.getString(i+1);
			}
		}
		selctStmnt = "select e.pay_period_no, e.tax_year,  p.pay_date from ee_tax_result e, pay_calendar p where ((e.pay_period_no = "+periodno+") and (e.tax_year = "+taxyear+") and (e.employee_code = '"+code+"'))";
		System.out.println(selctStmnt);
		rs = st.executeQuery(selctStmnt);
		while(rs.next())
		{
			result[1] = new String[10];
			for(i = 0; i < 3; i++ )
			{
				result[1][i] = Integer.toString(rs.getInt(i+1));
				
			}
		}
		int j = 2;
		selctStmnt = "select earn_code, ee_earn_amt from ee_earn_result where employee_code = '"+code+"' and pay_period_no = "+periodno+" and tax_year = "+taxyear;
		System.out.println(selctStmnt);
		rs = st.executeQuery(selctStmnt);
		while(rs.next())
		{
			result[j] = new String[10];
			result[j][0] = "1";
			result[j][1] = rs.getString(1);
			sum_earn += rs.getFloat(2);
			result[j][2] = Float.toString(rs.getFloat(2));
			System.out.println(result[j][1]);
			j++;
		}
		selctStmnt = "select ded_code, ee_ded_amt from ee_ded_result where employee_code = '"+code+"' and pay_period_no = "+result[1][0]+" and tax_year = "+result[1][1];
		rs = st.executeQuery(selctStmnt);
		while(rs.next())
		{
			result[j] = new String[10];
			result[j][0] = "0";
			result[j][1] = rs.getString(1);
			sum_ded += rs.getFloat(2);
			result[j][2] = Float.toString(rs.getFloat(2));
			System.out.println(result[j][1]);
			j++;
		}
		result[j][0] = Float.toString(sum_earn);
		result[j][1] = Float.toString(sum_ded);
		result[j][2] = Float.toString(sum_earn - sum_ded);
		System.out.println(result[0][0]);
		
		return result;
	}
}
