package dao;

import java.util.List;

import domain.User;

public interface UserDAO {

	public User getUserInfo(String username);
	
	public int checkLoginInfo(String username, String password);
	
	public boolean updateUserInfo(String username, String firstName, String lastName, String email);
	
	public boolean changePassword(String username, String newPassword);
	
	public List<User> getAllUsers();
	
}
