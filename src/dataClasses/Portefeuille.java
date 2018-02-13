package dataClasses;

import java.util.ArrayList;

public class Portefeuille {
	
	private ArrayList<ProduitFinancier> produits;
	
	public Portefeuille(ArrayList<ProduitFinancier> produits) {
		this.produits = produits;
	}
	public ArrayList<ProduitFinancier>  getProduits() {
		return produits;
	}
	public void setProduits(ArrayList<ProduitFinancier>  produits) {
		this.produits = produits;
	}

		
}