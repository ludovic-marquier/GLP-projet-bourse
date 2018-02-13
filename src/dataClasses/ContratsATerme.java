package dataClasses;

public class ContratsATerme {
	
	private String delais;
	private double prix;
	private int bnProduits;
	private ProduitFinancier produitFinancier;
	
	public ContratsATerme(String delais, double prix, int bnProduits, ProduitFinancier produitFinancier) {
		super();
		this.delais = delais;
		this.prix = prix;
		this.bnProduits = bnProduits;
		this.produitFinancier = produitFinancier;
	}

	public String getDelais() {
		return delais;
	}

	public void setDelais(String delais) {
		this.delais = delais;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getBnProduits() {
		return bnProduits;
	}

	public void setBnProduits(int bnProduits) {
		this.bnProduits = bnProduits;
	}

	public ProduitFinancier getProduitFinancier() {
		return produitFinancier;
	}

	public void setProduitFinancier(ProduitFinancier produitFinancier) {
		this.produitFinancier = produitFinancier;
	}
	

}
