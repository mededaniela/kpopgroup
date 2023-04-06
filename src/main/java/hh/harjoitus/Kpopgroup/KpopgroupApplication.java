package hh.harjoitus.Kpopgroup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.harjoitus.Kpopgroup.domain.GenerationRepository;
import hh.harjoitus.Kpopgroup.domain.Group;
import hh.harjoitus.Kpopgroup.domain.GroupRepository;
import hh.harjoitus.Kpopgroup.domain.Member;
import hh.harjoitus.Kpopgroup.domain.MemberRepository;

@SpringBootApplication
public class KpopgroupApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(KpopgroupApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner examples(GroupRepository groupRepository, MemberRepository memberRepository, GenerationRepository genrepository) {

		return (args) -> {
			
			Group group1 = new Group("Twice", 2015);
			
			groupRepository.save(group1);
			
			Member member1 = new Member("Sana", "Minatozaki", "Sana", group1);
			
			memberRepository.save(member1);

		};
	}
}
