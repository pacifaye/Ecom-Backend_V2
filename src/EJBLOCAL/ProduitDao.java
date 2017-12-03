package EJBLOCAL;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import model.Formation;
import model.Produit;
import model.ProduitCommande;
import model.Utilisateur;

/**
 * Session Bean implementation class ProduitDao
 */
@Stateless
@LocalBean
public class ProduitDao implements ProduitDaoLocal {
    
	public ProduitDao() {  }
    
    
    @PersistenceContext(unitName = "Myecommerce")
   	private EntityManager em;
 
    
    @Override
    public List<Produit> getProducts(){
 		Produit produit = null;
 		 
 		String sql = "SELECT u FROM Produit u  ";
 		Query query = this.em.createQuery(sql);	 
 		 
 	   try {
 		List<Produit> produits = query.getResultList();
 		   return produits ; 
 		}catch(Exception e ) { return null; }
 		 
 	}
    
    
    public List<Produit> getProductsByUser( int idus){
    	List<Produit> produits = null; 
 		//String sql = "SELECT u  (SELECT  COUNT(s.idpr) FROM SuiviCommande s ) as count FROM Produit u  WHERE u.idus=:arg1    ";        
    		String sql = "SELECT u  FROM Produit u  WHERE u.idus=:arg1    ";        
 		Query query = this.em.createQuery(sql);	 
 		query.setParameter("arg1", idus);
 		
 		/*List<Produit> l = query.getResultList();
 		for(Produit p:l){
 		      System.out.println(p.getTitle() );
 		    }
 		*/
 		//System.out.println(query.getResultList().toString());
 		 
 		 try {
 		  produits = query.getResultList();
 		  return produits ; 
 		 }catch(Exception e ) {
			 return null;
		 }
 		   
 	}
    
    
    
    @Override
    public Produit getProductInfo(int ID){
		Produit produit = null;
		 
		String sql = "SELECT u FROM Produit u WHERE u.idpr=:arg1  ";
		Query query = this.em.createQuery(sql);	 
		query.setParameter("arg1", ID); 
		
		 try {
			 produit = (Produit) query.getSingleResult();
			 return produit ; 
		 }catch(Exception e ) {
			 return null;
		 }
		 
		 
	}
    
    
    @Override
    @Transactional 
    public Produit update(final Produit t) {
        return this.em.merge(t);
    }
    
    
    @Override
    @Transactional 
    public void delete(final int id) {
      //  this.em.remove(this.em.getReference(type, id));
    }
    
    @Override
    @Transactional 
    public Produit create(Produit t) {
        this.em.persist(t);
        return t;
    }
    

}
