package main;

import java.util.ArrayList;
import java.util.Scanner;

import dataClasses.Action;
import dataClasses.ProduitFinancier;
import dataClasses.Societe;
import dataManager.PortefeuilManager;
import dataManager.SocieteManager;
import gui.FenetreJeu;
import gui.MainGui;
import threads.VariationThread;

public class GameManager{
	
	private PortefeuilManager portefeuilManager;
	private SocieteManager societeManager;
	private FenetreJeu gui;
	
	public void start() {
		init();
		loop();
	}
	
	private void init() {
		
		portefeuilManager = new PortefeuilManager();
		societeManager =  new SocieteManager();
		
		System.out.println("******************** PROJET BOURSE ********************");
		System.out.println("nSelectionnez un niveau de difficulté\n");
		System.out.println("1 - Facile\n2 - Moyen\n3 - Difficile");
		System.out.println("\nChoisissez grace au pavé numérique");
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		if(Integer.valueOf(str)>0 && Integer.valueOf(str)<4) {
			if(str.equals("1")) {
				societeManager.generateList(SocieteManager.LEVEL_EASY);
				portefeuilManager.initPortefeuille(PortefeuilManager.LEVEL_EASY);
				gui = new FenetreJeu(this);
			}else if(str.equals("2")) {
				societeManager.generateList(SocieteManager.LEVEL_MEDIUM);
				portefeuilManager.initPortefeuille(PortefeuilManager.LEVEL_MEDIUM);
				gui =  new FenetreJeu(this);
			}else if (str.equals("3")) {
				societeManager.generateList(SocieteManager.LEVEL_HARD);
				portefeuilManager.initPortefeuille(PortefeuilManager.LEVEL_HARD);
				gui =  new FenetreJeu(this);
			}
			
			//System.out.println(this.societeManager.displayList());
			
		}else {
			init();
		}
		
	}
	
	private void loop() {
		
		gui.setVisible(true);
		
		
	}
	
	public ArrayList<Societe> calculateVariation() {
		this.societeManager.updateList();
		return this.societeManager.getList();
	}
	
	public String getPortefeuilState() {
		return this.portefeuilManager.portefeuilState();
	}
	
	public Boolean acheterAction(Societe societe, int nbAction) {
		Action action = new Action(societe.getPrixDAction(), societe);
		if(this.portefeuilManager.acheter(action, nbAction)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	private String extractId(String input) {
		return input.substring(2, input.length());
	}
	
	private Boolean checkCapital() {
		return false;
	}
	
}