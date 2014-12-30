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
import com.adp.dto.ModifyEarningsForm;

public class ModifyEarningsAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			int res = 0;
			HttpSession ses = request.getSession();
			ModifyEarningsForm modifyform = (ModifyEarningsForm)form;
			try
			{
			ConnectionDAO cobj = new ConnectionDAO();
			EarningsDefinitionDAO eobj = new EarningsDefinitionDAO(cobj);
			//res = eobj.modifyEarningsOnDescription(modifyform.getCode(), modifyform.getDesc());
			String[] allDetails = eobj.getAllDetails(modifyform.getCode());
			System.out.println(allDetails[1]);
			ses.setAttribute("details", allDetails);
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
