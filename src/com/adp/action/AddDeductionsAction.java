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
import com.adp.dao.DeductionsDefinitionDAO;
import com.adp.dto.AddDeductionsForm;

public class AddDeductionsAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			int res = 0;
			String msg = null;
			HttpSession ses = request.getSession();
			AddDeductionsForm addform = (AddDeductionsForm)form;
			try
			{
			ConnectionDAO cobj = new ConnectionDAO();
			DeductionsDefinitionDAO eobj = new DeductionsDefinitionDAO(cobj);
			res = eobj.addDeductions(addform.getCode(), addform.getDesc(), addform.getStart_date(), addform.getEnd_date(),addform.getEr_code(), addform.getTaxability(), addform.getDflt_amount());
			if(res == 1)
			{
				ses.setAttribute("msg", "Deductions was added successfully");
			}
			else
			{
				ses.setAttribute("msg", "Deductions can't be added! Insert proper data");
			}
			}
			catch(Exception e)
			{
				ses.setAttribute("ErrorSource", e.getMessage() +" occurred in DeductionsDefinitionDAO");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ErrorPage.jsp");
				dispatcher.forward(request, response);
			}
			
			return mapping.findForward(Integer.toString(res));
	}

	
}
