package hh.harjoitus.Kpopgroup.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {

	List<Group> findByArtistName(String string);
}
