package dataClasses;

public class Action {
	
	private double prixAchat;
	private Societe societe;
	
	public Action(double prixAchat, Societe societe) {
		this.prixAchat = prixAchat;
		this.societe = societe;
	}

	public double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}

	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

}
