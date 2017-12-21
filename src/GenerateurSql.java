
public class GenerateurSql {

	public static void main(String[] args) {
		//14
		String name[] = {"Paul", "Roux", "Durand", "Blanc", "Morel", "Guerin","Rousseau" , "Faure", "Vincent","Morin","Fabre","Picard","Dumas","Joly"  };
		//14
		String Fname[] = { "Laure","Pierre","Etienne","Roger", "Sandrine" , "Nathalie", "Edouard", "Lea", "Leo" , "Alice", "Adam","Chloe","Louis","Lucas" }; 
		
		String Emails[] = { "louis.morel@gmail.com", "jade.garnier@gmail.com", "lucas.blanc@gmail.com","emma.dubois@gmail.com", "louise.roux@gmail.com" , "gabriel.martin@gmail.com","laure.joly@gmail.com","pierre.dumas@gmail.com",  "louis2.morel@gmail.com", "jade2.garnier@gmail.com", "lucas2.blanc@gmail.com","emma2.dubois@gmail.com", "louise2.roux@gmail.com" , "gabriel2.martin@gmail.com","laure2.joly@gmail.com","pierre2.dumas@gmail.com",       };
		
        String titles[] = {
        		"iPhone SE 32go",
        		"Jeu console PlayStation 2",
        		"Telecommande denon",
        		"Voiture 206 cc hdi quicksilver 110 cv",
        		"Carafe pichet verre ricard",
        		"Pied de table en fonte",
        		"Sac en cuir", 
        		"Canape cuir",
        		"Micro-Onde",
        		"Manette console PS2"
        	 };
        String Desc [] = {
        		"Vend iPhone SE 32go, état comme neuf, encore garantie jusqu,au 28 juillet 2018, vendu avec la boîte et la facture",
        		"Jeu d basket PlayStation 2",
        		"a prendre sur vannes,en parfait état modèle 1 litre",
        		"Table blanche avec rallonge, Les pieds sont démontables ",
        		"Maison Barbie plus poupee a vendre pas cher",
        		"Armoire couleur marron en bois, pratique pour ranger ses vetements et chaussures",
        		"Table a manger blanche accompagne de 4 chaises etat neuf",
        		"Sony Walkman ancienne generation pour les veterans "  };
		
        String Categ [] = { "Informatique" , "Telephone" , "Utilitaires", "Equipement","Bureaux","Consoles - Jeux vidéo", "Téléphonie" };
		int lower = 1000;
		int higher = 10000;
		int randomidus= 9999; 
		int randomidpr= 9999; 
		int lowerIM = 1;
		int higherIM =50;
		int randomimage= 1; 
		int randomprixMax = 1; 
		for(int i=0; i<14 ; i++ ) {
			randomidus= (int)(Math.random() * (higher-lower)) + lower;
		System.out.println("insert into Utilisateur VALUES( "+randomidus+",  '"+Emails[i]+"' , '"+Fname[i]+"' , '"+name[i]+"'  ,'azerty',0626798,'2017-12-20',0); ");
		  
				for(int j=0; j<5 ; j++ ) {
					randomidpr= (int)(Math.random() * (higher-lower)) + lower;
					randomimage= (int)(Math.random() * (higherIM-lowerIM)) + lowerIM;
					randomprixMax= (int)(Math.random() * (1000-lowerIM)) + lowerIM;
					
					System.out.println("insert into Produit VALUES( "+randomidpr+", "+randomidus+", '"+titles[j]+"' , '"+Desc[j]+"' , '"+Categ[j]+"'  ,'Product"+randomimage+".jpg',"+randomimage+","+randomprixMax+" , 38000, '2017-12-31'); ");
					
					
					 
					
			
				}
		
		
		
		}
		
		
		
		
		
		
		
		
		
	}

}
