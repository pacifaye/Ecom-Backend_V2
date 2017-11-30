package EJBLOCAL;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;
 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import model.Formation;
import model.Utilisateur;
/**
 * Session Bean implementation class Connection
 */
@Stateless(name="ConnectionBean")
@LocalBean
public class Connection implements ConnectionLocal {

    /**
     * Default constructor. 
     */
    @PersistenceContext(unitName = "Myecommerce")
	private EntityManager em;
	
	
    public Connection() { }

	@Transactional 
	public boolean isAuthGood(String log, String pw) {
		 
		boolean check = false;
	 
       	String sql = "SELECT u FROM Utilisateur u WHERE u.email=:arg1 and u.password=:arg2  ";
		Query query = this.em.createQuery(sql);	 
		query.setParameter("arg1", log);
		query.setParameter("arg2", pw);
		List<Utilisateur> Users = query.getResultList(); 
		
		System.out.println(Users.toString());
      
		if (Users.isEmpty()) {  check = false; }else {  check = true; }
    	  
		return check;
	}
    
    
    public Utilisateur getUserInfo(String log){
		Utilisateur user = null;
		 
		String sql = "SELECT u FROM Utilisateur u WHERE u.email=:arg1  ";
		Query query = this.em.createQuery(sql);	 
		query.setParameter("arg1", log); 
		
		 try {
		user = (Utilisateur) query.getSingleResult();
		 return user;
		 }catch(Exception e ) {
			 return null;
		 }
		 
	}
    
    
   
    
    @Override
	public void SubscribeRequest(Utilisateur u) {
    	// à refaire avec persist
    	
		// Requete d' insert au niveau de la base
			String s = "'"+u.getName()+"','"+u.getFname()+"','"+u.getEmail()+"',"+u.getPhone()+",'"+u.getSavedate()+"',"+u.getState()+",'"+u.getPassword()+"'";
			String sql = "INSERT INTO Utilisateur (NAME,FNAME,EMAIL,PHONE,SAVEDATE,STATE,PASSWORD)VALUES("+s+");";
			Query query = em.createNativeQuery(sql);
			query.executeUpdate();
	 }
    
    
    
    
    
    
    
    
}
