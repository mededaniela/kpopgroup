package hh.harjoitus.Kpopgroup;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.harjoitus.Kpopgroup.domain.Generation;
import hh.harjoitus.Kpopgroup.domain.GenerationRepository;
import hh.harjoitus.Kpopgroup.domain.Kpopgroup;
import hh.harjoitus.Kpopgroup.domain.KpopgroupRepository;
import hh.harjoitus.Kpopgroup.domain.Member;
import hh.harjoitus.Kpopgroup.domain.MemberRepository;
import hh.harjoitus.Kpopgroup.domain.User;
import hh.harjoitus.Kpopgroup.domain.UserRepository;
import jakarta.transaction.Transactional;

@SpringBootApplication
public class KpopgroupApplication {
	
	private static final Logger log = LoggerFactory.getLogger(KpopgroupApplication.class);

	public static void main(String[] args) {
		
		SpringApplication.run(KpopgroupApplication.class, args);
	}
	
	@Transactional
	@Bean
	public CommandLineRunner examples(KpopgroupRepository kpopgroupRepository, MemberRepository memberRepository, GenerationRepository generationRepository, UserRepository userRepository) {

		return (args) -> {
			
			Generation gen1 = new Generation("1st gen");
			Generation gen2 = new Generation("2nd gen");
			Generation gen3 = new Generation("3rd gen");
			Generation gen4 = new Generation("4th gen");
			Generation gen5 = new Generation("5th gen");
			
			generationRepository.save(gen1);
			generationRepository.save(gen2);
			generationRepository.save(gen3);
			generationRepository.save(gen4);
			generationRepository.save(gen5);
			
			log.info("save some kpop groups");
			Kpopgroup kpopgroup1 = new Kpopgroup("Twice", 2015, gen3);
			Kpopgroup kpopgroup2 = new Kpopgroup("Big bang", 2006, gen2);
			
			kpopgroupRepository.save(kpopgroup1);
			kpopgroupRepository.save(kpopgroup2);
			
			log.info("fetch all kpop groups");
			for (Kpopgroup kpopgroup : kpopgroupRepository.findAll())
				log.info(kpopgroup.toString());
			
			log.info("save some members");
			
			Member member1 = new Member("Sana", "Minatozaki", "Sana", kpopgroup1);
			 Member member2 = new Member("Jihyo", "Park", "Ji-hyo", kpopgroup1);
			Member member3 = new Member("Daesung", "Dae-sung", "Kang", kpopgroup2);
			
			memberRepository.save(member1);
			memberRepository.save(member2);
			memberRepository.save(member3);
			
			log.info("fetch all members");
			for (Member member : memberRepository.findAll())
				log.info(member.toString());
			
			User user1 = new User("user", "$2a$10$Dvqg0cFI3/dNX7sjNuLMdeB.PEKCpxkbD.eScexte5ilD0y8ukczq", "USER");
			User user2 = new User("admin", "$2a$10$BxylKdaiRNigzTmEeHgu4ur12YeFqO8ZjbOZWovyNe1CeGIKAO1QG", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);

		};
		};
	}
