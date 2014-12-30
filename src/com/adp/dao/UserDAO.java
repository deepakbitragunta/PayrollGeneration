package com.adp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class UserDAO {

	ConnectionDAO cobj;
	Connection con;
	Statement st;
	int rs;
	ResultSet rset;
	
	public 	UserDAO(ConnectionDAO cobj) throws Exception
	{
		this.cobj = cobj;
		con = cobj.getConnection();
	}

	public boolean updateDetails(String companyCode, String companyName,
			Date cmpStartDate, Date cmpEndDate, String cmpAddLn1,
			String cmpAddLn2, String cmpAddLn3, String cmpTown,
			String cmpState, String cmpCountry, int cmpPostcode, String cmpPhone)throws Exception
			
			{
				st = con.createStatement();
				rs = st.executeUpdate("update company set company_code = '" + companyCode + "' ,company_name ='"+companyName+"',cmp_start_date ='"+cmpStartDate+"',cmp_end_date='"+cmpEndDate+"',cmp_add_ln1='"+cmpAddLn1+"',cmp_add_ln2='"
						+cmpAddLn2+"',cmp_add_ln3='"+cmpAddLn3+"',cmp_town='"+cmpTown+"',cmp_state='"+cmpState+"',cmp_country='"+cmpCountry+"',cmp_postcode='"+cmpPostcode+"',cmp_phone='"+cmpPhone+"'");
				if(rs>0)
				{
					return true;
				}
				else 
					return false;
				
				
				
			}

	public boolean insertDetails(String buCode, String buName,
			Date buEffectiveFrom, Date buEffectiveTo, String buType,
			String buParent) throws Exception { 
		
		st = con.createStatement();
		rs = st.executeUpdate("insert into business_unit values('"+buCode+"','"+buName+"','"+buEffectiveFrom+"','"+buEffectiveTo+"','"+buType+"','"+buParent+"');");
		if(rs>0)
		{
			return true;
		}
		else 
			return false;
		
		
		
	}

	public String[] getAllDetails(String companyName) throws SQLException
		{
			String[] alldetails = new String[12];
			String stmnt = "select * from company where company_name = '"+companyName+"'";
			st = con.createStatement();
			ResultSet rs = st.executeQuery(stmnt);
			int i =1;
			while(rs.next())
			{
				for(i = 1;i < 11; i++)
				{
				alldetails[i-1] = rs.getString(i);
				}
				alldetails[i-1] = Integer.toString(rs.getInt(i));
				i++;
				alldetails[i-1] = rs.getString(i);
				
			}
			
			return alldetails;
		}

	public boolean insertCompany(String companyCode, String companyName,
			Date cmpStartDate, Date cmpEndDate, String cmpAddLn1,
			String cmpAddLn2, String cmpAddLn3, String cmpTown,
			String cmpState, String cmpCountry, int cmpPostcode, String cmpPhone) throws Exception{
		st = con.createStatement();
		rs = st.executeUpdate("insert into company values('"+companyCode+"','"+companyName+"','"+cmpStartDate+"','"+cmpEndDate+"','"+cmpAddLn1+"','"+cmpAddLn2+"','"+cmpAddLn3+"','"+cmpTown+"','"+cmpState+"','"+cmpCountry+"',"+cmpPostcode+",'"+cmpPhone+"')");
		if(rs>0)
		{
			return true;
		}
		else 
			return false;
		
	}
	
	public ResultSet getCompnayName() throws SQLException
	{
		st = con.createStatement();
		rset = st.executeQuery("SELECT company_name,COUNT(*) FROM company");
		rset.next();
		return rset;
	}
	
	}
	