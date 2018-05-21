package dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import domain.Reimburse;

public class TestReimburseDAO {

	/*
	 public boolean insertNewReimbursement(int user_id, float balance, String image_ref);
	
	public List<Reimburse> getReimursementByUserAccount(String username);
	
	public List<Reimburse> getAllReimbursements();
	
	public List<Reimburse> getAllCertainReimursement(int pendingState);
	
	public int changePendingState(int reimburse_id, String managerUsername, int newState); 
	 
	 */
	
	public static final ReimburseDAO reimburseTest = new ReimburseIMPL();
	
	@Test
	public void testInsertNewReimbursement() {
		assertTrue(reimburseTest.insertNewReimbursement("tony", 105.00, "image.ref"));
	}
	
	public void testGetReimursementByUserAccount() {
		assertNotNull(reimburseTest.getReimursementByUserAccount("tony"));
	}

	public void testGetAllReimbursements() {
		assertNotNull(reimburseTest.getAllReimbursements());
	}

	public void testGetAllCertainReimursement() {
		assertNotNull(reimburseTest.getAllCertainReimursement(2));
	}

	public void testChangePendingState() {
		assertNotNull(reimburseTest.changePendingState(21, "admin", 2));
	}


}
