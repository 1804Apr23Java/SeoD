package domain;

public class Reimburse {

	private int reId;
	private int userId;
	private float expenses;
	private int pendingState;
	private String managerView;
	
	public Reimburse(int userId, float expenses, int pendingState, String managerView) {
		this.userId = userId;
		this.expenses = expenses;
		this.pendingState = pendingState;
		this.managerView = managerView;
	}
	
	public Reimburse(int reId, int userId, Float expenses, int pending, String managerView) {
		this.reId = reId;
		this.userId = userId;
		this.expenses = expenses;
		this.pendingState = pending;
		this.managerView = managerView;
	}
	
	public Reimburse() {
		super();
	}

	public int getReId() {
		return reId;
	}

	public void setReId(int reId) {
		this.reId = reId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public float getExpenses() {
		return expenses;
	}

	public void setExpenses(float expenses) {
		this.expenses = expenses;
	}

	public int getPendingState() {
		return pendingState;
	}

	public void setPendingState(int pendingState) {
		this.pendingState = pendingState;
	}

	public String getManagerView() {
		return managerView;
	}

	public void setManagerView(String managerView) {
		this.managerView = managerView;
	}

	@Override
	public String toString() {
		return "Reimburse [reId=" + reId + ", userId=" + userId + ", expenses=" + expenses + ", pendingState="
				+ pendingState + ", managerView=" + managerView + "]";
	}
	
	
}
