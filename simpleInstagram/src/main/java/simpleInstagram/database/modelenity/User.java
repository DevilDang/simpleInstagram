package simpleInstagram.database.modelenity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
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
	
	
	
	
	
}
