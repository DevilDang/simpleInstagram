package simpleInstagram.database.modelenity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "User",uniqueConstraints = @UniqueConstraint(columnNames = { "email" }))
public class User extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8748970997986822451L;

	@Id
	@Column(name="userID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column( name="email")
	private String email;
	
	@Column (name = "password")
	private String password;
	
	@Column (name = "name")
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<PhotoFeed> getPhotofeeds() {
		return photofeeds;
	}
	public void setPhotofeeds(Set<PhotoFeed> photofeeds) {
		this.photofeeds = photofeeds;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user",cascade = CascadeType.ALL)
	@OrderBy("updateDate")
	private Set<PhotoFeed> photofeeds;// count of user who he follow
	
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name
				+ ", getPhotofeeds()=" + getPhotofeeds() + "]";
	}
	
	
	
	
	
	
	
	
}
