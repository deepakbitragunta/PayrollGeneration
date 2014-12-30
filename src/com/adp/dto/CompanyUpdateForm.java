package com.adp.dto;

import org.apache.struts.action.ActionForm;

public class CompanyUpdateForm extends ActionForm {
	String company_name;

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String companyName) {
		company_name = companyName;
	}
	

}
