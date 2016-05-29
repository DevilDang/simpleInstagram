package simpleInstagram.web.datamodel.response;

public class Profile {
	
	private String username;
	private String email;
	private int countPostFeed;
	private int countFollower;
	private int countFollowing;
	
	
	
	public Profile(String username, String email, int countPostFeed, int countFollower, int countFollowing) {
		super();
		this.username = username;
		this.email = email;
		this.countPostFeed = countPostFeed;
		this.countFollower = countFollower;
		this.countFollowing = countFollowing;
	}
	
	
	
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCountPostFeed() {
		return countPostFeed;
	}
	public void setCountPostFeed(int countPostFeed) {
		this.countPostFeed = countPostFeed;
	}
	public int getCountFollower() {
		return countFollower;
	}
	public void setCountFollower(int countFollower) {
		this.countFollower = countFollower;
	}
	public int getCountFollowing() {
		return countFollowing;
	}
	public void setCountFollowing(int countFollowing) {
		this.countFollowing = countFollowing;
	}
	


}
