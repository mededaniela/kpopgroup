package hh.harjoitus.Kpopgroup.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.harjoitus.Kpopgroup.domain.Generation;
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
	
	@PostMapping("/savemember")
	@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
	public String saveMember(Member member) {
		memberRepository.save(member);
		return "redirect:/info-page/" + member.getKpopgroup().getId();
	}
	
	@GetMapping("/deletemember/{memberId}")
	@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
	public String deleteMember(@PathVariable("memberId") Long memberId) {
		memberRepository.deleteById(memberId);
		return "redirect:/kpopgrouplist";
	}
	
	}
	




