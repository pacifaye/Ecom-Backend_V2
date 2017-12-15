package Enumerations;


import javax.persistence.Column;

public enum Users {
		// Ensemble de 30 differents utilisateurs prédéfinis
		// "Name","Fname","Email","Phone" etant les champs d infos personnels.
	User1("Martin","Gabriel","gabriel.martin@gmail.com","0626798"),
	User2("Roux","Louise","louise.roux@gmail.com","54764335"),
	User3("Durand","Jules","jules.durand@gmail.com","7867756"),
	User4("Dubois","Emma","emma.dubois@gmail.com","289928"),
	User5("Blanc","Lucas","lucas.blanc@gmail.com","08786798"),
	User6("Garnier","Jade","jade.garnier@gmail.com","62567889"),
	User7("Morel","Louis","louis.morel@gmail.com","0823878"),
	User8("Guerin","Chloe","chloe.guerin@gmail.com","2675752"),
	User9("Fournier","Adam","adam.fournier@gmail.com","7878365"),
	User10("Roy","Manon","manon.roy@gmail.com","09092376"),
	User11("Rousseau","Hugo","hugo.rousseau@gmail.com","0254622"),
	User12("Gautier","Alice","alice.gautier@gmail.com","07678782"),
	User13("Bonnet","Leo","leo.bonnet@gmail.com","03576776"),
	User14("Faure","Lina","lina.faure@gmail.com","02076765"),
	User15("Mercier","Raphael","raphael.mercier@gmail.com","0856643"),
	User16("Vincent","Lea","lea.vincent@gmail.com","07545456"),
	User17("Giraud","Ethan","ethan.giraud@gmail.com","0379436"),
	User18("Perrin","Lola","lola.perrin@gmail.com","06980548"),
	User19("Morin","Nathan","nathan.morin@gmail.com","0865687"),
	User20("Masson","Camille","camille.masson@gmail.com","02854992"),
	User21("Boulanger","Edouard","edouard.boulanger@gmail.com","0557283"),
	User22("Dupont","Nathalie","nathalie.dupont@gmail.com","06572373"),
	User23("Fabre","Aurelie","aurelie.fabre@gmail.com","07268298"),
	User24("Bourgeois","Sandrine","sandrine.bourgeois@gmail.com","06253772"),
	User25("Picard","Roger","roger.picard@gmail.com","9567653"),
	User26("Briand","Axel","axel.briand@gmail.com","04562623"),
	User27("Roche","Marie","marie.roche@gmail.com","045912080"),
	User28("Leclerc","Etienne","etienne.leclerc@gmail.com","07263426"),
	User29("Dumas","Pierre","pierre.dumas@gmail.com","04278273"),
	User30("Joly","Laure","laure.joly@gmail.com","0865465");
	
	private String Name;
	private String Fname;
	private String Email;
	private String Phone;
	
	
	
	Users (String n, String fn, String email ,String phone){
		this.Name = n;
		this.Fname = fn;
		this.Email = email;
		this.Phone = phone;
	}
	

	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}



	/**
	 * @return the fname
	 */
	public String getFname() {
		return Fname;
	}



	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		Fname = fname;
	}



	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}



	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		Email = email;
	}



	/**
	 * @return the phone
	 */
	public String getPhone() {
		return Phone;
	}



	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		Phone = phone;
	}

}
