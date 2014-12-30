package com.adp.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.adp.dao.*;
import com.adp.dto.EmploymentForm;

public class EmploymentAction extends Action{

	ConnectionDAO cobj;
	EmploymentDAO eobj;
	
	@Override
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String msg = null;
		boolean result;
		HttpSession ses = request.getSession();
		try {
			cobj = new ConnectionDAO();
			eobj= new EmploymentDAO(cobj);
			EmploymentForm empform = (EmploymentForm) form;
			
			
			result = eobj.insertEmploymentDetails(empform.getEmp_code(),empform.getHire_date(),empform.getEmp_term_date(),empform.getEe_status(),empform.getFull_part_time(),empform.getPermanent_temp(),empform.getLeaving_reason(),empform.getNotice_period(),empform.getNotice_period_unit(),empform.getProb_period(),empform.getProb_period_unit(),empform.getPay_frequency());
			if(result)
			{
				ses.setAttribute("msg", "Employment added successfully");
				msg = "success";
				
			}
			else
			{
				ses.setAttribute("msg", "Employment info can't be added");
				msg = "failure";
			}
		} catch(Exception e)
		{
			ses.setAttribute("ErrorSource", "EmploymentDAO");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ErrorPage.jsp");
			dispatcher.forward(request, response);
		}
		
		
		return mapping.findForward(msg);
	
	
		}
}
