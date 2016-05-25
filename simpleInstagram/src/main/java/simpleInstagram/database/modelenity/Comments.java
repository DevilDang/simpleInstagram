package simpleInstagram.database.modelenity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Comments")
public class Comments extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8460631314767175631L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="content",nullable=false)
	private String content;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "photoFeedId", nullable = false)
	private PhotoFeed photoFeed;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public PhotoFeed getPhotoFeed() {
		return photoFeed;
	}

	public void setPhotoFeed(PhotoFeed photoFeed) {
		this.photoFeed = photoFeed;
	}
	
	
	

}
