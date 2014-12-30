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
import com.adp.dao.PositionDetailsDAO;
import com.adp.dto.JobDetailsForm;
import com.adp.dto.PositionDetailsForm;

public class PositionDetailsAction extends Action {

	public PositionDetailsAction() {

	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String msg=null;
		HttpSession ses = request.getSession();
		try {
			ConnectionDAO cobj = new  ConnectionDAO();
			PositionDetailsDAO uobj = new PositionDetailsDAO(cobj);
			
				PositionDetailsForm loginform = (PositionDetailsForm)form;
				
			if(uobj.addUser(loginform.getBu_name(),loginform.getJob_title(),loginform.getPosn_id(),loginform.getPosn_title(),
					loginform.getStartYear(),loginform.getStartMonth(),loginform.getStartDay(),loginform.getEndYear(),loginform.getEndMonth(),loginform.getEndDay(),loginform.getPosn_status_code()))
			{				
				ses.setAttribute("msg", "position added successfully");
				msg = "TT";
			}
			else
			{
				ses.setAttribute("msg", "position can't be added");
				msg = "FF";
				
			}
		} catch(Exception e)
		{
			e.printStackTrace();
			ses.setAttribute("ErrorSource", "PositionDetailsDAO");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ErrorPage.jsp");
			dispatcher.forward(request, response);
		}
		return mapping.findForward(msg);
	}

}
