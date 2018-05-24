package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;


import dao.ReimburseDAO;
import dao.ReimburseIMPL;
import dao.ReimburseImageDAO;
import dao.ReimburseImageIMPL;
import dao.UserDAO;
import dao.UserIMPL;
import domain.Image;
import domain.Reimburse;
import domain.User;

public class ManualTest {

	public static void main (String[] args) throws FileNotFoundException {
		
		UserDAO ud = new UserIMPL();
		ReimburseDAO rd = new ReimburseIMPL();
		
		
		/* Users
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
		
		
		/*  Reimburses
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
		
		
		//rd.insertNewReimbursement("young", 1111, "test");
		rd.insertNewReimbursement("young", 2222, "test");
		rd.insertNewReimbursement("young", 3333, "test");
		
		Reimburse c = rd.getReimburseById(1);
		System.out.println(c);
		*/
		
		
		//File file = new File("jss.PNG");
		ReimburseImageDAO rid = new ReimburseImageIMPL();
		//rid.insertNewImage(1, file);
		Image rs = rid.getOneImage(23);
		if (!(rs.getImageFile() == null))
		{
			System.out.println("in");
		}
		else
			System.out.println("no");
		
		
		System.out.println("done");
		
	}
}
