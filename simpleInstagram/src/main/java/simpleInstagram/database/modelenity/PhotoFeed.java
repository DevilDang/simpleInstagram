package simpleInstagram.database.modelenity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "PhotoFeed",uniqueConstraints = @UniqueConstraint(columnNames = { "imagePath" }))
public class PhotoFeed extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6973972955867623634L;

	@Id
	@Column(name="photoFeedId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="imagePath",nullable=false)
	private String imagePath;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "userID", nullable = false)
	private User user;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "photoFeed",cascade = CascadeType.ALL)
	private Set<Comments> commnents;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imagePath == null) ? 0 : imagePath.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhotoFeed other = (PhotoFeed) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imagePath == null) {
			if (other.imagePath != null)
				return false;
		} else if (!imagePath.equals(other.imagePath))
			return false;
		return true;
	}
	public Set<Comments> getCommnents() {
		return commnents;
	}
	public void setCommnents(Set<Comments> commnents) {
		this.commnents = commnents;
	}
	@Override
	public String toString() {
		return "PhotoFeed [id=" + id + ", imagePath=" + imagePath + ", description=" + description + ", getUser()="
				+ getUser() + ", getCommnents()=" + getCommnents() + "]";
	}
	
	
	
	
	
	
}
