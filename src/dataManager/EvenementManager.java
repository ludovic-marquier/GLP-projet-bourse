package dataManager;

import java.util.ArrayList;

import dataClasses.Evenement;
import utils.Generator;

public class EvenementManager {
	
	private ArrayList<Evenement> evenementsEnCour;
	
	public EvenementManager() {
		
	}
	
	
	public ArrayList<Evenement> getEvenementsEnCour() {
		return evenementsEnCour;
	}



	public void setEvenementsEnCour(ArrayList<Evenement> evenementsEnCour) {
		this.evenementsEnCour = evenementsEnCour;
	}


	
	public void generateEvenement() {
		Generator generator = new Generator();
		int rand = generator.generateEvenement();
		
		//Etablissement des regles et g�n�ration en fonction du nombre g�n�r�
		
		if(rand <10) {
			
		}else if(rand == 20) {
			
		}
	}
	

}
