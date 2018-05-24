package dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.util.List;
import domain.Image;


public interface ReimburseImageDAO {
	
	public boolean insertNewImage(int reimburse_id, File image_ref);
	
	public List<Image> getImagesByReimbursement(String username);
	
	public Image getOneImage(int image_id);
	
	public boolean deleteImage();

}