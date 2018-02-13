package dataClasses;

public class Devise {
	
	private String nom;
	private double valeur;
	
	
	public Devise(String nom, double valeur) {
		this.nom = nom;
		this.valeur = valeur;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public double getValeur() {
		return valeur;
	}


	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
	

}
