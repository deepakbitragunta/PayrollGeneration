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
import com.adp.dao.LoginDAO;
import com.adp.dto.LoginForm;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String result=null;
		HttpSession ses = request.getSession();
		try {
			LoginForm loginForm = (LoginForm) form;
			ConnectionDAO connectionObject = new ConnectionDAO();
			LoginDAO loginDAO = new LoginDAO(connectionObject);
			result = loginDAO.validateUser(loginForm.getUserName(),
					loginForm.getPassword());
			if(result.equals("admin") )
			{
				ses.setAttribute("uid", loginForm.getUserName());
			}
			if(result.equals("user"))
			{
				ses.setAttribute("uid", loginForm.getUserName());
				ses.setAttribute("payFrequency", "monthly");
				ses.setAttribute("taxYear", 2011);
				ses.setAttribute("period_no", 7);
			}
			
		} catch(Exception e)
		{
			ses.setAttribute("ErrorSource", "loginDAO");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ErrorPage.jsp");
			dispatcher.forward(request, response);
		}
		return mapping.findForward(result);

	}

}
