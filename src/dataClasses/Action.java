package dataClasses;

public class Action extends ProduitFinancier{
	
	private double prixAchat;
	private Societe societe;
	
	public Action(double prixAchat, Societe societe) {
		super("action","eee", prixAchat);
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
