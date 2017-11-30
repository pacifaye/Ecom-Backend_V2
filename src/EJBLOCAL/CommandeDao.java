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

/**
 * Session Bean implementation class CommandeDao
 */
@Stateless
@LocalBean
public class CommandeDao implements CommandeDaoLocal {

	
    
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
      //  this.em.remove(this.em.getReference(type, id));
    }
    
    @Override
    @Transactional 
    public Commande create (Commande t) {
        this.em.persist(t);
        return t;
    }
    
    
    
    
    
}
