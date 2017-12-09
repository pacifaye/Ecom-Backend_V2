package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

 
public class SCIdentifier implements Serializable {

	 
	 
  
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idpr;
		result = prime * result + idus;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SCIdentifier other = (SCIdentifier) obj;
		if (idpr != other.idpr)
			return false;
		if (idus != other.idus)
			return false;
		return true;
	}

	private int idus;
	 
	private int idpr;
	
	public SCIdentifier() { super();}
	
	public SCIdentifier(    int idpr , int idus ) {
		 super(); 
		this.idus = idus ; 
		this.idpr=idpr ; 
	 }


	 
}
