package EJBLOCAL;

import javax.ejb.Local;

@Local
public interface PopulateBeanLocal {
	
	public void createUser(int nbUsers);
	public void createProducts(int nbUsers, int nbProd);
	public void createCommands(int nbCom);

}
