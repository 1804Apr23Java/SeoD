package dao;

import java.util.List;
import domain.Reimburse;


public interface ReimburseDAO {
	
	public boolean insertNewReimbursement(String username, double balance);
	
	public List<Reimburse> getReimbursementByUserAccount(String username);
	
	public List<Reimburse> getAllReimbursements();
	
	public List<Reimburse> getAllCertainReimbursement(int pendingState);
	
	public Reimburse getReimburseById(int reid);
	
	public int changePendingState(int reimburse_id, String managerUsername, int newState);

}
