package dataClasses;

import java.util.ArrayList;

public class Portefeuille {
	private String propri�taire;
	private ArrayList<ProduitFinancier> produits;
	
	public String getPropri�taire() {
		return propri�taire;
	}
	public void setPropri�taire(String propri�taire) {
		this.propri�taire = propri�taire;
	}
	public ArrayList<ProduitFinancier>  getProduits() {
		return produits;
	}
	public void setProduits(ArrayList<ProduitFinancier>  produits) {
		this.produits = produits;
	}

		
}