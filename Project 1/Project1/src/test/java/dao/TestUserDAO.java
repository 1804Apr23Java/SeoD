package dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import dao.UserDAO;
import dao.UserIMPL;
import domain.User;

public class TestUserDAO {
	/*
	public User getUserInfo(String username);
	
	public int checkLoginInfo(String username, String password);
	
	public boolean updateUserInfo(String username, String firstName, String lastName, String email);
	
	public boolean changePassword(String username, String newPassword);
	
	public List<User> getAllUsers();
	
	*/
	public static final UserDAO userTest = new UserIMPL();


    @Test
    public void testgetUserInfo() {
    	User test = new User("test_username", "password", "firstName", "lastname", "test@mail", 0);
    	User realUser = userTest.getUserInfo("test_username")
    	assertTrue(test.equals(realUser));
    }
    
    @Test
    public void testcheckLoginInfo() {

    	int x = userTest.checkLoginInfo("test_username", "test_password");
    	assertTrue(x == 0);
    }
    
    @Test
    public void testUpdateUserInfo() {
        assertTrue(userTest.updateUserInfo("tonyLL", "tony", "qq", "tony@mail"));
    }
    
    @Test
    public void testChangePassword() {
        assertTrue(userTest.changePassword("tonyLL", "12345"));
    }
    
    @Test
    public void testGetAllUsers() {
        assertNotNull(userTest.getAllUsers());
    }
    
}
