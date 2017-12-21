package EJBLOCAL;

import javax.ejb.Remote;

import model.Commande;

@Remote
public interface CommandeDaoRemote {

	 public Commande update(final Commande t) ;
	 public void delete(final int id);
	 public Commande create (Commande t);
}
