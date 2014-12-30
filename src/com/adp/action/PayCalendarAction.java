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
import com.adp.dao.PayCalendarDAO;
import com.adp.dto.PayCalendarForm;

public class PayCalendarAction extends Action
{
	ConnectionDAO cobj = null;
	PayCalendarDAO pobj = null;
	String[][] calendarRecords = new String[12][5];
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		HttpSession ses = request.getSession();
		try {
			cobj = new ConnectionDAO();
			pobj = new PayCalendarDAO(cobj);
			PayCalendarForm payCalendarForm = (PayCalendarForm) form;
			String payFrequency =payCalendarForm.getPayFrequency();
			int taxYear = payCalendarForm.getTaxYear();
				
			pobj.insertCalendar(taxYear,payFrequency);
			calendarRecords = pobj.getCalendarRecords(taxYear,payFrequency);
			ses.setAttribute("payFrequency", payFrequency);
			ses.setAttribute("taxYear", taxYear);
			ses.setAttribute("calendarRecords", calendarRecords);
		} catch(Exception e)
		{
			ses.setAttribute("ErrorSource", "PayCalendarDAO");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ErrorPage.jsp");
			dispatcher.forward(request, response);
		}
		return mapping.findForward("CALENDARGENERATION");
	}
	
	
	
	
}
