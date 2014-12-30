package com.adp.dto;

import org.apache.struts.action.ActionForm;

public class PositionDetailsForm extends ActionForm{
	String bu_name;
	String job_title;
	String posn_id ;        
	String posn_title;      
	String startDay;
	String startMonth;
	String startYear;
	String endDay;
	String endMonth;
	String endYear;
 
	String posn_status_code;
	
	public String getStartDay() {
		return startDay;
	}
	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}
	public String getStartMonth() {
		return startMonth;
	}
	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}
	public String getStartYear() {
		return startYear;
	}
	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}
	public String getEndDay() {
		return endDay;
	}
	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}
	public String getEndMonth() {
		return endMonth;
	}
	public void setEndMonth(String endMonth) {
		this.endMonth = endMonth;
	}
	public String getEndYear() {
		return endYear;
	}
	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}
	public String getBu_name() {
		return bu_name;
	}
	public void setBu_name(String buName) {
		bu_name = buName;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String jobTitle) {
		job_title = jobTitle;
	}
	public String getPosn_id() {
		return posn_id;
	}
	public void setPosn_id(String posnId) {
		posn_id = posnId;
	}
	public String getPosn_title() {
		return posn_title;
	}
	public void setPosn_title(String posnTitle) {
		posn_title = posnTitle;
	}
	
	
	
	public String getPosn_status_code() {
		return posn_status_code;
	}
	public void setPosn_status_code(String posnStatusCode) {
		posn_status_code = posnStatusCode;
	} 
	

}
