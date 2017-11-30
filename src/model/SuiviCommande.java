package model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="SuiviCommande") 
public class SuiviCommande implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="IDCM")
	private int idcm;
	
	@Column(name="IDUS")
	private int idus;
	
	@Column(name="DATE")
	private LocalDate date;
	
	@Column(name="PRICE")
	private int price;
	
	
	@Column(name="STATE")
	private int state;
	
	
	public SuiviCommande() {}
	public SuiviCommande( int idcm, int idus, LocalDate date, int price ,int state  ) {
		this.idcm = idcm  ;
		this.idus = idus; 
		this.date = date ;
		this.price = price ; 
		this.state = state ; 
					
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
	
	
	
}
