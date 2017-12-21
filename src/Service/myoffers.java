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
import EJBLOCAL.SuiviCommandeDaoRemote;
import model.Produit;
import model.SuiviCommande;



@WebServlet("/myoffers")
public class myoffers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    @EJB
	private SuiviCommandeDaoRemote data;

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
			int Sidus = 0; 
			int Sidpr = 0; 
			int Sprice = 0; 
			// 1> create 
			// 2> update 
			// 3> delete 
		    // 4> getlist offers by product
			
			
			if(request.getParameter("choice") != null) { choice = Integer.parseInt(request.getParameter("choice")) ; }
			
			switch( choice ) {
			case(0) : 
			
				Sidus= Integer.parseInt(request.getParameter("idus")) ;
			    Sidpr= Integer.parseInt(request.getParameter("idpr")) ;
			    Sprice= Integer.parseInt(request.getParameter("price")) ;
			     
				SuiviCommande dt = new SuiviCommande(1,Sidus, Sidpr,LocalDate.now(), Sprice,0);
			    data.create(dt);
			 
			break;
			
			case(1) : 
				
				ID = Integer.parseInt(request.getParameter("ID")) ;
		        price = Integer.parseInt(request.getParameter("PR")) ;
		
		    data.updatePrice(ID, price);
				
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
			
				for(SuiviCommande offre : Offers ) { arrayjson.add(offre.toJson()); }
			 response.getWriter().append(arrayjson.toString().replace("\"{", "{").replace("}\"", "}").replace("\\", "")  );	
			
			}else { response.getWriter().append("[]");	  }
				
				
				
			break; 
			
			case(5) :  // vendeur
				ID = Integer.parseInt(request.getParameter("ID")) ;
			
				Offers = data.getOffersByUser(ID) ;
			if( Offers !=null  ) {  
			
				for(SuiviCommande offre : Offers ) { arrayjson.add(offre.toJson()); }
			 response.getWriter().append(arrayjson.toString().replace("\"{", "{").replace("}\"", "}").replace("\\", "")  );	
			
			}else {    response.getWriter().append("[]");	  }
				
				
				
			break; 
			
			}

	   
	 
	 }

	 
	 
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doGet(request, response);
	}

}
