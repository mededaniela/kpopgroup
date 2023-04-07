package hh.harjoitus.Kpopgroup.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hh.harjoitus.Kpopgroup.domain.GenerationRepository;
import hh.harjoitus.Kpopgroup.domain.Kpopgroup;
import hh.harjoitus.Kpopgroup.domain.KpopgroupRepository;
import hh.harjoitus.Kpopgroup.domain.Member;
import hh.harjoitus.Kpopgroup.domain.MemberRepository;

@Controller
public class MemberController {
	
	@Autowired
	private KpopgroupRepository kpopgroupRepository;
	
	@Autowired
	private GenerationRepository generationRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@GetMapping("/members/{id}")
	public String memberList(Model model) {
		model.addAttribute("members", memberRepository.findAll()); 
		return "memberlist";
		}
	
	@GetMapping("/addmember")
	public String addMember(Model model) {
		model.addAttribute("member", new Member());
		return "addmember";
	}
	
	@PostMapping("/savemember")
	public String saveMember(Member member, Kpopgroup kpopgroup) {
		memberRepository.save(member);
		kpopgroupRepository.save(kpopgroup);
		return "redirect:../memberlist";
	}
	}
	




