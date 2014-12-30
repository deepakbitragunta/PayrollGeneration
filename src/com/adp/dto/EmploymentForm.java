package com.adp.dto;

import org.apache.struts.action.ActionForm;

public class EmploymentForm extends ActionForm{
	String emp_code;
	String hire_date;
	String emp_term_date;
	String ee_status;
	String full_part_time;
	String permanent_temp;
	String leaving_reason;
	String notice_period;
	String notice_period_unit;
	String prob_period;
	String prob_period_unit;
	String pay_frequency;
	
	public void setEmp_code(String empCode) {
		
		emp_code = empCode;
	}
	public String getEmp_code() {
		
		return emp_code;
	}

	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hireDate) {
		hire_date = hireDate;
	}
	public String getEmp_term_date() {
		return emp_term_date;
	}
	public void setEmp_term_date(String empTermDate) {
		emp_term_date = empTermDate;
	}
	public String getEe_status() {
		return ee_status;
	}
	public void setEe_status(String eeStatus) {
		ee_status = eeStatus;
	}
	public String getFull_part_time() {
		return full_part_time;
	}
	public void setFull_part_time(String fullPartTime) {
		full_part_time = fullPartTime;
	}
	public String getPermanent_temp() {
		return permanent_temp;
	}
	public void setPermanent_temp(String permanentTemp) {
		permanent_temp = permanentTemp;
	}
	public String getLeaving_reason() {
		return leaving_reason;
	}
	public void setLeaving_reason(String leavingReason) {
		leaving_reason = leavingReason;
	}
	public String getNotice_period() {
		return notice_period;
	}
	public void setNotice_period(String noticePeriod) {
		notice_period = noticePeriod;
	}
	public String getNotice_period_unit() {
		return notice_period_unit;
	}
	public void setNotice_period_unit(String noticePeriodUnit) {
		notice_period_unit = noticePeriodUnit;
	}
	public String getProb_period() {
		return prob_period;
	}
	public void setProb_period(String probPeriod) {
		prob_period = probPeriod;
	}
	public String getProb_period_unit() {
		return prob_period_unit;
	}
	public void setProb_period_unit(String probPeriodUnit) {
		prob_period_unit = probPeriodUnit;
	}
	public String getPay_frequency() {
		return pay_frequency;
	}
	public void setPay_frequency(String payFrequency) {
		pay_frequency = payFrequency;
	}
	
	
}
