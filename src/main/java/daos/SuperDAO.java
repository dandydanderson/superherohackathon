package daos;

import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import models.Superhuman;
import models.Superteams;


@Component
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
		
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(superhuman);
		tx.commit();
		
	}
	
	public void registerSuperteam(Superteams superteams) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(superteams);
		tx.commit();
	}
	
	///////////////
	//Read
	////////////

	@Override
	public List<Superhuman> getAllSuperhumans() {
		
		Session sess = sf.openSession();
		CriteriaBuilder cb = sess.getCriteriaBuilder();
		CriteriaQuery<Superhuman> cq = cb.createQuery(Superhuman.class);
		Root<Superhuman> rootEntry = cq.from(Superhuman.class);
		CriteriaQuery<Superhuman> all = cq.select(rootEntry);
		TypedQuery<Superhuman> allQuery = sess.createQuery(all);
		return allQuery.getResultList();
		
	}

	@Override
	public Superhuman getSuperhumanByName(String super_name) {
		
		Session sess = sf.openSession();
		return sess.get(Superhuman.class, super_name);	
	}
	
	
	public Superteams getSuperteam(String team_name) {
		
		Session sess = sf.openSession();
		return sess.get(Superteams.class, team_name);	
	}

	@Override
	public List<Superteams> getAllSuperteams() {

		Session sess = sf.openSession();
		CriteriaBuilder cb = sess.getCriteriaBuilder();
		CriteriaQuery<Superteams> cq = cb.createQuery(Superteams.class);
		Root<Superteams> rootEntry = cq.from(Superteams.class);
		CriteriaQuery<Superteams> all = cq.select(rootEntry);
		TypedQuery<Superteams> allQuery = sess.createQuery(all);
		return allQuery.getResultList();
		
	}

	@Override
	public List<Superhuman> getAllSuperhumansByTeam(String team_name) {


		
		Session sess = sf.openSession();
		CriteriaBuilder cb = sess.getCriteriaBuilder();
		CriteriaQuery<Superhuman> cq = cb.createQuery(Superhuman.class);
		Root<Superhuman> rootEntry = cq.from(Superhuman.class);
		CriteriaQuery<Superhuman> all = cq.select(rootEntry).where(cb.equal(rootEntry.get("team_name"), team_name));

		TypedQuery<Superhuman> allQuery = sess.createQuery(all);

		return allQuery.getResultList();
		
	}

	
	///////////////
	//Update
	////////////
	
	
	@Override
	public void updateSuperhuman(Superhuman superhuman) {


		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.saveOrUpdate(superhuman);
		tx.commit();

	}

	@Override
	public void addSuperhumanToTeam(String super_name, String team_name) {

		//this method is actually covered by updateSuperhuman, not needed
		
	}

	
	///////////////
	//Delete
	////////////
	
	@Override
	public void removeSuperhuman(Superhuman superhuman) {

		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(superhuman);
		tx.commit();

	}

	@Override
	public void removeSuperTeam(Superteams superteam) {//this will have to be called in conjunction with updating all supers with this team reference


		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(superteam);
		tx.commit();

	}

}
