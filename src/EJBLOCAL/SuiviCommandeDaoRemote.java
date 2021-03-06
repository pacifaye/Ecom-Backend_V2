package EJBLOCAL;

import java.util.List;

import javax.ejb.Remote;

import model.SuiviCommande;

@Remote
public interface SuiviCommandeDaoRemote {

	public List<SuiviCommande> getOffersByProduct( int idpr);
	 public List<SuiviCommande> getOffersByUser( int idus);
	 public  SuiviCommande create ( SuiviCommande t) ;
	 public void delete(final int id);
	 public void update( int id, int state ) ;
	 public void updatePrice( int id , int price) ;	
}
