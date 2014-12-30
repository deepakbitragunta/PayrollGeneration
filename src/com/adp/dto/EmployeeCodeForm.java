package com.adp.dto;

import org.apache.struts.action.ActionForm;

public class EmployeeCodeForm extends ActionForm{

	String code;

	public String getCode() {
		System.out.println(code);
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
