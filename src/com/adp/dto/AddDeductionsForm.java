package com.adp.dto;

import org.apache.struts.action.ActionForm;

public class AddDeductionsForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String code;
	String desc;
	String start_date;
	String end_date;
	String er_code;
	public String getEr_code() {
		return er_code;
	}
	public void setEr_code(String er_code) {
		this.er_code = er_code;
	}
	String taxability;
	float dflt_amount;
	
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
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getTaxability() {
		return taxability;
	}
	public void setTaxability(String taxability) {
		this.taxability = taxability;
	}
	public float getDflt_amount() {
		return dflt_amount;
	}
	public void setDflt_amount(float dflt_amount) {
		this.dflt_amount = dflt_amount;
	}
	
	
}
