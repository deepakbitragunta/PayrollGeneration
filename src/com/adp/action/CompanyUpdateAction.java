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
import com.adp.dto.CompanyUpdateForm;

public class CompanyUpdateAction extends Action{
private static final long serialVersionUID = 1L;
	
	ConnectionDAO cobj = null;
	UserDAO uobj = null;
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession ses = request.getSession();
		int res = 0;
		CompanyUpdateForm getform = (CompanyUpdateForm)form;
		try
		{
		ConnectionDAO cobj = new ConnectionDAO();
		UserDAO uobj = new UserDAO(cobj);
		System.out.println(getform.getCompany_name());
		String[] allDetails = uobj.getAllDetails(getform.getCompany_name());
		System.out.println(allDetails[1]);
		ses.setAttribute("details", allDetails);
		}
		catch(Exception e)
		{
			ses.setAttribute("ErrorSource", "UserDAO");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ErrorPage.jsp");
			dispatcher.forward(request, response);
		}
		
		return mapping.findForward(Integer.toString(res));
}
		
	}
	
	


