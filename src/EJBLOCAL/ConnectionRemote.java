package EJBLOCAL;

import javax.ejb.Remote;

import model.Utilisateur;

@Remote
public interface ConnectionRemote {

	public boolean isAuthGood(String log, String pw);
	public Utilisateur getUserInfo(String log); 
	public void SubscribeRequest(Utilisateur u);
}
