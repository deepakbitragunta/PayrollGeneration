package com.adp.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.adp.dao.ConnectionDAO;
import com.adp.dao.UserDAO;
import com.adp.dto.BusinessUnitDetailsForm;
import com.adp.dto.CompanyDetailsForm;

public class BusinessUnitDetailsAction extends Action{
	private static final long serialVersionUID = 1L;
	
	ConnectionDAO cobj = null;
	UserDAO uobj = null;
	boolean result;
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession ses =request.getSession();
		String msg = null;
		BusinessUnitDetailsForm unitdetailsform = (BusinessUnitDetailsForm)form;
		
		try
		{
			cobj = new ConnectionDAO();
			uobj = new UserDAO(cobj);
			
			result = uobj.insertDetails(unitdetailsform.getBu_code(),unitdetailsform.getBu_name(),unitdetailsform.getBu_effective_from(),
					unitdetailsform.getBu_effective_to(),unitdetailsform.getBu_type(),unitdetailsform.getBu_parent());
			
			
		if(result)
		{
			ses.setAttribute("msg", "Business Unit was added successfully");			
			msg="SS";
		}
		else
		{
			ses.setAttribute("msg", "Business Unit cant be added! Please enter proper details");			
			msg="FF";		
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ses.setAttribute("ErrorSource", "UserDAO");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ErrorPage.jsp");
			dispatcher.forward(request, response);
		}
		return mapping.findForward(msg);
		
	}	
		
		
		

}
