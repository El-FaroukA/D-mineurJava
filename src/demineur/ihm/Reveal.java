package demineur.ihm;

import java.awt.Color;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;

import demineur.metier.EtatCase;


/** 
 * 
 * @author El-Farouk Achirafi
 *
 */

@SuppressWarnings("serial")
public class Reveal extends JButton {
	
	private int mineVoisine;
	
	public Reveal(int mineVoisine) {
		
		super(" ");
		this.mineVoisine = mineVoisine;
		this.setPreferredSize(getPreferredSize());
		
	}
	
	/**retourne le nombre de mines dans les cases voisines
	 * 
	 * @return le nombre de mines dans les cases voisines
	 */
	
	public int getMineVoisine() { return this.mineVoisine; }
	
	/** 
	 * Donne les actions aux cases cliquées
	 * 
	 * @param etatcase l'etat des cases
	 * @param valeur le nombre de mines avoisinantes de la case
	 * @param isWin si le jeu est gagné
	 */
	
	public void revelation ( EtatCase etatcase, int valeur, boolean isWin) {
		
		//Importation image et bordure
		Border LoweredBevelBorder = BorderFactory.createLoweredBevelBorder();
		Border RaisedBevelBorder = BorderFactory.createRaisedBevelBorder();
		//Bombe
		ImageIcon ico1 = new ImageIcon( getClass().getResource("/demineurimages/images/images/bomb.jpg") );
		//Taille de la bombe
		 int w, h;
	     w = 35;
	     h = ico1.getIconHeight()*w/ico1.getIconWidth();

	     Image icoM = ico1.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT);
	     //Bombe miniaturisé
	     ImageIcon bomb = new ImageIcon(icoM);
	     
		if(etatcase == EtatCase.OUVERT) {
			
			this.setBorder(LoweredBevelBorder);
			if (valeur == -1 ) {
				
				if (isWin) {
					
					this.setBackground(Color.YELLOW);
	
				} else {
					
					this.setBackground(Color.RED);
					
				}
				this.setIcon(bomb);
				
				} else if (valeur == 0) {
					
					this.setBackground( Color.LIGHT_GRAY );
					this.setText(" ");
					
				} else if (valeur == 1) {
					
					this.setBackground( Color.LIGHT_GRAY );
					this.setText(""+valeur);
					this.setForeground(Color.BLUE);
						
				} else if (valeur == 2) {
					
					this.setBackground( Color.LIGHT_GRAY );
					this.setText(""+valeur);
					this.setForeground( Color.GREEN );
						
				} else if (valeur == 3) {
					
					this.setBackground( Color.LIGHT_GRAY );
					this.setText(""+valeur);
					this.setForeground( Color.RED );
						
					} else {
						
						this.setBackground( Color.LIGHT_GRAY );
						this.setForeground( Color.MAGENTA );
						
					}
		
		} else if (etatcase == EtatCase.MINE) {
			
			this.setBorder(RaisedBevelBorder);
			this.setText("‼");	
			
		} else if (etatcase == EtatCase.DOUTE) {
			
			this.setBorder(RaisedBevelBorder);
			this.setText("?");
			
		} else {
			
			this.setText(" ");
			
		}
			
	}	
}
