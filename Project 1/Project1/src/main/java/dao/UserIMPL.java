package dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import domain.User;
import util.ConnectionUtil;

public class UserIMPL implements UserDAO {

	@Override
	public User getUserInfo(String username) {
		
		User u = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {

			String sql = "SELECT * FROM USERS WHERE USERNAME = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();

			
			if (rs.next()) {
				int userId = rs.getInt("USER_ID");
				String userName = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				String firstname = rs.getString("FIRST_NAME");
				String lastname = rs.getString("LAST_NAME");
				String email = rs.getString("EMAIL");
				int super_user = rs.getInt("SUPER_USER");
				u = new User(userId, userName, password, firstname, lastname, email, super_user);
			}
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public int checkLoginInfo(String username, String password) {
		
		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {

			// use a prepared statement
			String sql = "SELECT USER_ID, SUPER_USER FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet resultSet = pstmt.executeQuery();

			// do something with result
			if (resultSet.next()) {
				int customerId = resultSet.getInt("USER_ID");
				int superUser = resultSet.getInt("SUPER_USER");
				if(customerId > 0 && superUser == 0)
					return 1;
				else if (customerId > 0 && superUser == 1)
				{
					return 2;
				}
				else
					return 0;
			}

			
			
		con.close();
		

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
			

	@Override
	public boolean updateUserInfo(String username, String firstName, String lastName, String email) {
		CallableStatement cs = null;
        
        try (Connection con = ConnectionUtil.getConnectionFromFile()) {
            String sql = "{call PROC_CHANGE_USER_INFO(?, ?, ?, ?)}";
            cs = con.prepareCall(sql);
            cs.setString(1, username);
            cs.setString(2,firstName);
            cs.setString(3,lastName);
            cs.setString(4,email);
            cs.execute();
            con.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
	}

	@Override
	public boolean changePassword(String username, String newPassword) {
		CallableStatement cs = null;
        
        try (Connection con = ConnectionUtil.getConnectionFromFile()) {
            String sql = "{call PROC_CHANGE_PASSWORD(?, ?)}";
            cs = con.prepareCall(sql);
            cs.setString(1, username);
            cs.setString(2, newPassword);
            cs.execute();
            con.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {

			String sql = "SELECT * FROM USERS";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			

			// move through result set
			while (resultSet.next()) {
				int id = resultSet.getInt("USER_ID");
				String username = resultSet.getString("USERNAME");
				String password = resultSet.getString("PASSWORD");
				String firstName = resultSet.getString("FIRST_NAME");
				String lastName = resultSet.getString("LAST_NAME");
				String email = resultSet.getString("EMAIL");
				int admin = resultSet.getInt("SUPER_USER");
				userList.add(new User(id, username, password, firstName, lastName, email, admin));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return userList;
	}



}
