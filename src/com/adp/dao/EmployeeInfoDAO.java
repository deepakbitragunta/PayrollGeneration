package com.adp.dao;

import java.sql.*;

import com.adp.dto.EmployeeInfoRetrieveForm;

/*import java.sql.Connection;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;
 */

public class EmployeeInfoDAO {
	ConnectionDAO connectionObject;
	Connection connection;
	Statement statement;
	ResultSet resultSet;

	public EmployeeInfoDAO(ConnectionDAO connectionObject) throws Exception {
		this.connectionObject = connectionObject;
			connection = connectionObject.getConnection();
			System.out.print(connection + "at constructor");

	}

	public boolean addEmployee(String employeeCode, String lastName,
			String middleName, String firstName, String title, String birthDay,
			String birthMonth, String birthYear, String gender,
			String maritalStatus, String nationality, String addressLine1,
			String addressLine2, String town, String state, int postCode,
			String phoneNumber) {
		int rowsAffected = 0;
		try {
			System.out.print(statement + " before");
			System.out.print(connection + " before");
			statement = connection.createStatement();
			System.out.print(statement + " after");
			String queryString = "INSERT INTO employee_info VALUES('"
					+ employeeCode + "','" + lastName + "','" + middleName
					+ "','" + firstName + "','" + title + "','" + birthYear
					+ "/" + birthMonth + "/" + birthDay + "','" + gender
					+ "','" + maritalStatus + "','" + nationality + "','"
					+ addressLine1 + "','" + addressLine2 + "','" + town
					+ "','" + state + "'," + postCode + ",'" + phoneNumber
					+ "')";
			System.out.println(queryString);
			rowsAffected = statement.executeUpdate(queryString);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		if (rowsAffected > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteEmployeeDetails(String employeeCode) {
		boolean isPaid;
		String queryString;
		int rowsAffected = 0;
		isPaid = isEmployeePaid(employeeCode);
		try {
			if (!isPaid) {
				statement = connection.createStatement();
				
				queryString = "DELETE FROM employee_info WHERE employee_code = '"
						+ employeeCode + "'";
				System.out.println(queryString);
				rowsAffected = statement.executeUpdate(queryString);
				queryString = "DELETE FROM employment WHERE employee_code = '"
						+ employeeCode + "'";
				System.out.println(queryString);
				rowsAffected = statement.executeUpdate(queryString);
				queryString = "DELETE FROM ee_earning WHERE employee_code = '"
						+ employeeCode + "'";
				System.out.println(queryString);
				rowsAffected = statement.executeUpdate(queryString);
				queryString = "DELETE FROM ee_deduction WHERE employee_code = '"
						+ employeeCode + "'";
				System.out.println(queryString);
				rowsAffected = statement.executeUpdate(queryString);
				queryString = "DELETE FROM ee_earn_result WHERE employee_code = '"
						+ employeeCode + "'";
				System.out.println(queryString);
				rowsAffected = statement.executeUpdate(queryString);
				queryString = "DELETE FROM ee_ded_result WHERE employee_code = '"
						+ employeeCode + "'";
				System.out.println(queryString);
				rowsAffected = statement.executeUpdate(queryString);
				queryString = "DELETE FROM ee_tax_result WHERE employee_code = '"
						+ employeeCode + "'";
				System.out.println(queryString);
				rowsAffected = statement.executeUpdate(queryString);
				deleteEmployeeEmploymentDetails(employeeCode);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
			return true;
		
	}

	public void deleteEmployeeEmploymentDetails(String employeeCode) {

	}

	public boolean isEmployeePaid(String employeeCode) {
		return false;
	}

	public boolean modifyEmployeeDetails(String employeeCode, String lastName,
			String middleName, String firstName, String title, String birthDay,
			String birthMonth, String birthYear, String gender,
			String maritalStatus, String nationality, String addressLine1,
			String addressLine2, String town, String state, int postCode,
			String phoneNumber) {
		String queryString;
		int rowsAffected = 0;
		try {
			statement = connection.createStatement();
			// ResultSet rs = getDetails(employeeCode);
			queryString = "UPDATE employee_info SET last_name = '" + lastName
					+ "', middle_name = '" + middleName + "', first_name = '"
					+ firstName + "', title = '" + title + "', birth_date = '"
					+ birthYear + "/" + birthMonth + "/" + birthDay
					+ "', gender = '" + gender + "', marital_status = '"
					+ maritalStatus + "', nationality = '" + nationality
					+ "', add_ln1 = '" + addressLine1 + "', add_ln2 = '"
					+ addressLine2 + "', town = '" + town + "', state = '"
					+ state + "', postcode = " + postCode + ", phone = '"
					+ phoneNumber + "' WHERE employee_code = '" + employeeCode
					+ "'";
			System.out.println(queryString);
			rowsAffected = statement.executeUpdate(queryString);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		if (rowsAffected > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public EmployeeInfoRetrieveForm getEmployeeDetails(String employeeCode) {
		boolean result = false;
		EmployeeInfoRetrieveForm employeeInfoRetrieveForm = new EmployeeInfoRetrieveForm();
		try {
			statement = connection.createStatement();
			String queryString;
			queryString = "select * from employee_info where employee_code = '"
					+ employeeCode + "'";
			resultSet = statement.executeQuery(queryString);
			while (resultSet.next()) {
				employeeInfoRetrieveForm = new EmployeeInfoRetrieveForm();
				employeeInfoRetrieveForm
						.setEmployeeCode(resultSet.getString(1));
				employeeInfoRetrieveForm.setLastName(resultSet.getString(2));
				employeeInfoRetrieveForm.setMiddleName(resultSet.getString(3));
				employeeInfoRetrieveForm.setFirstName(resultSet.getString(4));
				employeeInfoRetrieveForm.setTitle(resultSet.getString(5));
				employeeInfoRetrieveForm.setBirthDay(resultSet.getString(6)
						.split("-")[2]);
				employeeInfoRetrieveForm.setBirthMonth(resultSet.getString(6)
						.split("-")[1]);
				employeeInfoRetrieveForm.setBirthYear(resultSet.getString(6)
						.split("-")[0]);
				employeeInfoRetrieveForm.setGender(resultSet.getString(7));
				employeeInfoRetrieveForm.setMaritalStatus(resultSet
						.getString(8));
				employeeInfoRetrieveForm.setNationality(resultSet.getString(9));
				employeeInfoRetrieveForm.setAddressLine1(resultSet
						.getString(10));
				employeeInfoRetrieveForm.setAddressLine2(resultSet
						.getString(11));
				employeeInfoRetrieveForm.setTown(resultSet.getString(12));
				employeeInfoRetrieveForm.setState(resultSet.getString(13));
				employeeInfoRetrieveForm.setPostCode(resultSet.getInt(14));
				employeeInfoRetrieveForm
						.setPhoneNumber(resultSet.getString(15));
				result = true;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return employeeInfoRetrieveForm;
	}


	/*public static void main(String args[]) throws SQLException {
		ConnectionDAO connectionObject = new ConnectionDAO();
		EmployeeInfoDAO employeenInfoObj = new EmployeeInfoDAO(connectionObject);
		System.out.println(connectionObject + " " + employeenInfoObj);
		System.out.println(employeenInfoObj.addEmployee("12ab12",
				"chidambaram", "palanisamy", "harikarthik", "memberTechnical",
				"1987-08-17", "male", "single", "Indian", "1", "2", "Tiruppur",
				"TN", 641601, "9843220999"));
	}*/
}