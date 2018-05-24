package dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Reimburse;
import domain.User;
import util.ConnectionUtil;

public class ReimburseIMPL implements ReimburseDAO {

	public boolean insertNewReimbursement(String username, double expenses) {
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			UserDAO ud = new UserIMPL();
			User getId = ud.getUserInfo(username);
			int user_id = getId.getUser_id();

			String sql = "INSERT INTO REIMBURSE (USER_ID, EXPENSES) VALUES (?, ?)";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, user_id);
			statement.setDouble(2, expenses);
			statement.executeQuery();

			con.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Reimburse> getAllReimbursements() {
		PreparedStatement pstmt = null;

		List<Reimburse> al = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {

			String sql = "SELECT * FROM REIMBURSE";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			// move through result set
			while (rs.next()) {
				int id = rs.getInt("REIMBURSE_ID");
				int uid = rs.getInt("User_ID");
				float expense = rs.getFloat("EXPENSES");
				int pending = rs.getInt("PENDING_STATE");
				String manager = rs.getString("MANAGER_VIEW");
				al.add(new Reimburse(id, uid, expense, pending, manager));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return al;
	}

	public List<Reimburse> getReimbursementByUserAccount(String username) {
		PreparedStatement pstmt = null;

		List<Reimburse> al = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {

			String sql = "SELECT * FROM REIMBURSE WHERE USER_ID IN (SELECT USER_ID FROM USERS WHERE USERNAME = ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();

			// move through result set
			while (rs.next()) {
				int id = rs.getInt("REIMBURSE_ID");
				int uid = rs.getInt("User_ID");
				float expense = rs.getFloat("EXPENSES");
				int pending = rs.getInt("PENDING_STATE");
				String manager = rs.getString("MANAGER_VIEW");
				al.add(new Reimburse(id, uid, expense, pending, manager));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return al;
	}

	public Reimburse getReimburseById(int reid) {
		
		PreparedStatement pstmt = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {

			String sql = "SELECT * FROM REIMBURSE WHERE REIMBURSE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reid);
			ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			int userId = rs.getInt("USER_ID");
			Float expenses = rs.getFloat("EXPENSES");
			int pending = rs.getInt("PENDING_STATE");
			String manager = rs.getString("MANAGER_VIEW");
			return new Reimburse(reid, userId, expenses, pending, manager);
			
		}
		}
		catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Reimburse> getAllCertainReimbursement(int pendingState) {

		PreparedStatement pstmt = null;

		List<Reimburse> al = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {

			String sql = "SELECT * FROM REIMBURSE WHERE PENDING_STATE = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pendingState);
			ResultSet rs = pstmt.executeQuery();

			// move through result set
			while (rs.next()) {
				int id = rs.getInt("REIMBURSE_ID");
				int uid = rs.getInt("User_ID");
				float expense = rs.getFloat("EXPENSES");
				int pending = rs.getInt("PENDING_STATE");
				String manager = rs.getString("MANAGER_VIEW");
				al.add(new Reimburse(id, uid, expense, pending, manager));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return al;
	}

	public int changePendingState(int reimburse_id, String managerUsername, int newState) {
		CallableStatement cs = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "{call PROC_CHANGE_REIMBURSE_STATE(?, ?, ?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1, reimburse_id);
			cs.setString(2, managerUsername);
			cs.setInt(3, newState);
			cs.execute();
			con.close();
			return 1;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
