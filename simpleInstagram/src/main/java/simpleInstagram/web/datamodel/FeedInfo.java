package simpleInstagram.web.datamodel;

import java.util.List;

public class FeedInfo {
	
	public FeedInfo(String username, String description, String imgUrl,Long feedId) {
		super();
		this.username = username;
		this.description = description;
		this.imgUrl = imgUrl;
		this.feedId = feedId;
	}
	private String username;
	private String description;
	private String imgUrl;
	private Long feedId;
	
	private List<CommentInfo> comments;
	
	
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
	public Long getFeedId() {
		return feedId;
	}
	public void setFeedId(Long feedId) {
		this.feedId = feedId;
	}
	public List<CommentInfo> getComments() {
		return comments;
	}
	public void setComments(List<CommentInfo> comments) {
		this.comments = comments;
	}
	
	

}
