package model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.simple.JSONObject;






public class ProduitCommande implements Serializable {
  
	
	private static final long serialVersionUID = 1L;

	  
	private int idpr;
	private int idus;
	private String title;
	private int pricemin;
	private int pricemax;
	private int count;
	 
	
	 

	public ProduitCommande(int idpr, int idus, String title, int pricemin,int pricemax,int count){
		 this.idpr= idpr; 
		 this.idus= idus; 
		 this.title=title; 
		 this.pricemin= pricemin; 
	    	this.pricemax= pricemax; 
		this.count= count ; 
		
	}
	
	 
	public ProduitCommande() { super(); }
	
	
	
	
	
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
	
	
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String Title) {
		this.title = Title;
	}
	
	 
	 
	
	public int getPriceMin() {
		return this.pricemin;
	}

	public void setPriceMin(int price) {
		this.pricemin= price;
	}
	
	public int getPriceMax() {
		return this.pricemax;
	}

	public void setPriceMax(int price) {
		this.pricemax= price;
	}
	
	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count= count;
	}	 
	 
	
	public String toJson() {
		
		JSONObject obj = new JSONObject();
		obj.put("idus", this.getIdus());
		obj.put("idpr", this.getIdpr());
		obj.put("title", this.getTitle());
		obj.put("pricemin", this.getPriceMin());
		obj.put("pricemax", this.getPriceMax());
		obj.put("count", this.getPriceMax());
		
		return obj.toString()	;
	}
	 
}
