package dataClasses;

import java.util.ArrayList;

public class PaireDeDevises {
	public ArrayList<Devise> devises;

	public PaireDeDevises(ArrayList<Devise> devises) {
		this.devises = devises;
	}

	public ArrayList<Devise> getDevises() {
		return devises;
	}

	public void setDevises(ArrayList<Devise> devises) {
		this.devises = devises;
	}
	
}