package EJBLOCAL;

import javax.ejb.ApplicationException;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.json.simple.JSONObject;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import model.Formation;
import java.util.List;
  
/**
 * Session Bean implementation class ejb1
 */
@Stateless
public class ejb1   implements ejb1Local {

    /**
     * Default constructor. 
     */
 	 
	
	
    public ejb1() {  }
    
    @PersistenceContext(unitName = "Myecommerce")
	private EntityManager em;
     

	 
	@Transactional 
	public String call() {
		String abc = "aa";
		
		if (this.em == null) {
			abc = "null";
		}else {
			abc = this.em.toString();
		}
		
		
	 //  Formation F= em.find(Formation.class, "Hibernate77");
		   
	  	String sql = "SELECT f FROM Formation f ";
		Query query = this.em.createQuery(sql);	 
		//String password = query.getResultList().toString();
		List<Formation> instruments = query.getResultList(); 
		
		
		 //em.merge(new Formation(1,"Hibernate199"));
			
		 
		  //	this.em.persist(new Formation(22,"Hibernate19934"));
		   	 
		  // 	this.em.flush();
		  // 	this.em.clear();
		   
		Formation f = ((Formation)instruments.get(0));
	    
		
		return f.getTheme();
	}
	
	
	
	
	@Transactional 
	public List<Formation> getFormations() {
		
		 
		Query query = this.em.createQuery("SELECT f FROM Formation f ");	 
		
		
		return query.getResultList(); 
	 }
	
	
	
	
	
	
	
	

}
