package EJBLOCAL;

import javax.ejb.Local;

import model.Commande;
import model.Utilisateur;



@Local
public interface UtilisateurDaoLocal {
	
	public Utilisateur getUserInfo(int idUser);
		
}
