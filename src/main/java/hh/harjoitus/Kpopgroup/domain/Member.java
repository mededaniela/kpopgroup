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
	private Long memberId;
	
	private String artistname;
	private String lastname;
	private String firstname;
	
	@ManyToOne
	@JsonIgnoreProperties("member")
	@JoinColumn(name= "id")
	private Kpopgroup kpopgroup;
	
	// Constructors
	
	public Member() {
		super();
		this.memberId = null;
		this.artistname = null;
		this.lastname = null;
		this.firstname = null;
	}
	
	
	public Member(Long memberId, String artistname, String lastname, String firstname) {
		super();
		this.memberId = memberId;
		this.artistname = artistname;
		this.lastname = lastname;
		this.firstname = firstname;
	}



	public Member(String artistname, String lastname, String firstname) {
		super();
		this.artistname = artistname;
		this.lastname = lastname;
		this.firstname = firstname;
	}

	public Member(String artistname, String lastname, String firstname, Kpopgroup kpopgroup) {
		super();
		this.artistname = artistname;
		this.lastname = lastname;
		this.firstname = firstname;
		this.kpopgroup = kpopgroup;
	}
	
	// Getters and setters

	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
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

	public Kpopgroup getKpopgroup() {
		return kpopgroup;
	}

	public void setKpopgroup(Kpopgroup kpopgroup) {
		this.kpopgroup = kpopgroup;
	}

	
	// toString
	
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", artistname=" + artistname + ", lastname=" + lastname + ", firstname="
				+ firstname + "]";
	}
	
	

}