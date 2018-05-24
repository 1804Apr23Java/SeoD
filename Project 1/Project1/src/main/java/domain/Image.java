package domain;

import java.io.FileInputStream;
import java.sql.Blob;

public class Image {

	private int imageId;
	private int reimburseId;
	Blob imageFile;
	private String imageName;
	
	
	public Image(int imageId, int reimburseId, Blob imageFile, String imageName) {
		super();
		this.imageId = imageId;
		this.reimburseId = reimburseId;
		this.imageFile = imageFile;
	}
	
	public Image(int reimburseId, Blob imageFile, String imageName) {
		super();
		this.reimburseId = reimburseId;
		this.imageFile = imageFile;
	}
	
	public Image() {
		super();
	}
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public int getReimburseId() {
		return reimburseId;
	}
	public void setReimburseId(int reimburseId) {
		this.reimburseId = reimburseId;
	}
	public Blob getImageFile() {
		return imageFile;
	}
	public void setImageFile(Blob imageFile) {
		this.imageFile = imageFile;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	@Override
	public String toString() {
		return "Image [imageId=" + imageId + ", reimburseId=" + reimburseId + ", imageFile=" + imageFile + "]";
	}
	
	
}
