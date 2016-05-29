package simpleInstagram.web.datamodel.response;

public class FileUploadedInfo {
	
	private String uploadedFileName;
	private String uploadedFileUrl;
	public String getUploadedFileName() {
		return uploadedFileName;
	}
	public void setUploadedFileName(String uploadedFileName) {
		this.uploadedFileName = uploadedFileName;
	}
	public String getUploadedFileUrl() {
		return uploadedFileUrl;
	}
	public void setUploadedFileUrl(String uploadedFileUrl) {
		this.uploadedFileUrl = uploadedFileUrl;
	}
	public FileUploadedInfo(String uploadedFileName, String uploadedFileUrl) {
		super();
		this.uploadedFileName = uploadedFileName;
		this.uploadedFileUrl = uploadedFileUrl;
	}
	public FileUploadedInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
