package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.GameManager;


public class FenetreAcceuil extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
    private JButton commencer = new JButton("Commencer");
    JComboBox<String> combo = new JComboBox<String>();

  
    
 
    
    public FenetreAcceuil() {
    
    	
    	
	    String[] tab = {"Niveau Facile", "Niveau Intermediaire", "Niveau Difficile"};
	    combo = new JComboBox<String>(tab);
	    
		
	    this.setTitle("Simulateur boursier");
		panel1.add(new JLabel("Selectionner un niveau de difficulté"));
		combo.setPreferredSize(new Dimension(600,100));
		panel2.add(combo);
		panel2.add(commencer);
		commencer.addActionListener(this);
		
		

		this.getContentPane().setLayout(new GridLayout(3,1));
		this.getContentPane().add(panel1);
		this.getContentPane().add(panel2);
		this.getContentPane().add(panel3);
		this.pack();
		panel1.setBackground(new Color(173, 216, 230));
		panel2.setBackground(new Color(173, 216, 230));
		panel3.setBackground(new Color(173, 216, 230));
		this.setSize(800, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);

	}
	

	public void actionPerformed(ActionEvent e) {
		String choix = (String) combo.getSelectedItem();
		GameManager manager = new GameManager();
		manager.start(choix);
		super.dispose();
		this.setVisible(false);
	}
	
	public class DegradPanel extends JPanel {

		private static final long serialVersionUID = 1L;

	    public DegradPanel() {
	        super();
	    }
	    public void paint(Graphics _g) {
	        super.paintComponent(_g);
	        Graphics2D g = (Graphics2D) _g;
	 
	        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	        Rectangle bounds = getBounds();
	        Paint gradientPaint = new GradientPaint(0, bounds.y, Color.WHITE,0, bounds.y + bounds.width, Color.BLUE);
	        g.setPaint(gradientPaint);
	        g.fillRect(0, 0, bounds.width, bounds.height);
	    }
	}
	 
		    
}