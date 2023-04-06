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
	private List<Group> groups;
	
	// Constructors
	
	public Generation() {
		
	}

	public Generation(String generationName) {
		super();
		this.generationName = generationName;
	}

	public Generation(String generationName, List<Group> groups) {
		super();
		this.generationName = generationName;
		this.groups = groups;
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

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	
	
	
	
}