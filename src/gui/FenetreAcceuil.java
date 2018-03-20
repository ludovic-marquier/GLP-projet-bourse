package gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


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
		panel3.add(commencer);
		commencer.addActionListener(this);
		
		
		this.getContentPane().setLayout(new GridLayout(3,1));
		this.getContentPane().add(panel1);
		this.getContentPane().add(panel2);
		this.getContentPane().add(panel3);
		this.pack();
		this.setVisible(true);

	}
	
	public static void main(String[] args){ 
		FenetreAcceuil f = new FenetreAcceuil();
		f.setVisible(true);
	}
	

	public void actionPerformed(ActionEvent e) {
		
	}
		    
}