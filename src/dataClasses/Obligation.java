package dataClasses;

public class Obligation extends Action {
	
	private double tauxInteret;
	private int frequenceRemboursement;
	private int echeance;
	private int vie;

	public Obligation(double prixAchat, Societe societe, double tauxInteret, int frequenceRemboursement, 
			int  string) {
		super(prixAchat, societe);
		this.tauxInteret = tauxInteret;
		this.frequenceRemboursement = frequenceRemboursement;
		this.echeance = string;
	}

	public double getTauxInteret() {
		return tauxInteret;
	}

	public void setTauxInteret(double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}

	public int getFrequenceRemboursement() {
		return frequenceRemboursement;
	}

	public void setFrequenceRemboursement(int frequenceRemboursement) {
		this.frequenceRemboursement = frequenceRemboursement;
	}

	public int getEcheance() {
		return echeance;
	}

	public void setEcheance(int echeance) {
		this.echeance = echeance;
	}
	
	
	
	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	public String toDisplay() {
		return "<html>"+super.getSociete().getNom() +" "+ super.getPrixAchat()+ " "+tauxInteret+" "+ frequenceRemboursement+" "+ echeance+"<br><br><br></html>";
	}
	

}
