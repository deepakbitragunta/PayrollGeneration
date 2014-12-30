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
import com.adp.dao.EarningsDefinitionDAO;
import com.adp.dto.AddEarningsForm;

public class AddEarningsAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			int res = 0;
			String msg = null;
			HttpSession ses = request.getSession();
			AddEarningsForm addform = (AddEarningsForm)form;
			try
			{
			ConnectionDAO cobj = new ConnectionDAO();
			EarningsDefinitionDAO eobj = new EarningsDefinitionDAO(cobj);
			res = eobj.addEarnings(addform.getCode(), addform.getDesc(), addform.getStart_date(), addform.getEnd_date(), addform.getTaxability(), addform.getDflt_amount());
			if(res == 1)
			{
				msg = "1";
				ses.setAttribute("msg", "Earnings was added successfully");
			}
			else
			{
				msg = "0";
				ses.setAttribute("msg", "Earnings can't be added! Please enter a proper data");				
			}
			}
			catch(Exception e)
			{
				ses.setAttribute("ErrorSource", "EarningsDefinitionDAO");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ErrorPage.jsp");
				dispatcher.forward(request, response);
			}
			return mapping.findForward(msg);
	}

	
}
