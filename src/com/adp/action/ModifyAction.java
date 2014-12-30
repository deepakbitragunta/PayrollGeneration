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
import com.adp.dto.ModifyEarningsForm;

public class ModifyAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			int res = 0;
			HttpSession ses = request.getSession();
			AddEarningsForm modifyform = (AddEarningsForm)form;
			try
			{
			ConnectionDAO cobj = new ConnectionDAO();
			EarningsDefinitionDAO eobj = new EarningsDefinitionDAO(cobj);
			res = eobj.modifyEarnings(modifyform.getCode(), modifyform.getDesc(),modifyform.getStart_date(),modifyform.getEnd_date(),modifyform.getTaxability(),modifyform.getDflt_amount());
			System.out.println(modifyform.getCode());
			}
			catch(Exception e)
			{
				ses.setAttribute("ErrorSource", "EarningsDefinitionDAO");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ErrorPage.jsp");
				dispatcher.forward(request, response);
			}
			
			return mapping.findForward(Integer.toString(res));
	}
	

}
