package com.adp.dto;

import org.apache.struts.action.ActionForm;

public class AppointmentForm extends ActionForm{
	String emp_code;
	String appt_no;
	String appt_start_date;
	String appt_end_date;
	String bu_code;
	String job_code;
	String posn_id;
	String reports_to;
	public String getEmp_code() {
		return emp_code;
	}
	public void setEmp_code(String empCode) {
		emp_code = empCode;
	}
	public String getAppt_no() {
		return appt_no;
	}
	public void setAppt_no(String apptNo) {
		appt_no = apptNo;
	}
	public String getAppt_start_date() {
		return appt_start_date;
	}
	public void setAppt_start_date(String apptStartDate) {
		appt_start_date = apptStartDate;
	}
	public String getAppt_end_date() {
		return appt_end_date;
	}
	public void setAppt_end_date(String apptEndDate) {
		appt_end_date = apptEndDate;
	}
	public String getBu_code() {
		return bu_code;
	}
	public void setBu_code(String buCode) {
		bu_code = buCode;
	}
	public String getJob_code() {
		return job_code;
	}
	public void setJob_code(String jobCode) {
		job_code = jobCode;
	}
	public String getPosn_id() {
		return posn_id;
	}
	public void setPosn_id(String posnId) {
		posn_id = posnId;
	}
	public String getReports_to() {
		return reports_to;
	}
	public void setReports_to(String reportsTo) {
		reports_to = reportsTo;
	}
	
	

}
