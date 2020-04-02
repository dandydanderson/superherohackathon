package services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daos.SuperDAO;
import models.Superhuman;
import models.Superteams;

@Service
public class SuperService {

	private SuperDAO dao;

	@Autowired
	public void setDao(SuperDAO dao) {
		this.dao = dao;
	}

	
////////////////////
//Create
///////////////////

	public void registerSuperhuman(Superhuman superhuman) {
		dao.registerSuperhuman(superhuman);
	}
	
	public void registerSuperteam(Superteams superteam) {
		dao.registerSuperteam(superteam);
	}
	
	

/////////////////
////Read
//////////////

	
	public List<Superhuman> getAllSuperhumans() {
		return dao.getAllSuperhumans();
	}
	
		
	public Superhuman getSuperhumanByName(String super_name) {
		return dao.getSuperhumanByName(super_name);
	}
	
	
	public List<Superteams> getAllSuperteams(){
		return dao.getAllSuperteams();
	}
		
	
	public List<Superhuman> getAllSuperhumansByTeam(String team_name){
		return dao.getAllSuperhumansByTeam(team_name);
	}
	
	public Superteams getSuperteamByName(String team_name) {
		return dao.getSuperteam(team_name);
	}
	
	

/////////////////
////Update
//////////////

		
	public void updateSuperhuman(Superhuman superhuman) {
		
		//need to also have a check if updating team that team has same alignment
		
		if(dao.getSuperhumanByName(superhuman.getSuper_name())!=null) {
			dao.updateSuperhuman(superhuman);
		}
	}
	
	
	
//
/////////////////
////Delete
//////////////
//

	
	public void removeSuperhuman(Superhuman superhuman) {
		dao.removeSuperhuman(superhuman);
	}
	

	
	public void removeSuperteam(Superteams superteam) {
		
		
		//need logic to update all heroes who are part of this team to the independent team
		
		ArrayList<Superhuman> supers = new ArrayList<Superhuman>();
		
		supers = (ArrayList<Superhuman>) dao.getAllSuperhumansByTeam(superteam.getTeam_name());
		
		for(int i = 0; i<supers.size();i++) {//update all the supers team_name to independent
			Superhuman updatedSuper = supers.get(i);
			updatedSuper.setTeam_name("Independent");
			dao.updateSuperhuman(updatedSuper);
		}
		
		dao.removeSuperTeam(superteam);//finally, remove the superteam
	}

}
