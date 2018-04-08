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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;

import dataClasses.Devise;
import dataClasses.Evenement;
import dataClasses.ProduitFinancier;
import dataClasses.Societe;
import gui.MainGui.SwingChiller;
import main.GameManager;
import widget.Cotation;
import widget.MyButton;
import widget.ObligationLabel;
import widget.Position;

public class FenetreJeu extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private GameManager manager;
	
	private Container container;
	
	private JPanel Panel1 = new JPanel();
	private JPanel Panel2 = new JPanel();
	private JPanel Panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	private JPanel eventPanel = new JPanel();
	private JPanel obligationPanel = new JPanel(new GridLayout(61,1));
	
	private JLabel portfeuilStateLabel = new JLabel();
	
	private ArrayList<Societe> societes = new ArrayList<Societe>();
	private ArrayList<ProduitFinancier> produits = new ArrayList<ProduitFinancier>();
	private ArrayList<Devise> devises = new ArrayList<Devise>();
	//private ArrayList<Societe> societes = new ArrayList<Societe>();
	private ArrayList<Evenement>evenements = new ArrayList<Evenement>();
	
	private JPanel actionPanel;
	private Boolean showActions = true;
	private Boolean showFavoris = false;
	private String csv ="";
	int i = 0;
	private Boolean first = true;
	static final Logger logger = Logger.getRootLogger();
	
	
	
	public FenetreJeu(GameManager manager, String niveau) {
		
		this.setVisible(false);
	    this.setTitle("Simulateur boursier");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setContentPane(new JLabel());
	  
	    this.setBackground(new Color(173, 216, 230));
	    Panel1.setBackground(new Color(173, 216, 230));
	    container = this.getContentPane();
	   
	    
	    BorderLayout bord = new BorderLayout();
	    bord.setHgap(50);
	    bord.setVgap(50);
	    container.setLayout(bord);
	    
	    this.manager = manager;
	    
	    JLabel titreActu =new JLabel(" Actualité en temps réel : ");
	    titreActu.setFont(new Font("Biko", Font.PLAIN, 20));
	    eventPanel.setBackground(new Color(255,255,255));
	    eventPanel.setLayout(new GridLayout(10,1));
	    eventPanel.add(titreActu);
	    //eventPanel.setBorder(new MyBorder());
	    
	    ImageIcon warnIcon = new ImageIcon(new ImageIcon("data/actualite.png").getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT));
	    JButton FilDActualite = new JButton(warnIcon);
	    
	    ImageIcon warnIcon2 = new ImageIcon(new ImageIcon("data/portefeuille.png").getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT));
	    JButton Portefeuille = new JButton(warnIcon2);
	    
	    ImageIcon warnIcon3 = new ImageIcon(new ImageIcon("data/favoris.png").getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT));
	    JButton  Favoris= new JButton(warnIcon3);
	   
	  
	    Panel1.add(FilDActualite);
	    
	    
	    
	    FilDActualite.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) { 
	    		  showFavoris = false;
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
	    		    first =true;
	    		    showPortefeuil();
	    		  } 
	    		} );
	    
	    
	    Panel1.add(Favoris);
	    Favoris.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) { 
	    		  actionPanel.removeAll();
	    		  revalidate();
	    		  showFavoris =true;
	    		  first = true;
	    		  } 
	    		} );
	    
	   
	    Panel1.setLayout(new GridLayout(4,1));
	    
	    JLabel niveauLabel = new JLabel("Niveau de difficulté : "
	    		+ niveau);
	    niveauLabel.setFont(new Font("Biko", Font.PLAIN, 20));

	    portfeuilStateLabel.setFont(new Font("Biko", Font.PLAIN, 27));
	    portfeuilStateLabel.setForeground(Color.WHITE);
	    Panel1.add(niveauLabel);
	    Panel2.setBackground(new Color(48, 46, 36));
	    Panel2.add(portfeuilStateLabel);
	  
	 
	    actionPanel = new JPanel(new GridLayout(61,1));
	    actionPanel.setBackground(Color.WHITE);
	    Panel2.setBackground(Color.BLACK);
		JScrollPane pane = new JScrollPane(actionPanel);
		pane.getVerticalScrollBar().setUnitIncrement(16);
		
		JScrollPane pane3 = new JScrollPane(obligationPanel);
		pane3.getVerticalScrollBar().setUnitIncrement(16);


		
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
    
		JComponent panel2 = makeTextPanel("...");
		tabbedPane.addTab("Obligations", pane3);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
    
		JComponent panel3 = makeTextPanel("...");
		tabbedPane.addTab("Produits dérivés", panel3);
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
        add(tabbedPane);

        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        
        

		this.getContentPane().add("West",Panel1);
		this.getContentPane().add("South",Panel2);
		this.getContentPane().add("North",panel4);
		this.getContentPane().add("Center",tabbedPane);
		this.getContentPane().add("East", eventPanel);
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
		revalidate();
 
        Iterator it2 = this.societes.iterator();
        
        portfeuilStateLabel.setText(manager.getPortefeuilState());
        
        if(produits.size() == 0) {
        	actionPanel.add(new JLabel("Vous n'avez pas de produits financier dans votre portefeuille pour le moment"));
        }
        
        while(it2.hasNext()) {
        	Societe societe = (Societe)it2.next();
        	int occurence = 0;
            Iterator<ProduitFinancier> it = produits.iterator();
        	 while(it.hasNext()) {
        		ProduitFinancier produit = it.next();
 
        		if(produit.getParentId().equals(societe.getId())) {
        			occurence++;
        		}
          	    
             }
        	 System.out.println(societe.getId());
        	 if(occurence != 0) {
        		 Position position = new Position(societe, this.manager, occurence);
        		 position.setFont(new Font("Geometos", Font.PLAIN, 14));
        		 actionPanel.add(position);
        	 }
        }
       
        revalidate();
	}
	
	
	class mSwingWorker extends SwingWorker<Void, Integer>
	{
	    protected Void doInBackground() throws Exception
	    {
	    	while(!this.isCancelled()) {
	    		
	    		evenements = manager.updateEvenements();
	    		societes = manager.calculateVariation();
	    		produits = manager.getPortefeuil();
	    
	    		
	    
	    		Thread.sleep(1000);
	    		
	    		  return null;
	    	}
	    	
	    	  return null;
	    }

	    protected void done()
	    {
	    	eventPanel.removeAll();
	    	if(showActions) {
	    		 try
	 	        {
	 	           actionPanel.removeAll();
	 	           obligationPanel.removeAll();
	 	           
	 	           
	 	           first = false;
	 	          
	 	           //ArrayList<Societe> bo = get();
	 	           Iterator<Societe> it = societes.iterator();
	 	           Iterator it2 = evenements.iterator();
	 	           
	 	           portfeuilStateLabel.setText(manager.getPortefeuilState());
	 	           
	 	           while(it.hasNext()) {
	 	        	   Societe societe = (Societe) it.next();
	 	        	   if(showFavoris) {
	 	        		   if(manager.getFavoris().contains(societe)) {
	 	        			   displaySociete(societe, true);
	 	        		   }else {
	 	        			   revalidate();
	 	        		   }
	 	        	   }else {
	 	        		   displaySociete(societe, false);
	 	        	   }
	 	        	   
	 	        	   if(societe.getNom().equals("SpaceX")) {
	 	        		   csv =i+","+societe.getPrixDAction();
	 	        		   bounce();
	 	        	   }
	 	           }
	 	 
	 	        JLabel titreActu =new JLabel(" Actualité en temps réel : ");
	 	 	    titreActu.setFont(new Font("Biko", Font.PLAIN, 20));
	 	 	    eventPanel.add(titreActu);
	 	          for(int i =0 ; i<evenements.size(); i++) {
	 	        	   Evenement evenement = evenements.get(i);
	 	        	   eventPanel.add(new JLabel(evenement.toString()));
	 	        	  revalidate();
	 	           }
	 	           
	 	           revalidate();
	 	           callWorker();
	 	           
	 	        }
	 	        catch (Exception e)
	 	        {
	 	            e.printStackTrace();
	 	        }
	    	}else {
	    		showPortefeuil();
	    	}
	       
	    }
	}
	
	
	 public void callWorker() {
		 if(showActions) {
			 mSwingWorker worker = new mSwingWorker();
			 worker.execute(); 
			 i++;
			 
		 }
			
	}
	 
	 public void displaySociete(Societe societe, Boolean fav) {
		   Cotation cotation = new Cotation(societe, manager, fav);
 		   cotation.setFont(new Font("Geometos", Font.PLAIN, 14));
 		   actionPanel.add(cotation);
 		   if(societe.getHasObligations()) {
 			   ObligationLabel label = new ObligationLabel(societe, manager, fav);
 			   label.setFont(new Font("Geometos", Font.PLAIN, 14));
 			   obligationPanel.add(label);
 		   }
 		   
	 }
	 
	 
	 public void bounce() {
		 try {
			 File fout = new File("test.csv");
				FileOutputStream fos = new FileOutputStream(fout, true);
			 
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

					bw.write(csv);
					bw.newLine();
			
			 
				bw.close();
			}catch(IOException e) {
			 
		 }
	 }
	
}
