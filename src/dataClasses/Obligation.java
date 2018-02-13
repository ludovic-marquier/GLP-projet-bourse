package dataClasses;

public class Obligation extends Action {
	
	private double tauxInteret;

	public Obligation(double prixAchat, Societe societe, double tauxInteret) {
		super(prixAchat, societe);
		this.tauxInteret = tauxInteret;
	}

	public double getTauxInteret() {
		return tauxInteret;
	}

	public void setTauxInteret(double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}
	
	

}
