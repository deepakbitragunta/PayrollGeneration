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
import com.adp.dao.EmployeeInfoDAO;
import com.adp.dto.EmployeeInfoDeleteForm;

public class EmployeeInfoDeleteAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String msg=null;
		HttpSession ses = request.getSession();
		try {
			EmployeeInfoDeleteForm employeeInfoDeleteForm = (EmployeeInfoDeleteForm) form;
			ConnectionDAO connectionObject = new ConnectionDAO();
			EmployeeInfoDAO employeenInfoObj = new EmployeeInfoDAO(connectionObject);
			boolean result = employeenInfoObj
					.deleteEmployeeDetails(employeeInfoDeleteForm.getEmployeeCode());
			if (result) {
				ses.setAttribute("msg", "employee deleted successfully");
				msg = "success";
			} else {
				ses.setAttribute("msg", "employee updated successfully");
				msg = "failure";
			}
		} catch(Exception e)
		{
			ses.setAttribute("ErrorSource", "EmployeeInfoDAO");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ErrorPage.jsp");
			dispatcher.forward(request, response);
		}
		return mapping.findForward(msg);

	}
}
