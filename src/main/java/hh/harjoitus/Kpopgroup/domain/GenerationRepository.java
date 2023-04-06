package hh.harjoitus.Kpopgroup.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GenerationRepository extends CrudRepository<Generation, Long> {
	
	List<Generation> findByGenName(String string);
}
