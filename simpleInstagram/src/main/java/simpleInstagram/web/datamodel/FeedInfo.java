package simpleInstagram.web.datamodel;

public class FeedInfo {
	
	public FeedInfo(String username, String description, String imgUrl) {
		super();
		this.username = username;
		this.description = description;
		this.imgUrl = imgUrl;
	}
	private String username;
	private String description;
	private String imgUrl;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	

}
