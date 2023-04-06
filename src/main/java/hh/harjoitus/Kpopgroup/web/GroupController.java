package hh.harjoitus.Kpopgroup.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.harjoitus.Kpopgroup.domain.Generation;
import hh.harjoitus.Kpopgroup.domain.GenerationRepository;
import hh.harjoitus.Kpopgroup.domain.Group;
import hh.harjoitus.Kpopgroup.domain.GroupRepository;

@Controller
public class GroupController {
	
	@Autowired
	private GroupRepository groupRepository;
	
	@Autowired
	private GenerationRepository gRepository;
	
	// The index site
		@GetMapping("/index")
		public String indexPage() {
			return "groupmainpage";
		}
		
		// Search a list of groups
		@GetMapping("/grouplist")
		public String listPage(Model model) {
			model.addAttribute("groups", groupRepository.findAll());
			return "grouplist";
		}
		
		// Add a group
		@GetMapping("/addgroup")
		public String addGroup(Model model) {
			model.addAttribute("group", new Group());
			 model.addAttribute("generations", gRepository.findAll());
			return "addgroup";
		}
		
		// Save a group
		@PostMapping("/save")
		public String save(Group group, Generation gen) {
			groupRepository.save(group);
			gRepository.save(gen);
			return "redirect:../grouplist";
		}
		
		// Delete a group
		@GetMapping("/delete/{id}")
		public String deleteGroup(@PathVariable("id") Long groupId, Model model) {
			groupRepository.deleteById(groupId);
			return "redirect:../booklist";
		}

}
