package dataClasses;

import java.util.ArrayList;

public class Portefeuille {
	
	private ArrayList<ProduitFinancier> produits;
	private double capitalVirtuel;
	private double capitalRestant;
	private double capitalInvestit;
	
	
	public Portefeuille(ArrayList<ProduitFinancier> produits, double capitalVirtuel, double capitalRestant,
			double capitalInvestit) {
		this.produits = produits;
		this.capitalRestant = capitalRestant;
	}
	public ArrayList<ProduitFinancier>  getProduits() {
		return produits;
	}
	public void setProduits(ArrayList<ProduitFinancier>  produits) {
		this.produits = produits;
	}
	public double getCapitalVirtuel() {
		return capitalVirtuel;
	}
	public void setCapitalVirtuel(double capitalVirtuel) {
		this.capitalVirtuel = capitalVirtuel;
	}
	public double getCapitalRestant() {
		return this.capitalRestant;
	}
	public void setCapitalRestant(double capitalRestant) {
		this.capitalRestant = capitalRestant;
	}
	public double getCapitalInvestit() {
		return this.capitalInvestit;
	}
	public void setCapitalInvestit(double capitalInvestit) {
		this.capitalInvestit = capitalInvestit;
	}
	
	public void addProduct(ProduitFinancier produitFinancier) {
		this.produits.add(produitFinancier);
	}
	
	public void deletProduct() {
		
	}
	
	

		
}