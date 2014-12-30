package com.adp.dto;

import java.sql.Date;

import org.apache.struts.action.ActionForm;

public class BusinessUnitDetailsForm extends ActionForm {
	String bu_code;
	String bu_name;
	Date bu_effective_from;
	Date bu_effective_to;
	String bu_type;
	String bu_parent;
	public String getBu_code() {
		return bu_code;
	}
	public void setBu_code(String buCode) {
		bu_code = buCode;
	}
	public String getBu_name() {
		return bu_name;
	}
	public void setBu_name(String buName) {
		bu_name = buName;
	}
	public Date getBu_effective_from() {
		return bu_effective_from;
	}
	public void setBu_effective_from(Date buEffectiveFrom) {
		bu_effective_from = buEffectiveFrom;
	}
	public Date getBu_effective_to() {
		return bu_effective_to;
	}
	public void setBu_effective_to(Date buEffectiveTo) {
		bu_effective_to = buEffectiveTo;
	}
	public String getBu_type() {
		return bu_type;
	}
	public void setBu_type(String buType) {
		bu_type = buType;
	}
	public String getBu_parent() {
		return bu_parent;
	}
	public void setBu_parent(String buParent) {
		bu_parent = buParent;
	}
	
	

}
