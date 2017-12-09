package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.simple.JSONObject;


@Entity
@Table(name="Commande") 
public class Commande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="IDCM")
	private int idcm;
	
	@Column(name="IDPR")
	private int idpr;
	
	@Column(name="IDUS")
	private int idus;
	
	@Column(name="PRICE")
	private int price;
	
	
	public Commande() {}
	
	public Commande( int idcm,int idpr,int idus,  int price  ) {
		
		this.idcm = idcm ; 
		this.idpr = idpr; 
		this.idus = idus; 
		this.price = price; 
		
	}
	
	public int getIdpr() {
		return this.idpr;
	}

	public void setIdpr(int idpr) {
		this.idpr = idpr;
	}
	
	public int getIdus() {
		return this.idus;
	}

	public void setIdus(int idus) {
		this.idus = idus;
	}
	
	public int getIdcm() {
		return this.idcm;
	}

	public void setIdcm(int idcm) {
		this.idcm = idcm;
	}
	
	
	
	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price= price;
	}
	
	
	
	public String toJson() {
		
		JSONObject obj = new JSONObject();
		obj.put("idus", this.getIdus());
		obj.put("idpr", this.getIdpr());
		obj.put("idcm", this.getIdcm());
		obj.put("price", this.getPrice());
		  
		return obj.toJSONString();
	}
	
	
	
}






