package Service;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import EJBLOCAL.Connection;
import EJBLOCAL.ProduitDao;
import model.Formation;
import model.Produit;

/**
 * Servlet implementation class product
 */
@WebServlet("/product")
public class product extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public product() {  super(); }

    
    @EJB
	private ProduitDao data;
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "nocache");
        response.setCharacterEncoding("utf-8");
         
		JSONObject obj = new JSONObject();
		
		
		Produit produit; 
		int choice =0; 
		int ID = 0; 
		// 1> create 
		// 2> update 
		// 3> delete 
		// 4> getInfo 
		// 5> getlist
		
		if(request.getParameter("choice") != null) { choice = Integer.parseInt(request.getParameter("choice")) ; }
		
		switch( choice ) {
		
		case(1) : 
			  produit = new Produit() ; 
			
			data.create(produit);
			
			break; 
		case(2) : 
			//Update que quelques champs
			  produit = new Produit() ; 
		    data.update(produit);
			 
			break;
		
		case(3) : 
			 ID = Integer.parseInt(request.getParameter("ID")) ;
			 data.delete(ID);
			
			break;	
		case(4) : 
			
			 ID = Integer.parseInt(request.getParameter("ID")) ;
			 produit = data.getProductInfo(ID);
			
			if( produit !=null  ) {    
				obj.put("idus", produit.getIdus());
				obj.put("idpr", produit.getIdpr());
				obj.put("title", produit.getTitle());
				obj.put("description", produit.getDescription());
				obj.put("linkpicture", produit.getlinkpicture());
				obj.put("pricemin", produit.getPriceMin());
				obj.put("pricemax", produit.getPriceMax());
				obj.put("zipcode", produit.getZipcode());
				obj.put("expiration_date", produit.getExpirationdate());
				
			}else {
				obj.put("idus", null);
				obj.put("idpr", null);
				obj.put("title", null);
				obj.put("description", null);
				obj.put("linkpicture", null);
				obj.put("pricemin", null);
				obj.put("pricemax", null );
				obj.put("zipcode", null );
				obj.put("expiration_date", null);
			}
				
				response.getWriter().append(obj.toString());	
				
			break;
			
		case(5) : 
			
			List<Produit> produits = data.getProducts(); 
		
		int i=1; 
		for(Produit Pr : produits ) {
		obj.put(i, Pr.toJson() );	
		i++; 	
			}
			
		response.getWriter().append(obj.toString());	
			break;
		
		}
		
		

		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	
	
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	doGet(request, response);
	}

}
