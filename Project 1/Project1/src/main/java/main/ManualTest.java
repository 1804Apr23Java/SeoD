package main;

import java.util.List;


import dao.ReimburseDAO;
import dao.ReimburseIMPL;
import dao.UserDAO;
import dao.UserIMPL;
import domain.Reimburse;
import domain.User;

public class ManualTest {

	public static void main (String[] args) {
		
		UserDAO ud = new UserIMPL();
		ReimburseDAO rd = new ReimburseIMPL();
		
		
		/*
	 	//---------
		List<User> culist = ud.getAllUsers();

		for (User c : culist) {
			System.out.println(c);
		}
		
		//---------
		User user1 = ud.getUserInfo("notadmin");
		System.out.println(user1.toString());
		
		//---------
		int a = ud.checkLoginInfo("notadmin", "admin123");
		System.out.println(a);
		
		//---------
		boolean f = ud.changePassword("young", "sports");
		System.out.println(f);
		
		
		boolean x = ud.updateUserInfo("young", "Young", "Kim", "young.kim@gmail.com");
		System.out.println(x);
		*/
		
		
		/*
		//---------
		List<Reimburse> ls = rd.getReimursementByUserAccount("admin");
		for (Reimburse d: ls) {
			System.out.println(d);
		}
		
		//---------
		List<Reimburse> ls = rd.getAllReimbursements();
		for (Reimburse d: ls) {
			System.out.println(d);
		}
		*/
		
		System.out.println("done");
	}
}
