package simpleInstagram.database.modelenity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "User", uniqueConstraints = @UniqueConstraint(columnNames = { "userID","followeID" }))
public class FollowRelationship {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="userID", nullable=false)
	private String userID;
	
	@Column(name="followerID", nullable=false)
	private String followerID;


	public String getFollowerID() {
		return followerID;
	}

	public void setFollowerID(String followerID) {
		this.followerID = followerID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	

}
