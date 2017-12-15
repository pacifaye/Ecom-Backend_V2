package EJBLOCAL;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Produit;
import model.Utilisateur;

import org.springframework.transaction.annotation.Transactional;

import Enumerations.Products;
import Enumerations.Users;

/**
 * Session Bean implementation class PopulateBean
 */
@Stateless
public class PopulateBean implements PopulateBeanLocal {
    

    @PersistenceContext(unitName = "Myecommerce")
   	private EntityManager em;

	@Override
	@Transactional
	public void createUser(int nbUsers) {
		int max = 30;
		String nom,prenom,email;
		int phone;
		Users S_User; // Selected User
			// Creer une liste contenant des nombres de 1 à 30
		ArrayList<Integer> listNumb = new ArrayList<Integer>();
	        for (int i=1; i < max+1; i++) {
	            listNumb.add(new Integer(i));
	        }
	    // Utiliser la fonction shuffle pour melanger la liste 
	    Collections.shuffle(listNumb);   
	     
	    // Generer les utilisateurs 
		if(nbUsers <= max){
			for(int i = 0; i<nbUsers; i++){
				int UserNum = listNumb.get(i);
				System.out.println("User used : "+UserNum);
				String User = "User"+UserNum;
				
				S_User = Users.valueOf(User);
				
				nom = S_User.getName();
				prenom = S_User.getFname();
				email = S_User.getEmail();
				phone = Integer.parseInt(S_User.getPhone());
				
				Utilisateur u  = new Utilisateur(nom, prenom, email, phone, LocalDate.now(),"azerty");
				System.out.println("User added ("+UserNum+"): "+nom+" "+prenom+" "+email);
				em.persist(u);
			}
		}else{
			System.out.println("Le nombre d utilisateurs doit etre <= 30");
		}	
	}

	@Override
	@Transactional
	public void createProducts(int nbUsers, int nbProd) {
		int maxProd = 50;
		Random rm = new Random();
		Products prod;
		
		// Creer une liste contenant des nombres de 1 à MaxProduit Predefinis
			ArrayList<Integer> listProd = new ArrayList<Integer>();
			for(int i=1; i < maxProd+1; i++) {
			   
				listProd.add(new Integer(i));
			}
			
		// Utiliser la fonction shuffle pour melanger la liste 
		   Collections.shuffle(listProd);  
			
		if(nbProd <= maxProd){
			for(int i = 0; i < nbProd; i++){
				int RandomUser = rm.nextInt(nbUsers - 1 + 1) + 1;
				int RandomProd = listProd.get(i);
				String ProdName = "Product"+RandomProd;
				
				System.out.println("User"+RandomUser+" associated to product"+RandomProd);
				prod = Products.valueOf(ProdName);
				
				String title =  prod.getTitle();
				String description = prod.getDescription();
				String linkpicture = prod.getLink();
				int pricemin = Integer.parseInt(prod.getPrixMin());
				int pricemax = Integer.parseInt(prod.getPrixMax());
				int zipcode = Integer.parseInt(prod.getCodePostal());
				
				Produit p = new Produit(RandomUser, title, description, linkpicture, pricemin, pricemax, zipcode, LocalDate.now());
				System.out.println(p.toString());
				em.persist(p);
			}
		}
	}

	@Override
	@Transactional
	public void createCommands(int nbCom) {
		
		
	}
    
    
  
    
    
   
    
    

}
