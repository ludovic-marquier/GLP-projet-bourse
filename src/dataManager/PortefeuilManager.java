package dataManager;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import dataClasses.Portefeuille;
import dataClasses.ProduitFinancier;
import dataClasses.Societe;

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
	
	
	/**

     * Allows to buy a financial product
     * 
     * @param produitFinancier

         *the financial product that we want to buy
         *
     * @param nbAction

         *the volume of financial product that we want to buy
     */
	
	public Boolean acheter(ProduitFinancier produitFinancier, int nbAction) {
		
		//If user's account balance is sufficient 
		if(checkCapital(produitFinancier.getPrix()*nbAction)) {
			
			//adding Financial products one by one
			for (int i =0; i< nbAction;i++) {
				this.portefeuille.getProduits().add(produitFinancier);
			}
			
			//updating portefeuille state
			this.portefeuille.setCapitalRestant(round((this.portefeuille.getCapitalRestant()-produitFinancier.getPrix()*nbAction)-17.0,2));
			this.portefeuille.setCapitalInvestit(this.portefeuille.getCapitalInvestit()+produitFinancier.getPrix()*nbAction);
			this.portefeuille.setCapitalVirtuel(this.portefeuille.getCapitalInvestit()+this.portefeuille.getCapitalRestant());
			
			//displaying dialogBox whith details of transaction
			JOptionPane.showMessageDialog(null,
				    nbAction + " actions à "+produitFinancier.getPrix()+"$ ("+(produitFinancier.getPrix()*nbAction)+17+"$ avec les frais de courtage) ont été ajoutées a votre portefeuille.");
			return true;
			
		}else {
			//displaying dialogBox whith error message
			JOptionPane.showMessageDialog(null,
				    "Solde inssufisant !");
			return false;
		}
	}
	
	
	/**

     * Allows to sale a financial product
     
     * @param produitFinancier

         *the financial product that we want to sale
         
     * @param nbAction

         *the volume of financial product that we want to sale

     */
	public void vendre(Societe societe, int nbAction) {
		System.out.println(""+societe.getPrixDAction()*nbAction);
		int actionVendues = 0;
		ArrayList<ProduitFinancier> produits =  this.portefeuille.getProduits();
		Iterator it = produits.iterator();
		while(actionVendues<nbAction) {
			for(int i =0; i<produits.size(); i++) {
				ProduitFinancier produit = produits.get(i);
				if(societe.getId().equals(produit.getParentId())) {
					produits.remove(produit);
					actionVendues++;
				}
			}
		}
		
		
		this.portefeuille.setProduits(produits);
		this.portefeuille.setCapitalRestant(this.portefeuille.getCapitalRestant()+societe.getPrixDAction()*nbAction);
		this.portefeuille.setCapitalInvestit(this.portefeuille.getCapitalInvestit()-(societe.getPrixDAction()*nbAction));
		
	}
	
	
	/**

     *Check if user's balance is sufficient
     
     * @param prixProduit

         *Price that the user have to pay
        
     */
	public Boolean checkCapital(double prixProduit) {
		return this.portefeuille.getCapitalRestant()>prixProduit;
	}
	
	
	/**

     *Get a string format of user's wallet
     
     * @returns string format of user's wallet
  
     */
	
	public String portefeuilState(ArrayList<Societe> societes) {
		
		updateWallet(societes);
		
		return "Solde compte : "+this.portefeuille.getCapitalRestant() + "    Capital investit : "+this.portefeuille.getCapitalInvestit() + "    Capital virtuel : "+this.portefeuille.getCapitalVirtuel();
	}
	
	public ArrayList<ProduitFinancier> portefeuilStateDetails(ArrayList<Societe> societes) {
		updateWallet(societes);
		ArrayList produitsList = this.portefeuille.getProduits();
		Iterator it = produitsList.iterator();
		while(it.hasNext()) {
			ProduitFinancier produit = (ProduitFinancier) it.next();
			String parentId = produit.getParentId();
		}
		return produitsList;
	}
	
	public void delete(String type, String id, int nombre) {
		int countDelete = 0;
		Iterator it = this.portefeuille.getProduits().iterator();
		while(it.hasNext()) {
			ProduitFinancier currentPF = (ProduitFinancier) it.next();
			if(currentPF.getType().equals("ACTION")) {
				
			}
		}
	}
	
	public void updateWallet(ArrayList<Societe> societes) {
		double nwCapital = 0.0;
		ArrayList<ProduitFinancier> nwPort = new ArrayList<ProduitFinancier>();
		Iterator it = this.portefeuille.getProduits().iterator();
		while(it.hasNext()) {
			ProduitFinancier produit = (ProduitFinancier) it.next();
			Iterator it2 = societes.iterator();
			System.out.println(produit.toString());
			System.out.println("hello");
			
			while (it2.hasNext()) {
				Societe societe = (Societe) it2.next();
				if(societe.getId().equals(produit.getParentId())) {
					produit.setPrix(round(societe.getPrixDAction(),2));
					nwCapital = round(nwCapital + societe.getPrixDAction(),2);
					nwPort.add(produit);
				}
			}
			
			this.portefeuille.setProduits(nwPort);
			this.portefeuille.setCapitalInvestit(nwCapital);
			this.portefeuille.setCapitalVirtuel(round(this.portefeuille.getCapitalRestant()+this.portefeuille.getCapitalInvestit(),2));
			System.out.println(this.portefeuille.getProduits().toString());
			
		}
	}
	
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
}
