package com.adp.dto;

import org.apache.struts.action.ActionForm;

public class PayCalendarForm extends ActionForm
{
	private static final long serialVersionUID = 1L;
	
	private int taxYear;
	private String payFrequency;
	
	public String getPayFrequency() {
		return payFrequency;
	}

	public void setPayFrequency(String payFrequency) {
		this.payFrequency = payFrequency;
	}

	public int getTaxYear() {
		return taxYear;
	}

	public void setTaxYear(int taxYear) {
		this.taxYear = taxYear;
	}

	}
