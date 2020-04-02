package daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import models.Superhuman;
import models.Superteams;

public class SuperDAO implements superDaoInterface {
	
	
	private SessionFactory sf;

	@Autowired
	public void setsessionFactory(SessionFactory sf) {
		this.sf = sf;
	}
	
	
	////////////////////
	//Create
	///////////////////
	

	@Override
	public void registerSuperhuman(Superhuman superhuman) {

	}

	@Override
	public List<Superhuman> getAllSuperhumans() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Superhuman getSuperhumanByName(String super_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Superteams> getAllSuperteams() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Superhuman> getAllSuperhumansByTeam(String team_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSuperhuman(Superhuman superhuman) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSuperhumanToTeam(String super_name, String team_name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeSuperhuman(String super_name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeSuperTeam(String team_name) {
		// TODO Auto-generated method stub

	}

}
