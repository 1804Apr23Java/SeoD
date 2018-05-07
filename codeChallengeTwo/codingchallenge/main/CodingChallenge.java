package codingchallenge.main;

import codingchallenge.dao.DepartmentDao;
import codingchallenge.dao.DepartmentDaoImpl;
import codingchallenge.dao.EmployeeDao;
import codingchallenge.dao.EmployeeDaoImpl;

public class CodingChallenge {

	public static void main(String[] args) {
		EmployeeDao employee = new EmployeeDaoImpl();
		DepartmentDao department = new DepartmentDaoImpl();

		
		department.getDepartments();
		employee.raiseSalary(1, 1.1);
		department.getDepartments();
	}

}
