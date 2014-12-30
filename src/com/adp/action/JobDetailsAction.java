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
import com.adp.dao.JobDetailsDAO;
import com.adp.dto.JobDetailsForm;


public class JobDetailsAction extends Action{

	public JobDetailsAction()
	{
		
	}
	

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession ses = request.getSession();
		String msg=null; 
		try {
			ConnectionDAO cobj = new  ConnectionDAO();
			JobDetailsDAO uobj = new JobDetailsDAO(cobj);
			
				JobDetailsForm loginform = (JobDetailsForm)form;
				
			if(uobj.addUser(loginform.getJobcode(),loginform.getJobtitle(),loginform.getDescription()))
			{
				ses.setAttribute("msg", "job added successfully");
				msg = "TT";
			}
			else
			{
				ses.setAttribute("msg", "job can't be added");
				msg = "FF";
				
			}
		}catch(Exception e)
		{
			ses.setAttribute("ErrorSource", "JobDetailsDAO");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ErrorPage.jsp");
			dispatcher.forward(request, response);
		}
		return mapping.findForward(msg);
	}
	
	
	

}

