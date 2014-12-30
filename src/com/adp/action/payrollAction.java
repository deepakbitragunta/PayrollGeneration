package com.adp.action;

import java.sql.Date;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.adp.dao.payrollDAO;
import com.adp.dao.ConnectionDAO;
import com.adp.dto.payrollForm;

public class payrollAction extends Action {
	ConnectionDAO cobj;
	payrollDAO pobj;
	ResultSet rs1;
	ResultSet rs2;
	ResultSet rs3;
	ResultSet rs4;
	String validEmp[];
	
	@Override
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String msg = "failure";
		int i = 0;
		float earn_amt;
		float ded_amt;
		float tax_amt;
		float tax;
		HttpSession ses = request.getSession();
		validEmp = new String[70];
		try {
			cobj = new ConnectionDAO();
			pobj= new payrollDAO(cobj);
			payrollForm payrollform = (payrollForm) form;
			payrollValidationAction payrollValid = new payrollValidationAction();
			System.out.println(payrollform.getPay_period_no() +""+ payrollform.getTax_year() +""+ payrollform.getPay_frequency());
			
			rs1 = pobj.getEmployment();
			
			rs2 = pobj.getPayCalendar(payrollform.getPay_period_no(),payrollform.getTax_year(),payrollform.getPay_frequency());
			rs3 = pobj.getEmpEarning();
			rs4 = pobj.getEmpDeduciton();
			Date pay_start;
			Date pay_end;
			
			rs2.next();
			pay_start = rs2.getDate(1);
			pay_end = rs2.getDate(2);
			
			while(rs1.next() && rs3.next() && rs4.next())
			{
				System.out.println(payrollValid.checkStatus(rs3.getString(1), rs4.getString(1),rs1.getString(4)) );
				System.out.println(payrollValid.checkDates(rs1.getDate(2), pay_start,rs1.getDate(3),pay_end));
				System.out.println(payrollValid.checkEarnDates(rs3.getDate(2),rs4.getDate(2),rs3.getDate(3),rs4.getDate(3),pay_start,pay_end));
			
				if(payrollValid.checkStatus(rs3.getString(1), rs4.getString(1),rs1.getString(4)) && 
						payrollValid.checkDates(rs1.getDate(2), pay_start,rs1.getDate(3),pay_end) &&
						payrollValid.checkEarnDates(rs3.getDate(2),rs4.getDate(2),rs3.getDate(3),rs4.getDate(3),pay_start,pay_end))
				{		
					System.out.println("1");
					pobj.copyEarnAmt(rs1.getString(1),payrollform.getPay_frequency(),payrollform.getTax_year(),payrollform.getPay_period_no());
					System.out.println();
					
					pobj.copyDedAmt(rs1.getString(1),payrollform.getPay_frequency(),payrollform.getTax_year(),payrollform.getPay_period_no());
					System.out.println("3");
					
					earn_amt = pobj.getEarnResultAmt(rs1.getString(1),payrollform.getPay_frequency(),payrollform.getTax_year(),payrollform.getPay_period_no());
					ded_amt = pobj.getDedResultAmt(rs1.getString(1),payrollform.getPay_frequency(),payrollform.getTax_year(),payrollform.getPay_period_no());
					tax_amt = earn_amt - ded_amt;
					tax = (float)(tax_amt * 0.10);
					System.out.println(validEmp[i]);
					pobj.insertTaxResults(rs1.getString(1),payrollform.getPay_frequency(),payrollform.getTax_year(),payrollform.getPay_period_no(),tax_amt,tax);
					
					validEmp[i] = rs1.getString(1) + " " + payrollform.getPay_frequency() + " " + payrollform.getTax_year()+ " " +
					payrollform.getPay_period_no() + " " +tax_amt +" " + tax;
					++i;
					// Session variables
					HttpSession session = request.getSession();
					session.setAttribute("validEmps",validEmp);
					session.setAttribute("period_no", payrollform.getPay_period_no());
					System.out.println(validEmp[i]);
					
					msg = "Success";
				}
				
				
			}
			
		}
		catch(Exception e)
		{
			ses.setAttribute("ErrorSource", "PayRollDAO");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ErrorPage.jsp");
			dispatcher.forward(request, response);
		}
	
	
	return mapping.findForward(msg);


}

}
