package EJBLOCAL;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public void update( int id , String title, String Description, String date  ) {
        Produit p = em.find(Produit.class, id);
     	 if(p!= null){
    			p.setTitle(title);
    	     	p.setDescription(Description);
    	     	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
    	        LocalDate localDate = LocalDate.parse(date, formatter);
    	        p.setExpirationdate(localDate);
    		 	this.em.merge(p);
    		}
   
    }
    
    @Override
    @Transactional 
    public void updateDon( int id  ) {
        Produit p = em.find(Produit.class, id);
     	if(p!= null){
     		p.setPriceMax(0);
         	p.setPriceMin(0);
        		 this.em.merge(p);
    		}
   
    }
    
    
    @Override
    @Transactional 
    public void delete(final int id) {
    	Produit p = em.find(Produit.class, id);
		if(p!= null){
			System.out.println("Produit à supprimer trouvé");
			 
			em.remove(p);
		}
    }
    
    
    
    
    
    @Override
    @Transactional 
    public Produit create(Produit t) {
        this.em.persist(t);
        return t;
    }
    

}
