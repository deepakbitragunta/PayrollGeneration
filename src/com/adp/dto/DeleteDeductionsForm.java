package com.adp.dto;

import org.apache.struts.action.ActionForm;

public class DeleteDeductionsForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
