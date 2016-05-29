package simpleInstagram.web.datamodel.response;

public class CommentInfo {
	
	private String username;
	private String content;
	
	public CommentInfo(String username, String content) {
		super();
		this.username = username;
		this.content = content;
	}
	public CommentInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	

}
