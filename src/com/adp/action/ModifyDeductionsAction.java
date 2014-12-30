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
import com.adp.dto.ModifyDeductionsForm;

public class ModifyDeductionsAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			int res = 0;
			HttpSession ses = request.getSession();
			ModifyDeductionsForm modifyform = (ModifyDeductionsForm)form;
			try
			{
			ConnectionDAO cobj = new ConnectionDAO();
			DeductionsDefinitionDAO eobj = new DeductionsDefinitionDAO(cobj);
			res = eobj.modifyDeductionsOnDescription(modifyform.getCode(), modifyform.getDesc());
			if(res == 1)
			{
				ses.setAttribute("msg", "Deductions modified successfully");				
			}
			else{
				ses.setAttribute("msg", "Deductions cant be modified");
			}
			}
			catch(Exception e)
			{
				ses.setAttribute("ErrorSource", "DeductionsDefinitionDAO");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ErrorPage.jsp");
				dispatcher.forward(request, response);
			}
			
			return mapping.findForward(Integer.toString(res));
	}
	

}
