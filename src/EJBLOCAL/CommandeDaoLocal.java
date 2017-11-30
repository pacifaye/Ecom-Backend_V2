package EJBLOCAL;

import javax.ejb.Local;

import model.Commande;

@Local
public interface CommandeDaoLocal {
	
	
	 public Commande update(final Commande t) ;
	 public void delete(final int id);
	 public Commande create (Commande t);
}
