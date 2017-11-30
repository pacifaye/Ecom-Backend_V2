package EJBLOCAL;

import java.util.List;

import javax.ejb.Local;

import model.Produit;

@Local
public interface ProduitDaoLocal {
	 public Produit getProductInfo(int ID);
	 public List<Produit> getProducts();
	 public Produit update(final Produit t);
	 public void delete(final int id) ;
	 public Produit create(Produit t);
	 
}
