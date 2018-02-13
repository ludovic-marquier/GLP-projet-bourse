package dataClasses;

public class Utilisateur {
	
	private String nom;
	private String id;

	public Utilisateur(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
