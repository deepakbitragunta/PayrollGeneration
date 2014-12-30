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
import com.adp.dao.EmpEarnDedDAO;
import com.adp.dto.EarnDedForm;


public class EmpEarnDedAction extends Action{
	
	ConnectionDAO cobj;
	EmpEarnDedDAO eobj;
	
	@Override
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String msg = null;
		boolean result1,result2;
		HttpSession ses = request.getSession();
		try {
			cobj = new ConnectionDAO();
			eobj= new EmpEarnDedDAO(cobj);
			EarnDedForm  earndedform = (EarnDedForm) form;
			
			
			result1 = eobj.insertEmpEarnings(earndedform.getEmp_code(),earndedform.getEarn_code(),earndedform.getEarn_start_date(),earndedform.getEe_earn_end_date(),earndedform.getEe_earn_status_code(),earndedform.getEe_earn_dflt_amt());
			result2 = eobj.insertEmpDeductions(earndedform.getEmp_code(),earndedform.getDed_code(),earndedform.getDed_start_date(),earndedform.getEe_ded_end_date(),earndedform.getEe_ded_status_code(),earndedform.getEe_ded_dflt_amt());
			
			if(result1 && result2)
			{
				ses.setAttribute("msg", "earnings & deductions added successfully");
				msg = "success";
				
			}
			else
			{
				ses.setAttribute("msg", "can't be added");
				msg = "failure";
			}
		}
			catch(Exception e)
			{
				ses.setAttribute("ErrorSource", "EmpEarnDedDAO");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ErrorPage.jsp");
				dispatcher.forward(request, response);
			}
		
		
		return mapping.findForward(msg);
	
	
		}

}
