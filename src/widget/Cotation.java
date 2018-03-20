package widget;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.*;

import dataClasses.Societe;
import main.GameManager;

public class Cotation extends JLabel{
	
	private Societe societe;
	private GameManager manager;
	
	public Cotation(Societe societe, GameManager manager) {
		super((societe.getIsGrowing())?societe.forLabelGrowing() : societe.forLabelNotGrowing());
		
		this.societe = societe;
		this.manager = manager;
		
        addMouseListener(
                new URLOpenAdapter());
		
	}


	private class URLOpenAdapter extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
        	 String[] options = {"Acheter actions", "Ajouter aux favoris", "Annuler"};

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
        	    	 
        	     }
        	 
        }
    }

	
	
}
