package hh.harjoitus.Kpopgroup.domain;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Generation {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long generationId;
	private String generationName;
	
	
	@JsonIgnoreProperties("generation")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "generation")
	private List<Kpopgroup> kpopgroups;
	
	// Constructors
	
	public Generation() {
		super();
		this.generationId = null;
		this.generationName = null;
	}

	public Generation(String generationName) {
		super();
		this.generationName = generationName;
	}
	
	

	public Generation(Long generationId, String generationName) {
		super();
		this.generationId = generationId;
		this.generationName = generationName;
	}

	public Generation(String generationName, List<Kpopgroup> kpopgroups) {
		super();
		this.generationName = generationName;
		this.kpopgroups = kpopgroups;
	}
	
	// Getters and setters

	public Long getGenerationId() {
		return generationId;
	}

	public void setGenerationId(Long generationId) {
		this.generationId = generationId;
	}

	public String getGenerationName() {
		return generationName;
	}

	public void setGenerationName(String generationName) {
		this.generationName = generationName;
	}

	public List<Kpopgroup> getKpopgroups() {
		return kpopgroups;
	}

	public void setKpopgroups(List<Kpopgroup> kpopgroups) {
		this.kpopgroups = kpopgroups;
	}

	@Override
	public String toString() {
		return "Generation [generationId=" + generationId + ", generationName=" + generationName + "]";
	}
	
	
	
	
}