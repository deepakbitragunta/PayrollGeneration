package com.adp.dto;

import org.apache.struts.action.ActionForm;

public class payrollForm extends ActionForm{
	String pay_frequency;
	int tax_year;
	int pay_period_no;
	public int getPay_period_no() {
		return pay_period_no;
	}
	public void setPay_period_no(int payPeriodNo) {
		pay_period_no = payPeriodNo;
	}
	public String getPay_frequency() {
		return pay_frequency;
	}
	public void setPay_frequency(String payFrequency) {
		
		pay_frequency = payFrequency;
	}
	public int getTax_year() {
		return tax_year;
	}
	public void setTax_year(int taxYear) {
		tax_year = taxYear;
	}
	

}
