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
import com.adp.dto.EmployeeInfoRetrieveForm;

public class EmployeeInfoRetrievalAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String msg = null;
		HttpSession ses = request.getSession();
		EmployeeInfoRetrieveForm employeeInfoRetrieveForm = (EmployeeInfoRetrieveForm)form;
		try {
			ConnectionDAO connectionObject = new ConnectionDAO();
			EmployeeInfoDAO employeenInfoObj = new EmployeeInfoDAO(connectionObject);
			boolean result = employeenInfoObj.modifyEmployeeDetails(employeeInfoRetrieveForm.getEmployeeCode(), employeeInfoRetrieveForm.getLastName(), employeeInfoRetrieveForm.getMiddleName(), employeeInfoRetrieveForm.getFirstName(), employeeInfoRetrieveForm.getTitle(), employeeInfoRetrieveForm.getBirthDay(), employeeInfoRetrieveForm.getBirthMonth(), employeeInfoRetrieveForm.getBirthYear(), employeeInfoRetrieveForm.getGender(), employeeInfoRetrieveForm.getMaritalStatus(), employeeInfoRetrieveForm.getNationality(), employeeInfoRetrieveForm.getAddressLine1(), employeeInfoRetrieveForm.getAddressLine2(), employeeInfoRetrieveForm.getTown(), employeeInfoRetrieveForm.getState(), employeeInfoRetrieveForm.getPostCode(), employeeInfoRetrieveForm.getPhoneNumber());
			if (result) {
				
				msg = "success";
			} else {
				ses.setAttribute("msg", "No employee exists");
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
