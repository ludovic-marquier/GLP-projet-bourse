package main;

import org.apache.log4j.BasicConfigurator;

import dataManager.SocieteManager;
import gui.FenetreAcceuil;
import gui.FenetreJeu;
import gui.MainGui;

public class Test {

	public static void main(String[] args){ 
		BasicConfigurator.configure();
		FenetreAcceuil fenetre = new FenetreAcceuil();
	}
	
}
