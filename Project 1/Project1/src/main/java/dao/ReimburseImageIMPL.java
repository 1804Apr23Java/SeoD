package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import domain.Image;
import domain.Reimburse;
import util.ConnectionUtil;

public class ReimburseImageIMPL implements ReimburseImageDAO {

	/*
	 * Use this when creating blob object first time? File file = new
	 * File(filename); FileInputStream input = new FileInputStream(file);
	 */

	@Override
	public boolean insertNewImage(int reimburse_id, InputStream image_ref) {
		//FileInputStream fileInputStream = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {

			String sql = "INSERT INTO REIMBURSE_IMAGE (REIMBURSE_ID, PHOTO) VALUES (?, ?)";
			//fileInputStream = new FileInputStream(image_ref);

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, reimburse_id);
			statement.setBlob(2, image_ref);
			//statement.setBinaryStream(2, image_ref, image_ref.available());
			//statement.setBinaryStream(2, fileInputStream, fileInputStream.available());
			statement.executeUpdate();

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
	public List<Image> getImagesByReimbursement(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getOneImage(int image_id) {
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {

			String sql = "SELECT PHOTO FROM REIMBURSE_IMAGE WHERE REIMBURSE_IMAGE_ID = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, image_id);
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				//int imageNum = rs.getInt("REIMBURSE_IMAGE_ID");
				//int reimburse_id = rs.getInt("REIMBURSE_ID");
				Blob blob = rs.getBlob("PHOTO");
				//String name = rs.getString("PHOTO_NAME");
				return new Image(0, image_id, blob, "test");

			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteImage() {
		// TODO Auto-generated method stub
		return false;
	}

}
