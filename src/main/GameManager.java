package main;

import java.util.ArrayList;
import java.util.Scanner;

import dataClasses.Action;
import dataClasses.Evenement;
import dataClasses.ProduitFinancier;
import dataClasses.Societe;
import dataManager.EvenementManager;
import dataManager.PortefeuilManager;
import dataManager.SocieteManager;
import gui.FenetreAcceuil;
import gui.FenetreJeu;
import gui.MainGui;
import threads.VariationThread;

public class GameManager{
	
	private PortefeuilManager portefeuilManager;
	private SocieteManager societeManager;
	private EvenementManager evenementManager;
	private FenetreJeu gui;
	
	
	public void start(String niveau) {
		init(niveau);
		loop();
	}
	
	private void init(String niveau) {
		
		portefeuilManager = new PortefeuilManager();
		societeManager =  new SocieteManager();
		evenementManager = new EvenementManager();
	
		

			if(niveau.equals("Niveau Facile")) {
				societeManager.generateList(SocieteManager.LEVEL_EASY);
				portefeuilManager.initPortefeuille(PortefeuilManager.LEVEL_EASY);
				gui = new FenetreJeu(this, "Facile");
			}else if(niveau.equals("Niveau Intermediaire")) {
				societeManager.generateList(SocieteManager.LEVEL_MEDIUM);
				portefeuilManager.initPortefeuille(PortefeuilManager.LEVEL_MEDIUM);
				gui =  new FenetreJeu(this, "Intermediaire");
			}else if (niveau.equals("Niveau Difficile")) {
				societeManager.generateList(SocieteManager.LEVEL_HARD);
				portefeuilManager.initPortefeuille(PortefeuilManager.LEVEL_HARD);
				gui =  new FenetreJeu(this, "Difficile");
			}
			
			//System.out.println(this.societeManager.displayList());
			
		
	}
	
	private void loop() {
		
		gui.setVisible(true);
		
		
	}
	
	public ArrayList<Societe> calculateVariation() {
		this.societeManager.updateList();
		return this.societeManager.getList();
	}
	
	public String getPortefeuilState() {
		return this.portefeuilManager.portefeuilState(this.societeManager.getList());
	}
	
	public ArrayList<ProduitFinancier> getPortefeuil(){
		return this.portefeuilManager.portefeuilStateDetails(this.societeManager.getList());
	}
	
	public ArrayList<Evenement> updateEvenements(){
		return this.evenementManager.updateEvenement();
	}
	
	public Boolean acheterAction(Societe societe, int nbAction) {
		Action action = new Action(societe.getPrixDAction(), societe);
		action.setParentId(societe.getId());
		if(this.portefeuilManager.acheter(action, nbAction)) {
			return true;
		}else {
			return false;
		}
	}
	
	public void vendreAction(Societe societe, int nbAction) {
		this.portefeuilManager.vendre(societe, nbAction);
	}
	
	public void favorisSociete(Societe societe) {
		this.societeManager.addFavoris(societe);
	}
	
	public void deleteFavorisSociete(Societe societe) {
		this.societeManager.deleteFavoris(societe);
	}
	
	public ArrayList<Societe> getFavoris(){
		return this.societeManager.getFavoris();
	}
	
	private String extractId(String input) {
		return input.substring(2, input.length());
	}
	
	private Boolean checkCapital() {
		return false;
	}
	
}