package widget;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.*;

import dataClasses.Societe;
import main.GameManager;

public class Position extends JLabel{
	
	private Societe societe;
	private GameManager manager;
	private int occurence;
	
	public Position(Societe societe, GameManager manager, int occurence) {
		super("<html>"+societe.getNom() +" "+ occurence+" actions" + "  "+societe.getPrixDAction()*occurence+"$"+"<br><br></html>");
		
		this.societe = societe;
		this.manager = manager;
		this.occurence = occurence;
		
        addMouseListener(
                new ActionClickAdapter());
		
	}


	private class ActionClickAdapter extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
        	 String[] options = {"Cloturer la position", "Annuler"};
 
        	  int rang = JOptionPane.showOptionDialog(null, "Que voulez vous faire ?",
            	      societe.getNom(),
            	      JOptionPane.YES_NO_CANCEL_OPTION,
            	      JOptionPane.QUESTION_MESSAGE,
            	      null,
            	      options,
            	      options[1]);	   
            	    
            	     if(options[rang].equals("Cloturer la position")) {
            	    	manager.vendreAction(societe, occurence);
            	     }
  
        }
        
        
  
	}
	
}
