package dataManager;

import java.util.ArrayList;
import java.util.Iterator;

import dataClasses.Evenement;
import utils.Generator;

public class EvenementManager {
	
	private ArrayList<Evenement> evenementsEnCour;
	private Generator generator;
	
	public EvenementManager() {
		evenementsEnCour= new ArrayList<Evenement>();
		generator = new Generator();
	}
	
	
	public ArrayList<Evenement> getEvenementsEnCour() {
		return evenementsEnCour;
	}

	public void setEvenementsEnCour(ArrayList<Evenement> evenementsEnCour) {
		this.evenementsEnCour = evenementsEnCour;
	}

	public ArrayList<Evenement> updateEvenement(){
		
		for(int i=0 ; i<this.evenementsEnCour.size(); i++) {
			Evenement event = this.evenementsEnCour.get(i);
			event.setVie(event.getVie()+1);
			if(event.getVie() == event.getDureeDeVie()) {
				this.evenementsEnCour.remove(i);
			}else {
				this.evenementsEnCour.remove(i);
				this.evenementsEnCour.add(i, event);
			}
		}
		
		int randomVar = generator.updateEvenement();
		if(randomVar == 2 || randomVar == 1) {
			if(evenementsEnCour.size()!=0 && evenementsEnCour.size() >=10) {
				this.evenementsEnCour.remove(0);
			}
			this.evenementsEnCour.add(generateEvenement());
		}
		return this.evenementsEnCour;
	}
	
	
	public Evenement generateEvenement() {
		int number = generator.generateEvenement();
		Evenement evenement = new Evenement();
		if(number>=-10 && number<=10 ) {
			evenement.setNiveaux(1);
		}else if (number>=13 && number <=13) {
			evenement.setNiveaux(2);
		}else if(number >=14 && number <=14) {
			evenement.setNiveaux(3);
		}
		
		
		evenement.setLabel(generator.genrateEventLabel());
		evenement.setDureeDeVie(10);
		//Etablissement des regles et génération en fonction du nombre généré
		
	
		return evenement;
	}
	

}
