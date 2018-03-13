package dataClasses;

public class Obligation extends Action {
	
	private double tauxInteret;
	private String frequenceRemboursement;
	private String echeance;

	public Obligation(double prixAchat, Societe societe, double tauxInteret, String frequenceRemboursement, 
			String echeance) {
		super(prixAchat, societe);
		this.tauxInteret = tauxInteret;
		this.frequenceRemboursement = frequenceRemboursement;
		this.echeance = echeance;
	}

	public double getTauxInteret() {
		return tauxInteret;
	}

	public void setTauxInteret(double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}

	public String getFrequenceRemboursement() {
		return frequenceRemboursement;
	}

	public void setFrequenceRemboursement(String frequenceRemboursement) {
		this.frequenceRemboursement = frequenceRemboursement;
	}

	public String getEcheance() {
		return echeance;
	}

	public void setEcheance(String echeance) {
		this.echeance = echeance;
	}
	
	
	

}
