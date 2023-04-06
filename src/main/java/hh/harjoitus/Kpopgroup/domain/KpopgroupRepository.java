package hh.harjoitus.Kpopgroup.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface KpopgroupRepository extends CrudRepository<Kpopgroup, Long> {
	
	List<Kpopgroup> findByKpopgroupname(String string);

}
