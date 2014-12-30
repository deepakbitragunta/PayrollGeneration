package com.adp.dto;

import org.apache.struts.action.ActionForm;

public class EmployeeInfoDeleteForm extends ActionForm {

	String employeeCode;

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

}
