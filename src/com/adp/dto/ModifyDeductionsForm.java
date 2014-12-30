package com.adp.dto;

import org.apache.struts.action.ActionForm;

public class ModifyDeductionsForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String code;
	String desc;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
