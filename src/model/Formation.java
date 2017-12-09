package model;

import java.io.Serializable;
import javax.persistence.*;

import org.json.simple.JSONObject;


/**
 * The persistent class for the Formation database table.
 * 
 */
@Entity
@NamedQuery(name="Formation.findAll", query="SELECT f FROM Formation f")
public class Formation implements Serializable {
	private static final long serialVersionUID = 1L;
	
	 
	@Id
	@GeneratedValue
	@Column(name="id") 
	private int id;
	@Column(name="theme")
	private String theme;
	

	public Formation() { }
	
	
	public Formation ( int id, String theme) {
	    this.id = id ;
		this.theme=theme;
	}
	
	public Formation (   String theme) {
	 
		this.theme=theme;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTheme() {
		return this.theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	public String toJson() {
		
		JSONObject obj = new JSONObject();
		obj.put("id", this.getId());
		obj.put("theme", this.getTheme());
	   
		return obj.toJSONString()	;
	}
	 

}