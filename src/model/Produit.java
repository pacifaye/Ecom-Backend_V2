package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.json.simple.JSONObject;





@Entity
@Table(name="Produit") 
public class Produit implements Serializable {
 
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name="IDPR")
	private int idpr;
	
	@Column(name="IDUS")
	private int idus;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="CATEG")
	private String categ;
	
	
	@Column(name="LINKPICTURE")
	private String linkpicture;
	
	@Column(name="PRICEMIN")
	private int pricemin;
	
	@Column(name="PRICEMAX")
	private int pricemax;
	
	@Column(name="ZIPCODE")
	private int zipcode;
	
	@Column(name="EXPIRATION_DATE")
	private LocalDate expiration_date;
	
	 
	@OneToMany(targetEntity=SuiviCommande.class )
    private Collection<SuiviCommande> suivi = new ArrayList<SuiviCommande>();
    
	
	public Produit(int idpr, String title , String description , LocalDate date){
		 this.idpr= idpr; 
		 this.title=title; 
		 this.description= description; 
		 this.expiration_date=date; 
		
	}
	

	public Produit( int idus, String title,String description,String Categ, String linkpicture, int pricemin,int pricemax,int zipcode,LocalDate date){
		// this.idpr= idpr; 
		 this.idus= idus; 
		 this.title=title; 
		 this.linkpicture= linkpicture;
		 this.description= description; 
		 this.categ = Categ; 
		this.pricemin= pricemin; 
		this.pricemax= pricemax; 
		this.zipcode = zipcode; 
		this.expiration_date=date; 
		
	}
	
	 
	public Produit() {
		super();
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
	
	
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String Title) {
		this.title = Title;
	}
	
	public String getDescription() {
		return this.description;
		}

	public void setDescription(String desc) {
		this.description = desc;
	}
	
	public String getCateg() {
		return this.categ;
	}

	public void setCateg(String Categ) {
		this.categ = Categ;
	}
	
	public String getlinkpicture() {
		return this.linkpicture;
	}

	public void setlinkpicture(String linkpic) {
		this.linkpicture = linkpic;
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
	
	public int getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(int zip) {
		this.zipcode= zip;
	}
	
	
	public LocalDate getExpirationdate() {
		return this.expiration_date;
	}
	
	public void setExpirationdate(LocalDate savedate) {
		this.expiration_date = savedate;
	}
	
	public String toString() {
		return this.getIdpr() + "-" + this.suivi.size(); 
	}
	
	public String toJson() {
		
		
		LocalDate today = LocalDate.now();
		LocalDate yesterday = this.getExpirationdate();
	    
		int diff = (int) ChronoUnit.DAYS.between( today.atStartOfDay() , yesterday.atStartOfDay());
		 
		   
		JSONObject obj = new JSONObject();
		obj.put("idus", this.getIdus());
		obj.put("idpr", this.getIdpr());
		obj.put("title", this.getTitle());
		obj.put("description", this.getDescription());
		obj.put("linkpicture", this.getlinkpicture());
		obj.put("pricemin", this.getPriceMin());
		obj.put("pricemax", this.getPriceMax());
		obj.put("zipcode", this.getZipcode());
		obj.put("expiration_date", this.getExpirationdate().toString());
		obj.put("diff", diff);
		obj.put("categ", this.getCateg());
	   
		return obj.toString()	;
	}


	public String toJson(int count) {
		
		LocalDate today = LocalDate.now();
		LocalDate yesterday = this.getExpirationdate();
	    
		int diff = (int) ChronoUnit.DAYS.between( today.atStartOfDay() , yesterday.atStartOfDay());
		 
		   
		JSONObject obj = new JSONObject();
		obj.put("NbOffres", count);
		obj.put("idus", this.getIdus());
		obj.put("idpr", this.getIdpr());
		obj.put("title", this.getTitle());
		obj.put("description", this.getDescription());
		obj.put("linkpicture", this.getlinkpicture());
		obj.put("pricemin", this.getPriceMin());
		obj.put("pricemax", this.getPriceMax());
		obj.put("zipcode", this.getZipcode());
		obj.put("expiration_date", this.getExpirationdate().toString());
		obj.put("diff", diff);
		obj.put("categ", this.getCateg());
	   
		return obj.toString()	;
	}
	 
}
