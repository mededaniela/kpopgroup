package hh.harjoitus.Kpopgroup.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Member {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long memberId;
	private String artistname;
	private String lastname;
	private String firstname;
	
	@ManyToOne
	@JsonIgnoreProperties("members")
	@JoinColumn(name= "groupId")
	private Group group;
	
	// Constructors
	
	public Member() {
		
	}
	
	public Member(String artistname, String lastname, String firstname) {
		super();
		this.artistname = artistname;
		this.lastname = lastname;
		this.firstname = firstname;
	}

	public Member(String artistname, String lastname, String firstname, Group group) {
		super();
		this.artistname = artistname;
		this.lastname = lastname;
		this.firstname = firstname;
		this.group = group;
	}
	
	// Getters and setters

	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	public String getArtistname() {
		return artistname;
	}

	public void setArtistname(String artistname) {
		this.artistname = artistname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	
	// toString
	
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", artistname=" + artistname + ", lastname=" + lastname + ", firstname="
				+ firstname + "]";
	}
	
	

}