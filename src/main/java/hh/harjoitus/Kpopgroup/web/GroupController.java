package hh.harjoitus.Kpopgroup.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.harjoitus.Kpopgroup.domain.Generation;
import hh.harjoitus.Kpopgroup.domain.GenerationRepository;
import hh.harjoitus.Kpopgroup.domain.Kpopgroup;
import hh.harjoitus.Kpopgroup.domain.KpopgroupRepository;

@Controller
public class GroupController {
	
	@Autowired
	private KpopgroupRepository kpopgroupRepository;
	
	@Autowired
	private GenerationRepository generationRepository;
	
	// The index site
		@GetMapping("/index")
		public String indexPage() {
			return "kpopgroupmainpage";
		}
		
		// Search a list of groups
		@GetMapping("/kpopgrouplist")
		public String listPage(Model model) {
			model.addAttribute("kpopgroups", kpopgroupRepository.findAll());
			return "kpopgrouplist";
		}
		
		// Add a group
		@GetMapping("/addkpopgroup")
		public String addGroup(Model model) {
			model.addAttribute("kpopgroup", new Kpopgroup());
			return "addkpopgroup";
		}
		
		// Save a group
		@PostMapping("/save")
		public String save(Kpopgroup kpopgroup, Generation generation) {
			kpopgroupRepository.save(kpopgroup);
			generationRepository.save(generation);
			return "redirect:../kpopgrouplist";
		}
		
		// Delete a group
		@GetMapping("/delete/{id}")
		public String deleteGroup(@PathVariable("id") Long id, Model model) {
			kpopgroupRepository.deleteById(id);
			return "redirect:../kpopgrouplist";
		}

}
