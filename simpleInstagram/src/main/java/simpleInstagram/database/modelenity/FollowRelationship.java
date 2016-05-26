package simpleInstagram.database.modelenity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "FollowRelationship", uniqueConstraints = @UniqueConstraint(columnNames = { "userID","followerID" }))
public class FollowRelationship {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((followerID == null) ? 0 : followerID.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FollowRelationship other = (FollowRelationship) obj;
		if (followerID == null) {
			if (other.followerID != null)
				return false;
		} else if (!followerID.equals(other.followerID))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (userID == null) {
			if (other.userID != null)
				return false;
		} else if (!userID.equals(other.userID))
			return false;
		return true;
	}

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

	@Override
	public String toString() {
		return "FollowRelationship [id=" + id + ", userID=" + userID + ", followerID=" + followerID + "]";
	}
	
	

}
