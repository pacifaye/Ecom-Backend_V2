package EJBLOCAL;

import java.util.List;

import javax.ejb.Local;

import model.SuiviCommande;

@Local
public interface SuiviCommandeDaoLocal {
	 public List<SuiviCommande> getOffersByProduct( int idpr);
}
