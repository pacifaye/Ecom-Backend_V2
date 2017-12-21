package EJBLOCAL;

import javax.ejb.Remote;

import model.Utilisateur;

@Remote
public interface UtilisateurDaoRemote {

	public Utilisateur getUserInfo(int idUser);
	
}
