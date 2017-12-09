package Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
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
		JSONArray arrayjson = new JSONArray();
		List<Produit> produits ; 
		
		
		
		Produit produit; 
		int choice =0; 
		int ID = 0; 
		String title ="";
	    String desc = "";
	    String dt ="";
	    String linkpicture="";
	    int idus=0;
	    int codepostale= 0; 
		// 1> create 
		// 2> update 
		// 3> delete 
		// 4> getInfo 
		// 5> getlist product 
		// 6> getlist product by user
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
         
		LocalDate localDate ;
		
		
		
		if(request.getParameter("choice") != null) { choice = Integer.parseInt(request.getParameter("choice")) ; }
		
		switch( choice ) {
		
		case(0) : 
			
			idus= Integer.parseInt(request.getParameter("idus")) ;
			title = request.getParameter("title") ;
	        desc = request.getParameter("desc") ;
	        dt = request.getParameter("date") ;
	        localDate = LocalDate.parse(dt, formatter);
	        codepostale=Integer.parseInt(request.getParameter("codep")) ;
	        linkpicture= request.getParameter("link") ;;
	     produit = new Produit(idus,title,desc,linkpicture,0,0,codepostale, localDate ) ; 
			
	         data.create(produit);
			
			break; 
		   case(1) : 
			   // data.update(produit);
		    	ID = Integer.parseInt(request.getParameter("ID")) ;
		     data.updateDon(ID);
		    
			break;
		    case(2) : 
			   // data.update(produit);
		    	ID = Integer.parseInt(request.getParameter("ID")) ;
		    	title = request.getParameter("title") ;
		    	desc = request.getParameter("desc") ;
		    	dt = request.getParameter("date") ;
			
		    System.out.println(ID+title+desc+dt);
		    data.update(ID, title, desc, dt);
		    
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
				obj.put("expiration_date", produit.getExpirationdate().toString() );
				
			}else {
				obj.put("idus", 0);
				obj.put("idpr", 0);
				obj.put("title", "inconnu");
				obj.put("description", "inconnu");
				obj.put("linkpicture", "error.jpg");
				obj.put("pricemin", 0);
				obj.put("pricemax", 0 );
				obj.put("zipcode", 0 );
				obj.put("expiration_date", "inconnu" );
			}
				
				response.getWriter().append(obj.toString());	
				
			break;
			
		case(5) : 
			
			
			    produits = data.getProducts(); 
		if( produits !=null  ) {  
		
			for(Produit Pr : produits ) { arrayjson.add(Pr.toJson()); }
		 response.getWriter().append(arrayjson.toString().replace("\"{", "{").replace("}\"", "}").replace("\\", "")  );	
		
		}else { response.getWriter().append("[]");	  }
		 
		 break;
			
			
			case(6) : 
				ID = Integer.parseInt(request.getParameter("ID")) ;
				
			
			      produits = data.getProductsByUser(ID);			
				  
				  if( produits !=null  ) {  
		 
		for(Produit Pr : produits ) { arrayjson.add(Pr.toJson()); }
		response.getWriter().append(arrayjson.toString().replace("\"{", "{").replace("}\"", "}").replace("\\", "")  );	
		
				  }else { response.getWriter().append("[]");	  }
		
			 break;	
			
		
		}
		
		

		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	
	
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	doGet(request, response);
	}

}
