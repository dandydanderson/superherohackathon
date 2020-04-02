package daos;

import java.util.List;

import models.Superhuman;
import models.Superteams;

public interface superDaoInterface {
	
	
	////////////////////
	//Create
	///////////////////
	
	
	public void registerSuperhuman(Superhuman superhuman);
	
	
	///////////////
	//Read
	////////////
	
	
	public List<Superhuman> getAllSuperhumans();
	
	public Superhuman getSuperhumanByName(String super_name);
	
	public List<Superteams> getAllSuperteams();
	
	public List<Superhuman> getAllSuperhumansByTeam(String team_name);
	
	
	//////////////
	//Update
	////////////
	
	public void updateSuperhuman(Superhuman superhuman);
	
	public void addSuperhumanToTeam(String super_name, String team_name);
	
	////////////////////
	//Delete
	//////////////////
	
	public void removeSuperhuman(String super_name);
	
	public void removeSuperTeam(String team_name);

}
