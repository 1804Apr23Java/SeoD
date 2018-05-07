package codingchallenge.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.util.ConnectionUtil;

import codingchallenge.domain.Department;

public class DepartmentDaoImpl implements DepartmentDao {
	private String filename = "codingchallenge2.properties";

	public List<Department> getDepartments() {
		List<Department> departmentList = new ArrayList<>();

		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// use a prepared statement
			String sql = "SELECT DEPARTMENT_NAME, AVG(SALARY) FROM DEPARTMENT, EMPLOYEE";
			pstmt = con.prepareStatement(sql);
			ResultSet resultSet = pstmt.executeQuery();

			// do something with result
			if (resultSet.next()) {
				String departmentName = resultSet.getString("DEPARTMENT_NAME");
				int avgSalary = resultSet.getInt("AVG(SALARY)");
				System.out.println("Deparment Name:" + departmentName + "Average Salary" + avgSalary);
			}

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return departmentList;

	}

}
