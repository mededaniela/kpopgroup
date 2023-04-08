package hh.harjoitus.Kpopgroup.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
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
	private Integer debutyear;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "kpopgroup")
	@JsonIgnoreProperties("kpopgroup")
	private List<Member> members;
	
	@ManyToOne
	@JsonIgnoreProperties("kpopgroups")
	@JoinColumn(name="generationId")
	private Generation generation;
	
	// Constructors
	 
	public Kpopgroup() {
		super();
		this.id = null;
		this.kpopgroupname = null;
		this.debutyear = 0;
		this.members = null;
	}
	
	
	
	public Kpopgroup(Long id, String kpopgroupname, Integer debutyear) {
		super();
		this.id = id;
		this.kpopgroupname = kpopgroupname;
		this.debutyear = debutyear;
	}



	public Kpopgroup(String kpopgroupname, Integer debutyear) {
		super();
		this.kpopgroupname = kpopgroupname;
		this.debutyear = debutyear;
	}

	public Kpopgroup(String kpopgroupname, Integer debutyear, List<Member> members, Generation generation) {
		super();
		this.kpopgroupname = kpopgroupname;
		this.debutyear = debutyear;
		this.members = members;
		this.generation = generation;
	}
	

	public Kpopgroup(String kpopgroupname, Integer debutyear, Generation generation) {
		super();
		this.kpopgroupname = kpopgroupname;
		this.debutyear = debutyear;
		this.generation = generation;
	}

// Getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKpopgroupname() {
		return kpopgroupname;
	}

	public void setKpopgroupname(String kpopgroupname) {
		this.kpopgroupname = kpopgroupname;
	}

	public Integer getDebutyear() {
		return debutyear;
	}

	public void setDebutyear(Integer debutyear) {
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