package model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.json.simple.JSONObject;


@Entity
//@IdClass( SCIdentifier.class) 
@Table(name="SuiviCommande") 
public class SuiviCommande implements Serializable  {

	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="IDSC")
	private int idsc;
	
	@Column(name="IDCM")
	private int idcm;
	
	@Column(name="IDUS")
	private int idus;
	 
	@Column(name="IDPR")
	private int idpr;
	
	@Column(name="DATE")
	private LocalDate date;
	
	@Column(name="PRICE")
	private int price;
	
	
	@Column(name="STATE")
	private int state;
	
	
	public SuiviCommande() {}
	public SuiviCommande(int idsc, int idcm, int idus, int idpr,  LocalDate date, int price ,int state  ) {
		this.idsc = idsc;
		this.idcm = idcm  ;
		this.idus = idus; 
		this.idpr= idpr; 
		this.date = date ;
		this.price = price ; 
		this.state = state ; 
	}
	
	public int getIdsc() {
		return this.idsc;
	}

	public void setIdsc(int idsc) {
		this.idsc = idsc;
	}
	
	public int getIdpr() {
		return this.idpr;
	}

	public void setIdpr(int idpr) {
		this.idpr = idpr;
	}
	
	public int getIdcm() {
		return this.idcm;
	}

	public void setIdcm(int idcm) {
		this.idcm = idcm;
	}
	
	
	public int getIdus() {
		return this.idus;
	}

	public void setIdus(int idus) {
		this.idus = idus;
	}
	
 
	public int getprice() {
		return this.price;
	}

	public void setprice(int price) {
		this.price = price;
	}
	
	public int getstate() {
		return this.state;
	}

	public void setstate(int state) {
		this.state = state;
	}
	
	
	
	
	public LocalDate getdate() {
		return this.date;
	}
	
	public void setdate(LocalDate savedate) {
		this.date = savedate;
	}
	
	
	public String toJson() {
		
		JSONObject obj = new JSONObject();
		obj.put("idsc", this.getIdsc());
		obj.put("idus", this.getIdus());
		obj.put("idpr", this.getIdpr());
		obj.put("idcm", this.getIdcm());
		obj.put("data", this.getdate().toString());
		obj.put("price", this.getprice());
		obj.put("state", this.getstate());
		
		
		return obj.toString()	;
	}
	
	
	
}
