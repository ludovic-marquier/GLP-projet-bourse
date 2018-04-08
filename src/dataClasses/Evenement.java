package dataClasses;

public class Evenement {
	
	private int niveaux;
	private String type;
	private String label;
	private String secteur;
	private int dureeDeVie;
	private int vie;
	
	
	public Evenement(int niveaux, String type) {
		this.niveaux = niveaux;
		this.type = type;
		this.vie = 0;
	}
	
	public Evenement() {
		
	}
	
	
	public int getNiveaux() {
		return niveaux;
	}
	public void setNiveaux(int niveaux) {
		this.niveaux = niveaux;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getSecteur() {
		return secteur;
	}

	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}
	
	
	public int getDureeDeVie() {
		return dureeDeVie;
	}

	public void setDureeDeVie(int dureeDeVie) {
		this.dureeDeVie = dureeDeVie;
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}
	
	public String toString() {
		return "<html>Evenement de niveau "+this.niveaux+". <br>"+this.getLabel()+"</html>";
	}

	
	
}
