package hh.harjoitus.Kpopgroup.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.harjoitus.Kpopgroup.domain.Generation;
import hh.harjoitus.Kpopgroup.domain.GenerationRepository;
import hh.harjoitus.Kpopgroup.domain.Kpopgroup;
import hh.harjoitus.Kpopgroup.domain.KpopgroupRepository;
import hh.harjoitus.Kpopgroup.domain.Member;
import hh.harjoitus.Kpopgroup.domain.MemberRepository;

@Controller
public class KpopgroupController {
	
	@Autowired
	private KpopgroupRepository kpopgroupRepository;
	
	@Autowired
	private GenerationRepository generationRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	// The index site
		@GetMapping("/index")
		public String indexPage() {
			return "kpopgroupmainpage";
		}
		
		// Search a list of groups
		@GetMapping("/kpopgrouplist")
		public String listPage(Model model, Member member, Kpopgroup kpopgroup) {
			model.addAttribute("kpopgroups", kpopgroupRepository.findAll());
			return "kpopgrouplist";
		}
		
		// Add a group
		@GetMapping("/addkpopgroup")
		public String addGroup(Model model) {
			model.addAttribute("kpopgroup", new Kpopgroup());
			model.addAttribute("generations", generationRepository.findAll());
			return "addkpopgroup";
		}
		
		// Save a group
		@PostMapping("/savekpopgroup")
		@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
		public String save(Kpopgroup kpopgroup, Generation generation) {
			kpopgroupRepository.save(kpopgroup);
			generationRepository.save(generation);
			return "redirect:kpopgrouplist";
		}
		
		// Delete a group
		@GetMapping("/delete/{id}")
		@PreAuthorize("hasAuthority('ROLE_ADMIN')")
		public String deleteGroup(@PathVariable("id") Long id, Model model) {
			kpopgroupRepository.deleteById(id);
			return "redirect:../kpopgrouplist";
		}
		
		// REST Search all the kpop groups
		@GetMapping("/kpopgroups")
	    public @ResponseBody List<Kpopgroup> kpopgroupListRest() {	
	        return (List<Kpopgroup>) kpopgroupRepository.findAll();
	    }    

		// REST Search kpopg roup by id
	    @GetMapping("/kpopgroups/{id}")
	    public @ResponseBody Optional<Kpopgroup> findKpopgroupRest(@PathVariable("id") Long kpopgroupId) {	
	    	return kpopgroupRepository.findById(kpopgroupId);
	    }      
	    
	    // REST Save a new kpop group
	    @PostMapping("/kpopgroups")
	    public @ResponseBody Kpopgroup saveKpopgroupRest(@RequestBody Kpopgroup kpopgroup) {	
	    	return kpopgroupRepository.save(kpopgroup);
	    }
	    
	    // REST homepage
	    @GetMapping("/resthome")
	    public String getRestHome() {	
	    	return "resthomepage";
	    }

}
