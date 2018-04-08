package dataManager;

import java.util.ArrayList;

import dataClasses.Societe;

public class FavorisManager {
	
	private ArrayList<Societe> societeFavoris;
	
	public FavorisManager() {
		
	}
	
	public void add(Societe societe) {
		societeFavoris.add(societe);
	}
	
	public ArrayList<Societe> getFavoris(){
		return societeFavoris;
	}
	
	public void delete(Societe societe) {
		
	}

}
