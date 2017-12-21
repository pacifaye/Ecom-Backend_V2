package EJBLOCAL;

import java.util.List;

import javax.ejb.Local;

import model.Produit;

@Local
public interface ProduitDaoLocal {
	 public Produit getProductInfo(int ID);
	 public List<Produit> getProducts();
	 public void update( int id , String title, String Description, String date  );
	 public void delete(final int id) ;
	 public Produit create(Produit t);
	 public void updateDon( int id  ) ;
	 public List<Produit> getProductsByUser(int iD);
	 
	 
}
