package widget;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.*;

import dataClasses.Societe;
import main.GameManager;

public class ObligationLabel extends JLabel{
	
	private Societe societe;
	private GameManager manager;
	private Boolean favoris;
	
	public ObligationLabel(Societe societe, GameManager manager, Boolean favoris) {
		super(societe.getObligation().toDisplay());
		
		this.societe = societe;
		this.manager = manager;
		this.favoris  =favoris;
		
        addMouseListener(
                new ActionClickAdapter());
		
	}


	private class ActionClickAdapter extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
        	 String[] options = {"Acheter actions", "Ajouter aux favoris", "Annuler"};
        	 String[] options2 = {"Acheter actions", "Supprimer des favoris", "Annuler"};

        	 
        	 if(favoris) {
        		 notToFav(options2);
        	 }else {
        		 toFav(options);
        	 }
        }
        
        
        public void toFav(String[] options) {
        	  int rang = JOptionPane.showOptionDialog(null, "Que voulez vous faire ?",
            	      societe.getNom(),
            	      JOptionPane.YES_NO_CANCEL_OPTION,
            	      JOptionPane.QUESTION_MESSAGE,
            	      null,
            	      options,
            	      options[2]);	   
            	    
            	     if(options[rang].equals("Acheter actions")) {
            	    	 Object result = JOptionPane.showInputDialog(null, "nombre d'action:");
            	    	 
            	    	 if(manager.acheterAction(societe, Integer.valueOf(result.toString()))) {
            	    		 
            	    	 }else {
            	    		 
            	    	 }
            	    	 
            	     }else if((options[rang].equals("Ajouter aux favoris"))){
            	    	 manager.favorisSociete(societe);
            	     }
        }
        
        
        public void notToFav(String[] options) {
      	  int rang = JOptionPane.showOptionDialog(null, "Que voulez vous faire ?",
          	      societe.getNom(),
          	      JOptionPane.YES_NO_CANCEL_OPTION,
          	      JOptionPane.QUESTION_MESSAGE,
          	      null,
          	      options,
          	      options[2]);	   
          	    
          	     if(options[rang].equals("Acheter actions")) {
          	    	 Object result = JOptionPane.showInputDialog(null, "nombre d'action:");
          	    	 
          	    	 if(manager.acheterAction(societe, Integer.valueOf(result.toString()))) {
          	    		 
          	    	 }else {
          	    		 
          	    	 }
          	    	 
          	     }else if((options[rang].equals("Supprimer des favoris"))){
          	    	 manager.deleteFavorisSociete(societe);
          	     }
      }
        
     
    }

	
	
}
