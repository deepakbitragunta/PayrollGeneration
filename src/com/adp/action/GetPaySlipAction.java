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
import com.adp.dao.PaySlipDAO;
import com.adp.dto.DeleteEarningsForm;
import com.adp.dto.EmployeeCodeForm;

public class GetPaySlipAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String[][] res = new String[10][10];
		HttpSession ses = request.getSession();
		EmployeeCodeForm codeform = (EmployeeCodeForm)form; 
		try
		{
		ConnectionDAO cobj = new ConnectionDAO();
		PaySlipDAO obj = new PaySlipDAO(cobj);
		int periodno = (Integer)ses.getAttribute("period_no");
		int taxYear= (Integer)ses.getAttribute("taxYear" );	
		res = obj.getDetails(codeform.getCode(),periodno,taxYear);
		ses.setAttribute("val", res);
		}
		catch(Exception e)
		{
			ses.setAttribute("ErrorSource", "PaySlipDAO");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ErrorPage.jsp");
			dispatcher.forward(request, response);
		}
		
		return mapping.findForward("1");
	}

	
}
