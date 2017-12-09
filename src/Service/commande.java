package Service;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import EJBLOCAL.CommandeDao;
import EJBLOCAL.ProduitDao;

/**
 * Servlet implementation class commande
 */
@WebServlet("/commande")
public class commande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public commande() { super(); }
    @EJB
   	private CommandeDao data;
    
    
	 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
	 		response.setContentType("application/json");
			response.setHeader("Cache-Control", "nocache");
	        response.setCharacterEncoding("utf-8");
	         
			JSONObject obj = new JSONObject();
			
			int choice =0; 
			int ID = 0; 
			
			// 1> create 
			// 2> update 
			// 3> delete 
			// 4> getInfo 
			if(request.getParameter("choice") != null) { choice = Integer.parseInt(request.getParameter("choice")) ; }
			
			switch( choice ) {
			case(1) : 
				
				
			break;
			
			case(2) : 
				
				
			break; 
			
			case(3):
			
				
				
			break;
			
			case(4):
			
			
				response.getWriter().append(obj.toString());	
			break; 
			}
			
			
	 		
	 		
	 		
	 	 
	}

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doGet(request, response);
	 }

}
