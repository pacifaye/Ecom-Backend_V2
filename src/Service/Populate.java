package Service;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import EJBLOCAL.PopulateBean;
import EJBLOCAL.PopulateBeanLocal;
import EJBLOCAL.ProduitDao;

@WebServlet("/populate")
public class Populate extends HttpServlet {
	int nbUsers = 0, nbProd = 0, nbCommands = 0;
	
	@EJB
	private PopulateBeanLocal data;
	
	public Populate() {super();} 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "nocache");
        response.setCharacterEncoding("utf-8");
         
		JSONObject obj = new JSONObject();
		JSONArray arrayjson = new JSONArray();
		
	
		if(request.getParameter("nbUser") != null)
			nbUsers = Integer.parseInt(request.getParameter("nbUser"));
		
		if(request.getParameter("nbProd") != null)
			nbProd = Integer.parseInt(request.getParameter("nbProd"));
		
		if(request.getParameter("nbCom") != null)
			nbCommands = Integer.parseInt(request.getParameter("nbCom"));
		
		// Phase de Generation automatique
		
		if(nbUsers != 0){
			data.createUser(nbUsers);
		
			if(nbProd != 0){
				data.createProducts(nbUsers,nbProd);
			
				if(nbCommands != 0)
					data.createCommands(nbCommands);
			}		
		}
		
		// Test Navigateur : http://127.0.0.1:8080/JPAEJB/populate?nbUser=20&nbProd=100
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	doGet(request, response);
	}

}
