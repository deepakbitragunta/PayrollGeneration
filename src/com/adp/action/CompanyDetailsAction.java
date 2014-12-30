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
import com.adp.dto.CompanyDetailsForm;


public class CompanyDetailsAction extends Action{
	private static final long serialVersionUID = 1L;
	
	ConnectionDAO cobj = null;
	UserDAO uobj = null;
	boolean result;
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		HttpSession ses= request.getSession();
		String msg=null;
		CompanyDetailsForm detailsform = (CompanyDetailsForm)form;
		try
		{
			cobj = new ConnectionDAO();
			uobj = new UserDAO(cobj);
			result = uobj.updateDetails(detailsform.getCompany_code(),detailsform.getCompany_name(),detailsform.getCmp_start_date(),
					detailsform.getCmp_end_date(),detailsform.getCmp_add_ln1(),detailsform.getCmp_add_ln2(),detailsform.getCmp_add_ln3(),
					detailsform.getCmp_town(),detailsform.getCmp_state(),detailsform.getCmp_country(),detailsform.getCmp_postcode(),detailsform.getCmp_phone());
			
		
		if(result)
		{

			ses.setAttribute("msg", "Company Details was updated successfully");		
			msg="SS";
		}
		else
		{
			msg="FF";
			ses.setAttribute("msg", "Company details can't be updated");			
			
		}
		}
		catch(Exception e)
		{
			ses.setAttribute("ErrorSource", "UserDAO");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ErrorPage.jsp");
			dispatcher.forward(request, response);
		}
		return mapping.findForward(msg);
		
	}	

}
