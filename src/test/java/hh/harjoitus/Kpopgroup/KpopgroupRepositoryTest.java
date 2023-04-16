package hh.harjoitus.Kpopgroup;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.harjoitus.Kpopgroup.domain.Kpopgroup;
import hh.harjoitus.Kpopgroup.domain.KpopgroupRepository;
import hh.harjoitus.Kpopgroup.domain.Member;
import hh.harjoitus.Kpopgroup.domain.MemberRepository;
import hh.harjoitus.Kpopgroup.domain.User;
import hh.harjoitus.Kpopgroup.domain.UserRepository;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class KpopgroupRepositoryTest {

	@Autowired
	private KpopgroupRepository kpopgroupRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private UserRepository userRepository;

    
	@Test
	public void findByKpopgroupname() {
	List<Kpopgroup> kpopgroups = kpopgroupRepository.findByKpopgroupname("Twice");
	assertThat(kpopgroups.get(0).getKpopgroupname()).isEqualTo("Twice");
	}
	
	@Test
	public void findByArtistname() {
	List<Member> members = memberRepository.findByArtistname("Sana");
	assertThat(members.get(0).getArtistname()).isEqualTo("Sana");
	}
	
    @Test
    public void createNewKpopgroup() {
    	Kpopgroup kpopgroup = new Kpopgroup("Exid", 2012);
    	kpopgroupRepository.save(kpopgroup);
    	assertThat(kpopgroup.getId()).isNotNull();
    }  
    
    @Test
    public void getKpopgroup() {
    	Kpopgroup kpopgroup = kpopgroupRepository.findById((long) 1).get();
    	
    	assertThat(kpopgroup.getId()).isEqualTo((long) 1);

    }
    
    @Test
    public void getListofKpopgroups() {
    	List <Kpopgroup> kpopgroups = (List<Kpopgroup>) kpopgroupRepository.findAll();
    	
    	assertThat(kpopgroups.size()).isGreaterThan(0);
    }
    
    @Test
    public void deleteKpopgroup() {

    	Kpopgroup kpopgroup = kpopgroupRepository.findById(1L).get();

        kpopgroupRepository.delete(kpopgroup);
        
        Kpopgroup deletedKpopgroup = null;

        Optional<Kpopgroup> optionalKpopgroup = kpopgroupRepository.findById(1L);
        
        if(optionalKpopgroup.isPresent()){
            deletedKpopgroup = optionalKpopgroup.get();
        }

        assertThat(deletedKpopgroup).isNull();
    	  
    }
    
    @Test
    public void deleteMember() {

    	Member member = memberRepository.findById(1L).get();

        memberRepository.delete(member);
        
        Member deletedMember = null;

        Optional<Member> optionalMember = memberRepository.findById(1L);
        
        if(optionalMember.isPresent()){
            deletedMember = optionalMember.get();
        }

        assertThat(deletedMember).isNull();
    	  
    }
    
    @Test
    public void getMember() {
	Member member = memberRepository.findById((long) 1).get();
    	
    	assertThat(member.getMemberId()).isEqualTo((long) 1);
    }
    
    @Test
    public void createMember() {
    	Member member = new Member("Jeongyeon", "Yoo", "Jeong-yeon");
    	memberRepository.save(member);
    	assertThat(member.getArtistname()).isNotNull();
    }
    
    @Test
    public void getUser() {
    	User user = userRepository.findByUsername("admin");
    	
    	assertThat(user.getUsername()).isEqualTo("admin");
    }
    
}
