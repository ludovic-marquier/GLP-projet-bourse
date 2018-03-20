package widget;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
 
public class MyButton extends JButton {
 
    private static final long serialVersionUID = 1L;
 
    public MyButton(String txt) {
        super(txt);
        //setBackground(new Color(30,250,40));
        
        setForeground(Color.WHITE);
         
        setOpaque(false);
        //setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
        setBorderPainted(false); // De même, on ne veut pas afficher les bordures.
        setFocusPainted(false); // On n'affiche pas l'effet de focus.
        
        setHorizontalAlignment(SwingConstants.CENTER);
        setHorizontalTextPosition(SwingConstants.CENTER);
       
         
        //setIcon(new ImageIcon(icon));
        //setRolloverIcon(new ImageIcon(iconHover));
    }
}