package EJBLOCAL;

import javax.ejb.Local;

import model.Utilisateur;

@Local
public interface ConnectionLocal {


	public boolean isAuthGood(String log, String pw);
	public Utilisateur getUserInfo(String log); 
	public void SubscribeRequest(Utilisateur u);
	
}
