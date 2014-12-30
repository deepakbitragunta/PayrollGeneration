package com.adp.dto;

import org.apache.struts.action.ActionForm;

public class EarnDedForm extends ActionForm {
	String emp_code;
	String earn_code;
	String earn_start_date;
	String ee_earn_end_date;
	String ee_earn_status_code;
	int ee_earn_dflt_amt;
	String ded_code;
	String ded_start_date;
	String ee_ded_end_date;
	String ee_ded_status_code;
	int ee_ded_dflt_amt;
	public String getEmp_code() {
		return emp_code;
	}
	public void setEmp_code(String empCode) {
		emp_code = empCode;
	}
	public String getEarn_code() {
		return earn_code;
	}
	public void setEarn_code(String earnCode) {
		earn_code = earnCode;
	}
	public String getEarn_start_date() {
		return earn_start_date;
	}
	public void setEarn_start_date(String earnStartDate) {
		earn_start_date = earnStartDate;
	}
	public String getEe_earn_end_date() {
		return ee_earn_end_date;
	}
	public void setEe_earn_end_date(String eeEarnEndDate) {
		ee_earn_end_date = eeEarnEndDate;
	}
	public String getEe_earn_status_code() {
		return ee_earn_status_code;
	}
	public void setEe_earn_status_code(String eeEarnStatusCode) {
		ee_earn_status_code = eeEarnStatusCode;
	}
	public int getEe_earn_dflt_amt() {
		return ee_earn_dflt_amt;
	}
	public void setEe_earn_dflt_amt(int eeEarnDfltAmt) {
		ee_earn_dflt_amt = eeEarnDfltAmt;
	}
	public String getDed_code() {
		return ded_code;
	}
	public void setDed_code(String dedCode) {
		ded_code = dedCode;
	}
	public String getDed_start_date() {
		return ded_start_date;
	}
	public void setDed_start_date(String dedStartDate) {
		ded_start_date = dedStartDate;
	}
	public String getEe_ded_end_date() {
		return ee_ded_end_date;
	}
	public void setEe_ded_end_date(String eeDedEndDate) {
		ee_ded_end_date = eeDedEndDate;
	}
	public String getEe_ded_status_code() {
		return ee_ded_status_code;
	}
	public void setEe_ded_status_code(String eeDedStatusCode) {
		ee_ded_status_code = eeDedStatusCode;
	}
	public int getEe_ded_dflt_amt() {
		return ee_ded_dflt_amt;
	}
	public void setEe_ded_dflt_amt(int eeDedDfltAmt) {
		ee_ded_dflt_amt = eeDedDfltAmt;
	}
	

}
