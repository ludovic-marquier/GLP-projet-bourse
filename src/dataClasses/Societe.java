package dataClasses;

public class Societe {
	private String nom;
	private String id;
	private String secteur;
	private double prixDAction;
	private int capital;
	private int nbAction;
	private Boolean isGrowing = false;
	private double variation;
	
	public Societe() {
		
	}
	
	public Societe(String nom, String id, double prixDAction, int capital, int nbAction) {
		super();
		this.nom = nom;
		this.id = id;
		this.prixDAction = prixDAction;
		this.capital = capital;
		this.nbAction = nbAction;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getPrixDAction() {
		return prixDAction;
	}
	public void setPrixDAction(double prixDAction) {
		this.prixDAction = prixDAction;
	}
	public int getCapital() {
		return capital;
	}
	public void setCapital(int capital) {
		this.capital = capital;
	}
	public int getNbAction() {
		return nbAction;
	}
	public void setNbAction(int nbAction) {
		this.nbAction = nbAction;
	}
	
	public String getSecteur() {
		return secteur;
	}

	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}
	

	public Boolean getIsGrowing() {
		return isGrowing;
	}

	public void setIsGrowing(Boolean isGrowing) {
		this.isGrowing = isGrowing;
	}

	public double getVariation() {
		return variation;
	}

	public void setVariation(double variation) {
		this.variation = variation;
	}

	public String toString() {
		return "NOM : "+this.nom+"\nID : "+this.id+"\nPRIX D'ACTION : "+
	this.prixDAction+"\nCAPITAL : "+this.capital+"\nNB ACTION : "+this.nbAction+"\n\n";
	}
	
	public String forLabelGrowing() {
		return "<html>"+this.nom+"      <font color='green'>"+this.prixDAction+     "              +"+this.variation+"%</font> "+this.capital+"<br><br></html>";
	}
	
	public String forLabelNotGrowing() {
		return "<html>"+this.nom+"      <font color='red'>"+this.prixDAction+"              "+this.variation+"%</font> "+this.capital+"<br><br></html>";
	}
	
}

