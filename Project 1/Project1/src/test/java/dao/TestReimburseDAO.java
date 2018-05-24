package dao;

import static org.junit.Assert.*;


import org.junit.Test;


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
		assertTrue(reimburseTest.insertNewReimbursement("tony", 105.00));
	}
	
	public void testGetReimursementByUserAccount() {
		assertNotNull(reimburseTest.getReimbursementByUserAccount("tony"));
	}

	public void testGetAllReimbursements() {
		assertNotNull(reimburseTest.getAllReimbursements());
	}

	public void testGetAllCertainReimursement() {
		assertNotNull(reimburseTest.getAllCertainReimbursement(2));
	}

	public void testChangePendingState() {
		assertNotNull(reimburseTest.changePendingState(21, "admin", 2));
	}


}
