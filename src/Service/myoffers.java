package Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import EJBLOCAL.ProduitDao;
import EJBLOCAL.SuiviCommandeDao;
import model.Produit;
import model.SuiviCommande;



@WebServlet("/myoffers")
public class myoffers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    @EJB
	private SuiviCommandeDao data;
    @EJB
    private ProduitDao dataV;

    public myoffers() {  super();  }

    
    
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    response.setContentType("application/json");
			response.setHeader("Cache-Control", "nocache");
	        response.setCharacterEncoding("utf-8");
	        JSONObject obj = new JSONObject();
			JSONArray arrayjson = new JSONArray();
			List<SuiviCommande> Offers ; 
			int choice =0; 
			int ID = 0; 
			int ST = 0; 
			int price = 0; 
			// 1> create 
			// 2> update 
			// 3> delete 
		    // 4> getlist offers by product
			
			
			if(request.getParameter("choice") != null) { choice = Integer.parseInt(request.getParameter("choice")) ; }
			
			switch( choice ) {
			case(0) : 
				// Nouvel Ajout (1)
				int idcm = Integer.parseInt(request.getParameter("idcm"));
				int idus = Integer.parseInt(request.getParameter("idus"));
				int idpr = Integer.parseInt(request.getParameter("idpr"));
				price = Integer.parseInt(request.getParameter("price"));
				data.create(new SuiviCommande(idcm,idus,idpr,LocalDate.now(),price,0)); 
				
				// http://127.0.0.1:8080/JPAEJB/myoffers?choice=0&idcm=1&idus=1994&idpr=89&price=45
			break;
			
			case(1) : 
				
				ID = Integer.parseInt(request.getParameter("ID")) ;
		        price = Integer.parseInt(request.getParameter("PR")) ;
		
		    data.updateprice(ID, price);
				
			break; 
			
			case(2) : 
				ID = Integer.parseInt(request.getParameter("ID")) ;
			    ST = Integer.parseInt(request.getParameter("ST")) ;
			
			    data.update(ID, ST);
				
			break; 
			
			case(3) : 
			
			ID = Integer.parseInt(request.getParameter("ID")) ;
			 data.delete(ID);
				
			break; 
			
			case(4) :  // Acheteur
				ID = Integer.parseInt(request.getParameter("ID")) ;
			
				Offers = data.getOffersByProduct(ID) ;
			if( Offers !=null  ) {  
				int count = Offers.size(); 
				System.out.println("nombre de commandes sur ce produit : "+count);
				//ajouter count ici permet de le separer des offres (au cas tu ne veux recuperer que ca)
		//Je le mets en commentaire vu que tu le voulais à l interieur de l affichage des offres
				//arrayjson.add(count);
				
				for(SuiviCommande offre : Offers ) { 
					//Affichage de count dans chaque offre, si tu veux l enlever il te suffit d enlever le parametre
					arrayjson.add(offre.toJson(count)); 
				}
				
			 response.getWriter().append(arrayjson.toString().replace("\"{", "{").replace("}\"", "}").replace("\\", "")  );	
			
			}else { response.getWriter().append("[]");	  }
				
			// Test Navigateur : http://127.0.0.1:8080/JPAEJB/myoffers?choice=4&ID=89
				
			break; 
			
			case(5) :  // Acheteur
				ID = Integer.parseInt(request.getParameter("ID")) ;
			
				Offers = data.getOffersByUser(ID) ;
			if( Offers !=null  ) {  
			
				for(SuiviCommande offre : Offers ) { 
					Produit current_prod = dataV.getProductInfo(offre.getIdpr());
					
					arrayjson.add(offre.toJson(current_prod)); 
				}
				
			 response.getWriter().append(arrayjson.toString().replace("\"{", "{").replace("}\"", "}").replace("\\", "")  );	
			
			}else {    response.getWriter().append("[]");	  }
				
			// Test navigateur : 127.0.0.1:8080/JPAEJB/myoffers?choice=5&ID=1994	
				
			break; 
			
			}

	   
	 
	 }

	 
	 
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doGet(request, response);
	}

}
