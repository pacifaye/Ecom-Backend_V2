package Service;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import EJBLOCAL.ConnectionRemote;
import EJBLOCAL.UtilisateurDao;
import model.Utilisateur;
import EJBLOCAL.Connection;

/**
 * Servlet implementation class users
 */
@WebServlet("/users")
public class users extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public users() {  super();  }


    @EJB
   	private ConnectionRemote data;
    
     
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "nocache");
        response.setCharacterEncoding("utf-8");
		
        JSONObject obj = new JSONObject();
		int choice =0;
		
		// Begin 
		if(request.getParameter("choice") != null) { choice = Integer.parseInt(request.getParameter("choice")) ; }
		/*
		 * Choice > 1 : Subscription
		 * Choice > 2 : Load UserInfo */
		
		switch( choice ) {
			case(1) : 
				// Inscription
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				int phone = Integer.parseInt(request.getParameter("phone"));
				String email = request.getParameter("email");
				String password = request.getParameter("mdp");	
				 
		      Utilisateur user = new Utilisateur(nom,prenom,email,phone,LocalDate.now(),password);
				 
				  if( data.getUserInfo(email)==null) {
					   data.SubscribeRequest(user);  
					   obj.put("error", "false");
				  }else {
					   obj.put("error", "true");
				  }
			 	
				  response.getWriter().append(obj.toString());	
				
				// Test Navigateur : 127.0.0.1:8080/JPAEJB/users?choice=1&nom=Faye&prenom=Pacy&email=pacifaye@yahoo.fr&phone=0784657&mdp=azerty		
			break;
			 
		}
	 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	doGet(request, response);
	}

}
