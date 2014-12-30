package com.adp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PayCalendarDAO 
{
	ConnectionDAO cobj;
	Connection con;
	Statement st;
	ResultSet rs;
	
	public PayCalendarDAO(ConnectionDAO cobj) throws Exception
	{
		this.cobj = cobj;
		con = cobj.getConnection();
	}
	
	
	
	public boolean insertCalendar(int taxYear,String payFrequency) throws Exception
	{
		int payFreq=12;
		int status=0;
		int tax_start=taxYear;
		int tax_end=taxYear+1;
			st = con.createStatement();
			rs = st.executeQuery("select count(*) from pay_calendar where  tax_year="+taxYear);
		rs.next();
		if(rs.getInt(1)<1)
		{
			int monthNum = 4;
			int endDay;
			for(int pay_period_no=1;pay_period_no<=payFreq;pay_period_no++,monthNum++)
			{
				if( monthNum==1 || monthNum==3 || monthNum==5 || monthNum==7 || monthNum==8 || monthNum==10 || monthNum==12)
				{
					endDay = 31;
				}
				else if(monthNum==2 && taxYear%4==0)
				{
					endDay=29;
				}
				else if(monthNum==2 && taxYear%4!=0)
				{
					endDay =28;
				}
				else
				{
					endDay=30;
				}
			    st = con.createStatement();
			    String pay_period_start="'"+taxYear+"-"+monthNum+"-"+01+"'";
			    String pay_period_end="'"+taxYear+"-"+monthNum+"-"+endDay+"'";
			    String pay_date="'"+taxYear+"-"+monthNum+"-"+endDay+"'";
			    String pay_process_date="'"+taxYear+"-"+monthNum+"-"+(endDay-2)+"'";
			    String query = "insert into pay_calendar values('"+payFrequency+"',"+tax_start+","+pay_period_no+","+tax_start+","+tax_end+","+pay_period_start+","+pay_period_end+","+pay_date+","+pay_process_date+")" +
			    		";";
			    status = st.executeUpdate(query);
				if(monthNum==12)
				{
					monthNum=0;
					taxYear++;
				}
			}
		}
		return status>0;
	}
	
	public String[][] getCalendarRecords(int taxYear,String payFrequency) throws SQLException
	{
		String[][] calendarRecords = new String[12][5];
		st = con.createStatement();
		String query = "select * from pay_calendar where tax_year="+taxYear;
		rs = st.executeQuery(query);
		int i=0;
		while(rs.next())
		{
			calendarRecords[i][0]=Integer.toString(rs.getInt("pay_period_no"));
			calendarRecords[i][1]=rs.getString("pay_period_start");
			calendarRecords[i][2]=rs.getString("pay_period_end");
			calendarRecords[i][3]=rs.getString("pay_date");
			calendarRecords[i][4]=rs.getString("pay_process_date");
			i++;
		}
		return calendarRecords;
	}
}
	

