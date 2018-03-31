package dataManager;

import java.util.ArrayList;
import java.util.Iterator;

import dataClasses.Portefeuille;
import dataClasses.ProduitFinancier;

public class PortefeuilManager {
	
	Portefeuille portefeuille;
	
	public final static double LEVEL_EASY = 100000;
	public final static double LEVEL_MEDIUM = 50000;
	public final static double LEVEL_HARD= 20000;
	
	public PortefeuilManager() {
		
	}
	
	public PortefeuilManager(Portefeuille portefeuille) {
		this.portefeuille = portefeuille;
	}
	
	public void initPortefeuille(double level) {
		this.portefeuille = new Portefeuille(new ArrayList<ProduitFinancier>(),0,level,0);
	}
	
	public Boolean acheter(ProduitFinancier produitFinancier, int nbAction) {
		System.out.println(""+produitFinancier.getPrix());
		System.out.println(this.portefeuille.getCapitalRestant());
		if(checkCapital(produitFinancier.getPrix()*nbAction)) {
			
			for (int i =0; i< nbAction;i++) {
				this.portefeuille.getProduits().add(produitFinancier);
			}
			
			this.portefeuille.setCapitalRestant(this.portefeuille.getCapitalRestant()-produitFinancier.getPrix()*nbAction);
			System.out.println("L'action a ete ajoutée a votre portefeuil");
			return true;
		}else {
			System.out.println("Solde personel inssuffisant");
			return false;
		}
	}
	
	public void vendre(ProduitFinancier produitFinancier) {
		
	}
	
	public Boolean checkCapital(double prixProduit) {
		return this.portefeuille.getCapitalRestant()>prixProduit;
	}
	
	public String portefeuilState() {
		
		return "Solde compte : "+this.portefeuille.getCapitalRestant() + "    Capital investit : "+this.portefeuille.getCapitalInvestit() + "    Capital virtuel : "+this.portefeuille.getCapitalVirtuel();
	}
	
	public ArrayList<ProduitFinancier> portefeuilStateDetails() {
		return this.portefeuille.getProduits();
	}
	
	
}
