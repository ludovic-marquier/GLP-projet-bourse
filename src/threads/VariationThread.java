package threads;

import java.util.Scanner;

import dataClasses.Action;
import dataClasses.Evenement;
import dataClasses.Societe;
import dataManager.PortefeuilManager;
import dataManager.SocieteManager;
import utils.Generator;

public class VariationThread implements Runnable{
	
	private PortefeuilManager portefeuilManager;
	private SocieteManager societeManager;
	
	public VariationThread(PortefeuilManager portefeuilManager, SocieteManager societeManager) {
		this.portefeuilManager = portefeuilManager;
		this.societeManager =societeManager;
	}

	@Override
	public void run() {
		
		try {
			Thread.sleep(5000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private String extractId(String input) {
		return input.substring(2, input.length());
	}
	

}
