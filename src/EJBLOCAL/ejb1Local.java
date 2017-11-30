package EJBLOCAL;

import java.util.List;

import javax.ejb.Local;

import model.Formation;

@Local
public interface ejb1Local {

	public String call();
	public List<Formation> getFormations() ;
	
	
}
