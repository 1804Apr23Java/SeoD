package codingchallenge.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private String filename = "codingchallenge2.properties";
	
	public boolean raiseSalary (int departmentId, double raisePercent) {
		CallableStatement cs = null;
        
        try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
            String sql = "{call SP_GIVE_RAISE(?, ?)}";
            cs = con.prepareCall(sql);
            cs.setInt(1, departmentId);
            cs.setDouble(2, raisePercent);
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

}
