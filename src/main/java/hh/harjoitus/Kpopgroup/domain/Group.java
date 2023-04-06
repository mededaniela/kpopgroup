package hh.harjoitus.Kpopgroup.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Group {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long groupId;
	private String groupname;
	private int debutyear;
	
	@OneToMany
	@JsonIgnoreProperties("groups")
	@JoinColumn(name= "memberId")
	private Member member;
	
	// Constructors
	
	public Group() {
		super();
	}
	
	public Group(String groupname, int debutyear) {
		super();
		this.groupname = groupname;
		this.debutyear = debutyear;
	}

	public Group(String groupname, int debutyear, Member member) {
		super();
		this.groupname = groupname;
		this.debutyear = debutyear;
		this.member = member;
	}
	
	// Getters and setters

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public int getDebutyear() {
		return debutyear;
	}

	public void setDebutyear(int debutyear) {
		this.debutyear = debutyear;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", groupname=" + groupname + ", debutyear=" + debutyear + "]";
	}
	
	
	
	
	
}
