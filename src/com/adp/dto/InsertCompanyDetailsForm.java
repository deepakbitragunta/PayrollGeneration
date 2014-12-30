package com.adp.dto;

import java.sql.Date;

import org.apache.struts.action.ActionForm;

public class InsertCompanyDetailsForm extends ActionForm {
	String company_code;
	String company_name;
	Date cmp_start_date;
	Date cmp_end_date;
	String cmp_add_ln1;
	String cmp_add_ln2;  
	String cmp_add_ln3;
	String cmp_town;
	String cmp_state; 
    String cmp_country; 
    int	cmp_postcode; 
	String cmp_phone;
	public String getCompany_code() {
		return company_code;
	}
	public void setCompany_code(String companyCode) {
		company_code = companyCode;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String companyName) {
		company_name = companyName;
	}
	public Date getCmp_start_date() {
		return cmp_start_date;
	}
	public void setCmp_start_date(Date cmpStartDate) {
		cmp_start_date = cmpStartDate;
	}
	public Date getCmp_end_date() {
		return cmp_end_date;
	}
	public void setCmp_end_date(Date cmpEndDate) {
		cmp_end_date = cmpEndDate;
	}
	public String getCmp_add_ln1() {
		return cmp_add_ln1;
	}
	public void setCmp_add_ln1(String cmpAddLn1) {
		cmp_add_ln1 = cmpAddLn1;
	}
	public String getCmp_add_ln2() {
		return cmp_add_ln2;
	}
	public void setCmp_add_ln2(String cmpAddLn2) {
		cmp_add_ln2 = cmpAddLn2;
	}
	public String getCmp_add_ln3() {
		return cmp_add_ln3;
	}
	public void setCmp_add_ln3(String cmpAddLn3) {
		cmp_add_ln3 = cmpAddLn3;
	}
	public String getCmp_town() {
		return cmp_town;
	}
	public void setCmp_town(String cmpTown) {
		cmp_town = cmpTown;
	}
	public String getCmp_state() {
		return cmp_state;
	}
	public void setCmp_state(String cmpState) {
		cmp_state = cmpState;
	}
	public String getCmp_country() {
		return cmp_country;
	}
	public void setCmp_country(String cmpCountry) {
		cmp_country = cmpCountry;
	}
	public int getCmp_postcode() {
		return cmp_postcode;
	}
	public void setCmp_postcode(int cmpPostcode) {
		cmp_postcode = cmpPostcode;
	}
	public String getCmp_phone() {
		return cmp_phone;
	}
	public void setCmp_phone(String cmpPhone) {
		cmp_phone = cmpPhone;
	}
	

}
