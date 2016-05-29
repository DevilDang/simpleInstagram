package simpleInstagram.web.datamodel.request;

public class Feed {
	
	private String uploadedFilename;
	private String uploadedFileUrl;
	private String description;
	
	public Feed() {
		// TODO Auto-generated constructor stub
	}
	
	public String getUploadedFilename() {
		return uploadedFilename;
	}
	public Feed(String uploadedFilename, String uploadedFileUrl, String description) {
		super();
		this.uploadedFilename = uploadedFilename;
		this.uploadedFileUrl = uploadedFileUrl;
		this.description = description;
	}
	public void setUploadedFilename(String uploadedFilename) {
		this.uploadedFilename = uploadedFilename;
	}
	public String getUploadedFileUrl() {
		return uploadedFileUrl;
	}
	public void setUploadedFileUrl(String uploadedFileUrl) {
		this.uploadedFileUrl = uploadedFileUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Feed [uploadedFilename=" + uploadedFilename + ", uploadedFileUrl=" + uploadedFileUrl + ", description="
				+ description + "]";
	}
	
	

}
