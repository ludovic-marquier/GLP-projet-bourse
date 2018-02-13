package dataClasses;

public class Societe {
	private String nom;
	private int id;
	private int prixDAction;
	private int capital;
	private int nbAction;
	
	public Societe(String nom, int id, int prixDAction, int capital, int nbAction) {
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrixDAction() {
		return prixDAction;
	}
	public void setPrixDAction(int prixDAction) {
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
	
}

