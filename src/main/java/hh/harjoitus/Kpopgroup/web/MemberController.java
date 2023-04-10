package hh.harjoitus.Kpopgroup.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.harjoitus.Kpopgroup.domain.GenerationRepository;
import hh.harjoitus.Kpopgroup.domain.Kpopgroup;
import hh.harjoitus.Kpopgroup.domain.KpopgroupRepository;
import hh.harjoitus.Kpopgroup.domain.Member;
import hh.harjoitus.Kpopgroup.domain.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MemberController {
	
	@Autowired
	private KpopgroupRepository kpopgroupRepository;
	
	@Autowired
	private GenerationRepository generationRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@GetMapping("/addmember")
	public String addMember(Model model) {
		model.addAttribute("member", new Member());
		model.addAttribute("kpopgroups", kpopgroupRepository.findAll());
		model.addAttribute("generation", generationRepository.findAll());
		return "addmember";
	}
	
	@PostMapping("/savemember")
	public String saveMember(Member member, Kpopgroup kpopgroup) {
		memberRepository.save(member);
		kpopgroupRepository.save(kpopgroup);
		return "redirect:kpopgrouplist";
	}
	
	@GetMapping("/deletemember/{id}")
	public String deleteGroup(@PathVariable("memberId") Long memberid, Model model) {
		memberRepository.deleteById(memberid);
		return "redirect:../kpopgrouplist";
	}
	}
	




