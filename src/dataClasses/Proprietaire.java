package dataClasses;

public class Proprietaire {
	
	private String identifiant;
	private Portefeuille portefeuille;
	
	public Proprietaire(String identifiant, Portefeuille portefeuille) {
		this.identifiant = identifiant;
		this.portefeuille = portefeuille;
	}
	
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public Portefeuille getPortefeuille() {
		return portefeuille;
	}
	public void setPortefeuille(Portefeuille portefeuille) {
		this.portefeuille = portefeuille;
	}
}
