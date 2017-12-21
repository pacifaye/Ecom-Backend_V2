package EJBLOCAL;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import model.Commande;
import model.Produit;
import model.SuiviCommande;

/**
 * Session Bean implementation class CommandeDao
 */
@Stateless
public class CommandeDao implements CommandeDaoLocal,CommandeDaoRemote {

	
    
    public CommandeDao() { }

    @PersistenceContext(unitName = "Myecommerce")
   	private EntityManager em;
    
    
  
    
    
    
    @Override
    @Transactional 
    public Commande update(final Commande t) {
        return this.em.merge(t);
    }
    
    
    @Override
    @Transactional 
    public void delete(final int id) {
      	Commande p = em.find(Commande.class, id);
		if(p!= null){
		 	 em.remove(p);
		}
	
    }
    
    @Override
    @Transactional 
    public Commande create (Commande t) {
        this.em.persist(t);
        return t;
    }
    
    
    
    
    
}
