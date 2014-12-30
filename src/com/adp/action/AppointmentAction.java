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
import com.adp.dto.AppointmentForm;

public class AppointmentAction extends Action{

	ConnectionDAO cobj;
	AppointmentDAO aobj;
	
	@Override
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String msg = null;
		boolean result;
		HttpSession ses = request.getSession();
		try {
			cobj = new ConnectionDAO();
			aobj= new AppointmentDAO(cobj);
			AppointmentForm appform = (AppointmentForm) form;
			result = aobj.insertAppointmentDetails(appform.getEmp_code(),appform.getAppt_no(),appform.getAppt_start_date(),appform.getAppt_end_date(),appform.getBu_code(),appform.getJob_code(),appform.getPosn_id(),appform.getReports_to());
			 
			if(result)
			{

				ses.setAttribute("msg", "Appointment was added successfully");
				msg = "success";
				
			}
			else
			{

				ses.setAttribute("msg", "Appointment can't be added! Please enter valid data");
				msg = "failure";
			}
		} 
		catch(Exception e)
		{
			ses.setAttribute("ErrorSource", "AppointmentDAO");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ErrorPage.jsp");
			dispatcher.forward(request, response);
		}
		
		return mapping.findForward(msg);
	
	
		}
}
		
		

			