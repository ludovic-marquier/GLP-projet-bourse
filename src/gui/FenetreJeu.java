package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;

import dataClasses.ProduitFinancier;
import dataClasses.Societe;
import gui.MainGui.SwingChiller;
import main.GameManager;
import widget.Cotation;
import widget.MyButton;

public class FenetreJeu extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private GameManager manager;
	
	private Container container;
	
	private JPanel Panel1 = new JPanel();
	private JPanel Panel2 = new JPanel();
	private JPanel Panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	
	private JLabel portfeuilStateLabel = new JLabel();
	
	private JPanel actionPanel;
	private Boolean showActions = true;
	
	
	
	public FenetreJeu(GameManager manager) {
		
		this.setVisible(false);
	    this.setTitle("Simulateur boursier");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setContentPane(new JLabel());
	  
	    this.setBackground(new Color(173, 216, 230));
	    Panel1.setBackground(new Color(173, 216, 230));
	    container = this.getContentPane();
	   
	    
	    BorderLayout bord = new BorderLayout();
	    bord.setHgap(100);
	    bord.setVgap(100);
	    container.setLayout(bord);
	    
	    this.manager = manager;
	    
	    
	    ImageIcon warnIcon = new ImageIcon(new ImageIcon("data/actualite.png").getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT));
	    JButton FilDActualite = new JButton(warnIcon);
	    
	    ImageIcon warnIcon2 = new ImageIcon(new ImageIcon("data/portefeuille.png").getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT));
	    JButton Portefeuille = new JButton(warnIcon2);
	    
	    ImageIcon warnIcon3 = new ImageIcon(new ImageIcon("data/favoris.png").getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT));
	    JButton  Favoris= new JButton(warnIcon3);
	   
	  
	    Panel1.add(FilDActualite);
	    
	    
	    
	    FilDActualite.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) { 
	    		  if(!showActions) {
	    			  showActions = true;
		    		  callWorker();
	    		  }
	    		
	    		  } 
	    		} );
	    
	    
	    Panel1.add(Portefeuille);
	    Portefeuille.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) { 
	    		    showActions = false;
	    		    showPortefeuil();
	    		  } 
	    		} );
	    
	    
	    Panel1.add(Favoris);
	    Favoris.addActionListener(this);
	    
	   
	    Panel1.setLayout(new GridLayout(4,1));
	    
	    JLabel niveauLabel = new JLabel("Niveau de difficulté : "
	    		+ "Difficile");
	    niveauLabel.setFont(new Font("Biko", Font.PLAIN, 20));

	    portfeuilStateLabel.setFont(new Font("Biko", Font.PLAIN, 27));
	    portfeuilStateLabel.setForeground(Color.WHITE);
	    Panel1.add(niveauLabel);
	    Panel2.setBackground(new Color(48, 46, 36));
	    Panel2.add(portfeuilStateLabel);
	  
	 
	    actionPanel = new JPanel(new GridLayout(60,1));
	    actionPanel.setBackground(Color.WHITE);
	    Panel2.setBackground(Color.BLACK);
		JScrollPane pane = new JScrollPane(actionPanel);
		pane.getVerticalScrollBar().setUnitIncrement(16);
	    


		
		FlowLayout b = new FlowLayout(FlowLayout.CENTER);
		Panel2.setLayout(b);
		FlowLayout c = new FlowLayout(FlowLayout.RIGHT);
		Panel3.setLayout(c);
		Panel2.add(Panel3);
		
		JLabel titre = new JLabel("Simulateur boursier");
		titre.setFont(new Font("Biko", Font.PLAIN, 37));
		titre.setForeground(Color.WHITE);
		panel4.setBackground(new Color(48, 46, 36));
		panel4.add(titre);
			
		
		JTabbedPane tabbedPane = new JTabbedPane();
		
	
		tabbedPane.addTab("Actions", pane);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		
   
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());
		mainPanel.add(tabbedPane);
		mainPanel.add(tabbedPane);
    
		JComponent panel2 = makeTextPanel("...");
		tabbedPane.addTab("Obligations", panel2);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_1);
    
		JComponent panel3 = makeTextPanel("...");
		tabbedPane.addTab("Produits dérivés", panel3);
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
        add(mainPanel);

        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        
        

		this.getContentPane().add("West",Panel1);
		this.getContentPane().add("South",Panel2);
		this.getContentPane().add("North",panel4);
		this.getContentPane().add("Center",tabbedPane);
		this.pack();
		this.setVisible(true);
		this.setSize(1100, 900);
        
        mSwingWorker chiller = new mSwingWorker();
		chiller.execute();
    }
		
	



	private void setOpacity(boolean b) {
		// TODO Auto-generated method stub
		
	}





	private JComponent makeTextPanel(String text) {
		JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
	}


	
	class Panneau extends JPanel {

		private static final long serialVersionUID = 1L;
	   
	    
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	
	public void showPortefeuil() {
		ArrayList<ProduitFinancier> produits = manager.getPortefeuil();
		actionPanel.removeAll();
        Iterator<ProduitFinancier> it = produits.iterator();
        
        //portfeuilStateLabel.setText(manager.getPortefeuilState());
        
        while(it.hasNext()) {
        	ProduitFinancier financier = (ProduitFinancier) it.next();
     	    actionPanel.add(new JLabel(financier.toString()));
        }
        
        revalidate();
	}
	
	
	class mSwingWorker extends SwingWorker<ArrayList<Societe>, Integer>
	{
	    protected ArrayList<Societe> doInBackground() throws Exception
	    {
	    	while(!this.isCancelled()) {
	   
	    		Thread.sleep(1000);
	    		System.out.println("salut");
		 	    return manager.calculateVariation();
	    	}
			return null;
	    	  
	    }

	    protected void done()
	    {
	    	
	    	if(showActions) {
	    		 try
	 	        {
	 	           actionPanel.removeAll();
	 	           ArrayList<Societe> bo = get();
	 	           Iterator<Societe> it = bo.iterator();
	 	           
	 	           portfeuilStateLabel.setText(manager.getPortefeuilState());
	 	           
	 	           while(it.hasNext()) {
	 	        	   Societe societe = (Societe) it.next();
	 	        	   if(societe.getIsGrowing()) {
	 	        		   actionPanel.add(new Cotation(societe, manager));
	 	        	   }else {
	 	        		   actionPanel.add(new Cotation(societe, manager));
	 	        	   }
	 	        	   
	 	           }
	 	           
	 	           revalidate();
	 	           callWorker();
	 	           
	 	        }
	 	        catch (Exception e)
	 	        {
	 	            e.printStackTrace();
	 	        }
	    	}
	       
	    }
	}
	
	
	 public void callWorker() {
		 if(showActions) {
			 mSwingWorker worker = new mSwingWorker();
			 worker.execute(); 
		 }
			
	}
	
}
