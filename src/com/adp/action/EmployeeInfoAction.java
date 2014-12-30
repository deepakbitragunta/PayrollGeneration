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
import com.adp.dto.EmployeeInfoForm;

;

public class EmployeeInfoAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String msg=null;
		HttpSession ses = request.getSession();
		try {
			EmployeeInfoForm employeeForm = (EmployeeInfoForm) form;
			ConnectionDAO connectionObject = new ConnectionDAO();
			EmployeeInfoDAO employeenInfoObj = new EmployeeInfoDAO(connectionObject);
			boolean result = employeenInfoObj.addEmployee(employeeForm
					.getEmployeeCode(), employeeForm.getLastName(), employeeForm
					.getMiddleName(), employeeForm.getFirstName(), employeeForm
					.getTitle(), employeeForm.getBirthDay(),employeeForm.getBirthMonth(),employeeForm.getBirthYear(), employeeForm
					.getGender(), employeeForm.getMaritalStatus(), employeeForm
					.getNationality(), employeeForm.getAddressLine1(), employeeForm
					.getAddressLine2(), employeeForm.getTown(), employeeForm
					.getState(), employeeForm.getPostCode(), employeeForm
					.getPhoneNumber());
			if (result) {
				ses.setAttribute("msg", "employee added successfully");
				msg = "success";
			} else {
				ses.setAttribute("msg", "employee can't be added");
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
