package hh.harjoitus.Kpopgroup.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {

	List<Member> findByArtistname(String string);

	List<Member> findByKpopgroup(Kpopgroup kpopgroup);


}
