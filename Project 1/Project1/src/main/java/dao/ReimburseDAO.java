package dao;

import java.util.List;
import domain.Reimburse;


public interface ReimburseDAO {
	
	public boolean insertNewReimbursement(String username, double balance, String image_ref);
	
	public List<Reimburse> getReimursementByUserAccount(String username);
	
	public List<Reimburse> getAllReimbursements();
	
	public List<Reimburse> getAllCertainReimursement(int pendingState);
	
	public int changePendingState(int reimburse_id, String managerUsername, int newState);

}
