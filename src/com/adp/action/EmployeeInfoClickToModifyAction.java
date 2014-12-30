package com.adp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.adp.dao.ConnectionDAO;
import com.adp.dao.EmployeeInfoDAO;
import com.adp.dto.EmployeeInfoClickToModifyForm;
import com.adp.dto.EmployeeInfoRetrieveForm;

public class EmployeeInfoClickToModifyAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String msg;
		boolean result = true;
		EmployeeInfoClickToModifyForm employeeInfoClickToModifyForm = (EmployeeInfoClickToModifyForm)form;
		ConnectionDAO connectionObject = new ConnectionDAO();
		EmployeeInfoDAO employeenInfoObj = new EmployeeInfoDAO(connectionObject);
		EmployeeInfoRetrieveForm resultobj = employeenInfoObj.getEmployeeDetails(employeeInfoClickToModifyForm.getEmployeeCode());
		HttpSession ses = request.getSession(true);
		ses.setAttribute("empinfo", resultobj);
		System.out.println(resultobj.getAddressLine1()+resultobj.getNationality()+resultobj.getBirthDay()+resultobj.getBirthMonth()+resultobj.getBirthYear());
		if (result) {
			
			msg = "success";
		} else {
			ses.setAttribute("msg", "no employee record exist");
			msg = "failure";
		}
		return mapping.findForward(msg);
	}

}
