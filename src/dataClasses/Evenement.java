package dataClasses;

public class Evenement {
	
	private int niveaux;
	private String type;
	
	
	public Evenement(int niveaux, String type) {
		this.niveaux = niveaux;
		this.type = type;
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
}
