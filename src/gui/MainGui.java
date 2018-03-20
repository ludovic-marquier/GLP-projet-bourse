package gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

import dataClasses.Societe;
import main.GameManager;

public class MainGui extends JFrame{
	
	private Container container;
	private JPanel actionPanel;
	private int nbCot;
	private GameManager manager;

	public MainGui() {
		this("fenetre",0, null);
	}
	
	public MainGui(String titre, int nbCot, GameManager manager) {
		super(titre);
		container = this.getContentPane();
		this.nbCot = nbCot;
		this.manager = manager;
		
		actionPanel = new JPanel(new GridLayout(this.nbCot,1));
		JScrollPane pane = new JScrollPane(actionPanel);
		
		this.add(pane);
		
		this.setSize(700, 400);;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		SwingChiller chiller = new SwingChiller();
		chiller.execute();
		
	}
	
	
	class SwingChiller extends SwingWorker<ArrayList<Societe>, Integer>
		{
		    protected ArrayList<Societe> doInBackground() throws Exception
		    {
		    	while(!this.isCancelled()) {
		    		Thread.sleep(1000);
			 	    return manager.calculateVariation();
		    	}
				return null;
		    	  
		    }

		    protected void done()
		    {
		        try
		        {
		           actionPanel.removeAll();
		           ArrayList<Societe> bo = get();
		           Iterator it = bo.iterator();
		           
		           while(it.hasNext()) {
		        	   Societe societe = (Societe) it.next();
		        	   if(societe.getIsGrowing()) {
		        		   actionPanel.add(new JLabel(societe.forLabelGrowing()));
		        	   }else {
		        		   actionPanel.add(new JLabel(societe.forLabelNotGrowing()));
		        	   }
		        	   
		           }
		           
		           revalidate();
		           callChiller();
		           
		        }
		        catch (Exception e)
		        {
		            e.printStackTrace();
		        }
		    }
		}
	 
	 
	 public void callChiller() {
			SwingChiller chill = new SwingChiller();
			chill.execute();
		}
}
