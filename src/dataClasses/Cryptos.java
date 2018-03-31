package dataClasses;

public class Cryptos extends Devise{
	
	private String technologie;
	
	public Cryptos(String nom, double valeur, String technologie) {
		super(nom, valeur);
		this.technologie = technologie;
	}

	public String getTechnologie() {
		return technologie;
	}

	public void setTechnologie(String technologie) {
		this.technologie = technologie;
	}

}
