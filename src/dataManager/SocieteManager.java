package dataManager;

import java.util.ArrayList;
import java.util.Iterator;

import dataClasses.Societe;
import utils.Generator;

public class SocieteManager {
	
	private ArrayList<Societe> societeList;
	
	public final static int LEVEL_EASY = 10;
	public final static int LEVEL_MEDIUM = 30;
	public final static int LEVEL_HARD= 60;
	
	public SocieteManager() {
		
	}
	
	
	public SocieteManager(ArrayList<Societe> societeList) {
		this.societeList = societeList;
	}
	
	
	
	public ArrayList<Societe>getList(){
		return societeList;
	}
	
	
	
	public void generateList(int level) {
		
		ArrayList<Societe> nwSocieteList = new ArrayList<Societe>();
		Generator generator = new Generator();
		
		for(int i=0 ; i<level ; i++) {
			if(i==8) {
				//this is an easter egg
				Societe societe = new Societe();
				
				societe.setNom("SpaceX");
				societe.setId(generator.generateId());
				societe.setCapital(240000000);
				societe.setNbAction(5000000);
				societe.setPrixDAction(societe.getCapital()/societe.getNbAction());
				societe.setSecteur("Spacial");
				
				nwSocieteList.add(societe);
			}else {
				Societe societe = new Societe();
				
				societe.setNom(generator.generateName());
				societe.setId(generator.generateId());
				societe.setCapital(generator.generateCapital());
				societe.setNbAction(500000000);
				societe.setPrixDAction(societe.getCapital()/societe.getNbAction());
				societe.setSecteur(generator.generateSecteur());
				
				nwSocieteList.add(societe);
			}
		
	
		}
		this.societeList = nwSocieteList;
	}
	
	
	
	public void updateList() {
		int g=0;
		int ng =0;
		for(int i=0 ; i<this.societeList.size() ; i++) {
			Societe currentSociete = this.societeList.get(i);
			
			double prevPrice = currentSociete.getPrixDAction();
			double nwPrice = prevPrice;
		
			
			nwPrice = updtatePriceByHistorique(currentSociete);
			nwPrice = checkSector(nwPrice, currentSociete, this.societeList);
			nwPrice = round(nwPrice+new Generator().generateRVariation(),2);
			
			if (nwPrice <= 0) {nwPrice = 5;}
			
			double variation = calculateVariation(prevPrice, nwPrice);
			currentSociete.setPrixDAction(nwPrice);
			currentSociete.setVariation(variation);
			currentSociete.setCapital(Integer.valueOf((int) (nwPrice*50000)));
			
			ArrayList<Double> historique = currentSociete.getHistorique();
			
			if(historique.size() < 20) {
				historique.add(currentSociete.getVariation());
			}else {
				historique.remove(0);
				historique.add(currentSociete.getVariation());
			}
			
			currentSociete.setHistorique(historique);
			
			
			if(prevPrice<=nwPrice) {
				currentSociete.setIsGrowing(true);
				g++;
			}else {
				currentSociete.setIsGrowing(false);
				ng++;
			}
		}
		System.out.println(g+"    "+ng);
	}
	
	
	
	public Societe getSocieteById(String id) {
		Iterator<Societe> it = this.societeList.iterator();
		Societe matchingSociete = new Societe();
		while(it.hasNext()) {
			Societe societe = it.next();
			if(societe.getId().equals(id)) {
				matchingSociete = societe;
			}
		}
		return matchingSociete;
	}

	public void updateSociete(Societe societe, double nwPrice) {
		
	}

	public double updtatePriceByHistorique(Societe currentSociete) {
		double nwPrice = currentSociete.getPrixDAction();
	
		if(currentSociete.getHistorique().size() >10) {
			Iterator it = currentSociete.getHistorique().iterator();
			double sum = 0;
			while(it.hasNext()) {
				sum = sum + (Double)it.next();
			}
				
			double moy = sum/currentSociete.getHistorique().size();
			
			if(moy<-2) {
				nwPrice = calculatePrixActionByPourcentage(currentSociete.getPrixDAction(),1);
			}else if(moy < 0 && moy >-2) {
				nwPrice = calculatePrixActionByPourcentage(currentSociete.getPrixDAction(),-0.5);
			}else if(moy>0 && moy<2) {
				nwPrice =calculatePrixActionByPourcentage(currentSociete.getPrixDAction(),0.2);
			}else if(moy>2){
			    nwPrice =calculatePrixActionByPourcentage(currentSociete.getPrixDAction(),-1);
			}
				
		}
		
		
		return nwPrice;
	}
	
	public double checkSector(double prevPrice, Societe societe, ArrayList<Societe> societeList) {
		double nwPrice = prevPrice;
		double growing = 0;
		double notGrowing =0;
		
		Iterator it = societeList.iterator();
		while(it.hasNext()) {
			Societe cSociete = (Societe) it.next();
			if(cSociete.getSecteur().equals(societe.getSecteur())) {
				if(cSociete.getIsGrowing()) {
					growing++;
				}else {
					notGrowing++;
				}
			}
		}
		

		//Calcul du pourentage d'entreprise dont la croissance est positive dans le secteur de la societe etudié
		//et variation du cour different par tranches de 10aines
		
		double pourcentGrowing = (growing/(growing+notGrowing))*100;
	
		
		if(pourcentGrowing<10) {
			nwPrice = calculatePrixActionByPourcentage(nwPrice, -2);
		}else if(pourcentGrowing<20) {
			nwPrice = calculatePrixActionByPourcentage(nwPrice, -1.8);
		}else if(pourcentGrowing<30) {
			nwPrice = calculatePrixActionByPourcentage(nwPrice, -1);
		}else if(pourcentGrowing<40) {
			nwPrice = calculatePrixActionByPourcentage(nwPrice, -0.2);
		}else if(pourcentGrowing<50) {
			nwPrice = calculatePrixActionByPourcentage(nwPrice, 0);
		}else if(pourcentGrowing<60) {
			nwPrice = calculatePrixActionByPourcentage(nwPrice, 0.2);
		}else if(pourcentGrowing<70) {
			nwPrice = calculatePrixActionByPourcentage(nwPrice, 0.4);
		}else if(pourcentGrowing<80) {
			nwPrice = calculatePrixActionByPourcentage(nwPrice, 1);
		}else if(pourcentGrowing<90) {
			nwPrice = calculatePrixActionByPourcentage(nwPrice, 1.5);
		}else if(pourcentGrowing<100) {
			nwPrice = calculatePrixActionByPourcentage(nwPrice, 2);
		}else {
			nwPrice = calculatePrixActionByPourcentage(nwPrice, 3);
		}
		
		return nwPrice;
	}
	
	public double updatePriceByRandom(double prevPrice) {
		return round(prevPrice+new Generator().generateRVariation(),2);
	}
	
	public double calculateVariation(double prevPrice, double nwPrice) {
		return round(((nwPrice/prevPrice)-1)*100,2);
	}
	
	public double calculatePrixActionByPourcentage(double prix, double pourcentage) {
		return prix+(prix*(pourcentage/100));
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}

}
