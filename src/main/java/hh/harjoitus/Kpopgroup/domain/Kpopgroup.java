package hh.harjoitus.Kpopgroup.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Kpopgroup {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String kpopgroupname;
	private int debutyear;
	
	@OneToMany
	@JsonIgnoreProperties("kpopgroups")
	@JoinColumn(name= "memberId")
	private List<Member> members;
	
	@ManyToOne
	@JoinColumn(name="generationId")
	private Generation generation;
	
	// Constructors
	
	public Kpopgroup() {
		super();
		this.id = null;
		this.kpopgroupname = null;
		this.debutyear = 0;
	}
	
	
	
	public Kpopgroup(long id, String kpopgroupname, int debutyear) {
		super();
		this.id = id;
		this.kpopgroupname = kpopgroupname;
		this.debutyear = debutyear;
	}



	public Kpopgroup(String kpopgroupname, int debutyear) {
		super();
		this.kpopgroupname = kpopgroupname;
		this.debutyear = debutyear;
	}

	public Kpopgroup(String kpopgroupname, int debutyear, List<Member> members, Generation generation) {
		super();
		this.kpopgroupname = kpopgroupname;
		this.debutyear = debutyear;
		this.members = members;
		this.generation = generation;
	}
	

	public Kpopgroup(String kpopgroupname, int debutyear, Generation generation) {
		super();
		this.kpopgroupname = kpopgroupname;
		this.debutyear = debutyear;
		this.generation = generation;
	}

// Getters and setters

	public long getId() {
		return id;
	}

	public void setId(long groupId) {
		this.id = groupId;
	}

	public String getKpopgroupname() {
		return kpopgroupname;
	}

	public void setKpopgroupname(String kpopgroupname) {
		this.kpopgroupname = kpopgroupname;
	}

	public int getDebutyear() {
		return debutyear;
	}

	public void setDebutyear(int debutyear) {
		this.debutyear = debutyear;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}
	
	

	public Generation getGeneration() {
		return generation;
	}



	public void setGeneration(Generation generation) {
		this.generation = generation;
	}



	@Override
	public String toString() {
		return "Kpopgroup [id=" + id + ", kpopgroupname=" + kpopgroupname + ", debutyear=" + debutyear + "]";
	}
	
	
	
	
	
}