package hh.harjoitus.Kpopgroup.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.harjoitus.Kpopgroup.domain.Member;
import hh.harjoitus.Kpopgroup.domain.MemberRepository;
import jakarta.validation.Valid;

@Controller
public class MemberController {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@PostMapping("/savemember")
	@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
	public String saveMember(@Valid Member member, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			bindingResult.rejectValue("artistname", "err.artistname", "Please enter member's artist name");
			return "redirect:/info-page/" + member.getKpopgroup().getId();
		} else {
				memberRepository.save(member);
		return "redirect:/info-page/" + member.getKpopgroup().getId();
		}
	
	}
	
	@GetMapping("/deletemember/{memberId}")
	@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
	public String deleteMember(@PathVariable("memberId") Long memberId) {
		memberRepository.deleteById(memberId);
		return "redirect:/kpopgrouplist";
	}
	
	}
	




