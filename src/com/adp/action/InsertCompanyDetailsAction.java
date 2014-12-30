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
import com.adp.dto.InsertCompanyDetailsForm;

public class InsertCompanyDetailsAction extends Action{
	
private static final long serialVersionUID = 1L;
	
	ConnectionDAO cobj = null;
	UserDAO uobj = null;
	boolean result;
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String msg=null;
		HttpSession ses = request.getSession();
		try
		{
		cobj = new ConnectionDAO();
		uobj = new UserDAO(cobj);
		InsertCompanyDetailsForm insertdetailsform = (InsertCompanyDetailsForm)form;
			result = uobj.insertCompany(insertdetailsform.getCompany_code(),insertdetailsform.getCompany_name(),insertdetailsform.getCmp_start_date(),
					insertdetailsform.getCmp_end_date(),insertdetailsform.getCmp_add_ln1(),insertdetailsform.getCmp_add_ln2(),insertdetailsform.getCmp_add_ln3(),
					insertdetailsform.getCmp_town(),insertdetailsform.getCmp_state(),insertdetailsform.getCmp_country(),insertdetailsform.getCmp_postcode(),insertdetailsform.getCmp_phone());
			
			
		if(result)
		{
			ses.setAttribute("msg", "Company added Successfully");
			msg="SS";
		}
		else
		{
			ses.setAttribute("msg", "Company can't be added");
			msg="FF";
			
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
