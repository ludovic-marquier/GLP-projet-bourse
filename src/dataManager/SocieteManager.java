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
		for(int i=0 ; i<this.societeList.size() ; i++) {
			Societe currentSociete = this.societeList.get(i);
			
			double prevPrice = currentSociete.getPrixDAction();
			double nwPrice = 0;
			
			nwPrice = updtatePriceByHistorique(currentSociete);
			nwPrice = round(nwPrice+new Generator().generateRVariation(),2);
			
			if (nwPrice < 0) {nwPrice = 0;}
			
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
			}else {
				currentSociete.setIsGrowing(false);
			}
		
		}
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
