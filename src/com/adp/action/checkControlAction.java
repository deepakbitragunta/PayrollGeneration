package com.adp.action;

import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.adp.dao.ConnectionDAO;
import com.adp.dao.UserDAO;

public class checkControlAction extends Action{

	ConnectionDAO cobj = null;
	UserDAO uobj = null;
	boolean result;
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession ses = request.getSession();
		String msg = "ff";
		ResultSet rs;
		
		try {
			cobj = new ConnectionDAO();
			uobj = new UserDAO(cobj);
			rs = uobj.getCompnayName();
			if(rs.getInt(2) == 1)
			{
				ses.setAttribute("cname", rs.getString(1));
				msg = "update";
				
			}
			else if(rs.getInt(2) == 0)
			{
				msg = "insert";
			}
			else
			{
				msg = "ff";
			}
		} 
		catch(Exception e)
		{
			ses.setAttribute("ErrorSource", "UserDAO");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ErrorPage.jsp");
			dispatcher.forward(request, response);
		}
		
		return mapping.findForward(msg);
	}

}
