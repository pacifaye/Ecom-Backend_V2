package EJBLOCAL;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EmbeddedId;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import model.Produit;
import model.SCIdentifier;
import model.SuiviCommande;

/**
 * Session Bean implementation class SuiviCommandeDao
 */
@Stateless
public class SuiviCommandeDao implements SuiviCommandeDaoLocal,SuiviCommandeDaoRemote {

     
    public SuiviCommandeDao() {  }

    @PersistenceContext(unitName = "Myecommerce")
   	private EntityManager em;
    
    
    
    
    public List<SuiviCommande> getOffersByProduct( int idpr){
    	List<SuiviCommande> listing = null; 
 		
    	    String sql = "SELECT u  FROM SuiviCommande u  WHERE u.idpr=:arg1    ";        
 		Query query = this.em.createQuery(sql);	 
 		query.setParameter("arg1", idpr);
 		
 		 	 
 		 try {
 			listing = query.getResultList();
 		  return listing ; 
 		 }catch(Exception e ) {
			 return null;
		 }
 		   
 	}
    
    
    public List<SuiviCommande> getOffersByUser( int idus){
    	List<SuiviCommande> listing = null; 
 		
    	    String sql = "SELECT u  FROM SuiviCommande u  WHERE u.idus=:arg1    ";        
 		Query query = this.em.createQuery(sql);	 
 		query.setParameter("arg1", idus);
 		
 		 	 
 		 try {
 			listing = query.getResultList();
 		  return listing ; 
 		 }catch(Exception e ) {
			 return null;
		 }
 		   
 	}
    
    
    
    @Override
    @Transactional 
    public void updateprice( int id , int price) {
    	
     	SuiviCommande p = em.find(SuiviCommande.class, id);
     	
		if(p!= null){
			p.setprice(price);
			this.em.merge(p);
		}
    	 
    }
    
    
    @Override
    @Transactional 
    public void update( int id , int state) {
    	
     	SuiviCommande p = em.find(SuiviCommande.class, id);
     	
		if(p!= null){
			p.setstate(state);
			this.em.merge(p);
		}
    	
        
    }
    
    
    @Override
    @Transactional 
    public void delete(final int id) {
    	
    
    	SuiviCommande p = em.find(SuiviCommande.class, id);
    		if(p!= null){
    		 	 em.remove(p);
    		}
    	
    }
    
    @Override
    @Transactional 
    public  SuiviCommande create ( SuiviCommande t) {
        this.em.persist(t);
        return t;
    }
    
    
    
    
}
