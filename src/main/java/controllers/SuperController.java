package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import models.Superhuman;
import models.Superteams;
import services.SuperService;

@Controller
public class SuperController {
	
	
	private SuperService ss;
	
	@Autowired
	public void setService(SuperService ss) {
		this.ss = ss;
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/superhuman")
	@ResponseBody
	public List<Superhuman> getAllSuperhumans() {
		
		
		System.out.println("Making it to my endpoint for get all heros");
	
		
		return ss.getAllSuperhumans();
	
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/superhuman/{SUPER_HUMAN_NAME}")
	@ResponseBody
	public Superhuman getSuperhumanByName(@PathVariable String SUPER_HUMAN_NAME) {
		return ss.getSuperhumanByName(SUPER_HUMAN_NAME);
	}
		

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/superhuman")
	public void addSuperhuman(@RequestBody Superhuman superhuman) {
		
		ss.registerSuperhuman(superhuman);
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/superhuman")
	public void updateSuperhuman(@RequestBody Superhuman superhuman) {
		ss.updateSuperhuman(superhuman);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/superhuman")
	public void removeSuperhuman(@RequestBody String super_name) {
		ss.removeSuperhuman(ss.getSuperhumanByName(super_name));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/superteam")
	@ResponseBody
	public List<Superteams> getAllSuperTeams() {
		return ss.getAllSuperteams();
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/superteam/{team_name}")
	@ResponseBody
	public Superteams getTeamByName(@PathVariable String team_name) {
		
		return ss.getSuperteamByName(team_name);
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/superteam")
	public void addSuperteam(@RequestBody Superteams superteam) {
		
		ss.registerSuperteam(superteam);
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/superteam/{team_name}/super_human")
	public void addSuperhumanToTeam(@PathVariable String team_name, @RequestBody String super_name) {
		Superhuman updatedSuper = ss.getSuperhumanByName(super_name);
		Superteams updatedTeam = ss.getSuperteamByName(team_name);
		
		//this needs to happen in the service class, but....
		
		if(updatedSuper.getAlignment_type().equals(updatedTeam.getAlignment_type())) {
			updatedSuper.setTeam_name(updatedTeam.getTeam_name());
			ss.updateSuperhuman(updatedSuper);
		}
	}
	

}
