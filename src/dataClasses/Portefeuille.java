package dataClasses;

import java.util.ArrayList;

public class Portefeuille {
	private String propriétaire;
	private ArrayList<ProduitFinancier> produits;
	
	public String getPropriétaire() {
		return propriétaire;
	}
	public void setPropriétaire(String propriétaire) {
		this.propriétaire = propriétaire;
	}
	public ArrayList<ProduitFinancier>  getProduits() {
		return produits;
	}
	public void setProduits(ArrayList<ProduitFinancier>  produits) {
		this.produits = produits;
	}

		
}