package com.adp.dto;

import org.apache.struts.action.ActionForm;

public class JobDetailsForm extends ActionForm{
	String jobcode;
	String jobtitle;
	String description;
	public String getJobcode() {
		return jobcode;
	}
	public void setJobcode(String jobcode) {
		this.jobcode = jobcode;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
