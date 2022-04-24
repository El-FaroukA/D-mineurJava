package demineur.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import demineur.metier.Demineur;

/** 
 * 
 * @author El-Farouk Achirafi
 *
 */

@SuppressWarnings("serial")
public class InterfaceDemineurMVP extends JFrame {
	
	private JPanel contentPane;
	private JPanel grandCentre;
	private Reveal[] caseAcocher;
	private int largeur = 10;
	private int hauteur = 5;
	private int niveau  = 2;
	private Demineur demineur = new Demineur(largeur, hauteur, niveau);	
	private JLabel auteur = new JLabel("El-Farouk Achirafi ☜(ﾟヮﾟ☜)");
	private JButton reset;
	private int reponse;
	
	/**
	 * Affiche l'interface du demineur
	 */
	public InterfaceDemineurMVP() {
		
		super("Demineur v1.0 El-Farouk Achirafi");	
		//this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		//Paramètrage panel ouest
		
		JPanel ouest = new JPanel();
		ouest.setBackground(Color.white);
		
		//Paramètrage panel est
		
		JPanel est = new JPanel();
		est.setBackground(Color.white);
		
		//Création du menu
		JMenuBar menuB = new JMenuBar();
		this.setJMenuBar(menuB);
		
		JMenu menu = new JMenu("Partie");
		menuB.add(menu);
		
		JMenuItem menuI = new JMenuItem("Réinitialiser");
		menuI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				actionReset(largeur, hauteur, niveau);
			}
		});
		menu.add(menuI);
		
		menu.addSeparator();
		
		menuI = new JMenuItem("Quitter");
		menuI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				actionQuitter();
			}
		});
		menu.add(menuI);
		
		//Menu modification du jeu === Niveau
		
		menu = new JMenu("Niveau");
		menuB.add(menu);
				
		//Niveau 1
					menuI = new JMenuItem("1");
					menuI.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							InterfaceDemineurMVP.this.actionReset(largeur, hauteur, 1);
						}
					}); 
					
					menu.add(menuI);
					
					menu.addSeparator();
				
		//Niveau 2
						menuI = new JMenuItem("2");
						menuI.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								InterfaceDemineurMVP.this.actionReset(largeur, hauteur, 2);
							}
						}); 
						
						menu.add(menuI);
						
						menu.addSeparator();
						
		//Niveau 3
						menuI = new JMenuItem("3");
						menuI.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								InterfaceDemineurMVP.this.actionReset(largeur, hauteur, 3);
							}
						}); 
						
						menu.add(menuI);
						
						menu.addSeparator();
						
		//Niveau 4
						menuI = new JMenuItem("4");
						menuI.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								InterfaceDemineurMVP.this.actionReset(largeur, hauteur, 4);
							}
						}); 
						
						menu.add(menuI);
						
						menu.addSeparator();
		//Niveau 5
						menuI = new JMenuItem("5");
						menuI.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								InterfaceDemineurMVP.this.actionReset(largeur, hauteur, 5);
							}
						}); 
						
						menu.add(menuI);
		
		// Menu aide et crédits
		menu = new JMenu("?");
		menuB.add(menu);
		
		menuI = new JMenuItem("Aide");
		menuI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				actionAide();
			}
		});
		
		menu.add(menuI);
		
		menu.addSeparator();
		
		menuI = new JMenuItem("Crédits");
		menuI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionCredit();
			}
		});
		
		menu.add(menuI);

		
		
		//Assemblage des composants
		
		Border RaisedBevelBorder2 = BorderFactory.createRaisedBevelBorder();
		contentPane = new JPanel();
		contentPane.setBorder(RaisedBevelBorder2);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(ouest, BorderLayout.WEST);
		contentPane.add(est, BorderLayout.EAST);
		setContentPane(contentPane);

		this.addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				actionQuitter();
			}
		});
		
		actionReset(this.largeur, this.hauteur, this.niveau);
		if(this.reponse == JOptionPane.NO_OPTION)
			System.exit(0);
		
		//Mise en page
		
		this.pack();
	}
	
	
	/**
	 * Permet de relancer ou lancer une partie
	 * 
	 * @param x = la largeur
	 * @param y = la hauteur
	 * @param z = le niveau
	 */

	public void actionReset (int x, int y , int z) {
		
		 reponse = JOptionPane.showConfirmDialog(this, 
				"Lancer une nouvelle partie ?",
				"Nouvelle Partie",
				JOptionPane.YES_NO_OPTION, 
				JOptionPane.WARNING_MESSAGE);
		
		if (reponse == JOptionPane.YES_OPTION) {
			
			if ( x != largeur || y != hauteur || z != niveau ) {
				this.largeur = x;
				this.hauteur = y;
				this.niveau  = z;
				this.demineur = new Demineur(x, y, z);
			} else {
				this.demineur.initialiser();
			}
			
			Border LoweredBevelBorder = BorderFactory.createLoweredBevelBorder();
			this.grandCentre = new JPanel();
			this.grandCentre.setLayout(new GridLayout(y, x));
			this.grandCentre.setBorder(LoweredBevelBorder);

			
			this.caseAcocher = new Reveal[this.largeur*this.hauteur];
			for (int i=0; i<this.caseAcocher.length; i++) {
				
				this.caseAcocher[i] = new Reveal(i);
				this.caseAcocher[i].addMouseListener( new MouseAdapter() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						
						InterfaceDemineurMVP.this.actionCase(e);
					}
				});
				this.caseAcocher[i].addFocusListener(new FocusListener() {
					
					public void focusLost(FocusEvent e) {
					}
					public void focusGained(FocusEvent e) {
						
						InterfaceDemineurMVP.this.requestFocus();
						
					}
				});
				this.grandCentre.add( this.caseAcocher[i] );
			}
			this.setVisible(false);
			contentPane.removeAll();
			contentPane.add(grandCentre, BorderLayout.CENTER);
			
			this.reset = new JButton("Nouvelle Partie");
			this.reset.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					
					InterfaceDemineurMVP.this.actionReset(largeur, hauteur, niveau);
				}
			});
			
			//Création partie Nord
			
			int mine = 0;
			//1=5%, 2=10%, 3=15%, 4=20%, 5 ou plus = 25%
			if (this.niveau < 1) {
				mine = 1; 
			} else if (this.niveau >= 5) {
				// 25% de mines (level max)
				mine = (int)Math.floor((largeur*hauteur)*0.25);
			} else {
				// 1=5%, 2=10%, 3=15%, 4=20%
				mine = (int)Math.floor( 0.05*this.niveau*(this.largeur*this.hauteur) );
			}
			if (mine < 1) {
				mine = 1;
			}
			
			JLabel mineRest = new JLabel("Mine(s) à trouver = "+mine);
			
			Border RaisedBevelBorder = BorderFactory.createRaisedBevelBorder();
			JPanel nord = new JPanel();
			nord.setLayout(new FlowLayout());
			nord.setBorder(RaisedBevelBorder);
			nord.add(mineRest);
			
			//Création partie sud
			
			JPanel sud = new JPanel();
			sud.setLayout(new FlowLayout());
			sud.setBorder(RaisedBevelBorder);
			sud.add(this.auteur);
			sud.add(this.reset);
			
			//Ajout partie sud et nord à contentPane
			contentPane.add(sud, BorderLayout.SOUTH);
			contentPane.add(nord, BorderLayout.NORTH);
			this.pack();
			this.setVisible(true);
			
		} else if (reponse == JOptionPane.NO_OPTION){
			
		} 
	}
	
	/**
	 * Permet de quitter l'application
	 * 
	 */
	
	public void actionQuitter() {

		int reponse = JOptionPane.showConfirmDialog(this, 
				"Si vous quittez maintenant, \ntoutes votre progression sera perdue.\nVoulez vous vraiment quitter l'application ?",
				"Voulez-vous quitter ?",
				JOptionPane.YES_NO_OPTION, 
				JOptionPane.WARNING_MESSAGE);
		System.out.println(reponse);
		
		if(reponse == JOptionPane.YES_OPTION) {
			
			this.dispose();
			
		} else if (reponse == JOptionPane.NO_OPTION){
			
		}
	}
	
	/**
	 * Permet d'accéder à l'aide
	 */
	
	public void actionAide() {
		
		JOptionPane.showMessageDialog(this, "<html> <h1>Bienvenue dans l'aide du démineur version El-Farouk Achirafi ! </h1><h2>Tu ne connais pas les règles du jeu ?, laisse moi te les expliquer.<h2> <p> <b>Le but du démineur est simple. <br/>Il faut découvrir toutes les cases libres sans faire exploser les mines présentes dans la grille.<br/> Pour découvrir une case, faire un clic gauche (clic normal) sur une des cases présentes sur la grille.<br/>En cliquant sur une case, vous pourrez savoir le nombre de mines se trouvant dans les cases voisines (8 au maximum) qui l'entourent à gauche ou à droite, en haut ou en bas, ou en diagonale.<br/> Attention certaines cases cachent une bombe et d'autres cases n'en cachent pas.<br/>Grâce aux indications données par les chiffres, vous pouvez libérer d''autres cases.<br/> Par exemple, si  le chiffre 2 est affiché il permet de deviner qu'il y a deux mines voisines qui l'entourent.<br/>Un drapeau peut aussi etre placé (clic droit), pouvant potentiellement (ou sûrement) cacher une bombe. Jouez donc une partie pour mieux comprendre les règles.<br/></p><html>",
				"Aide du jeu",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Permet d'accéder aux crédits
	 */
	
	public void actionCredit() {
		
		JOptionPane.showMessageDialog(this,
				"<html><h1>El-Farouk Achirafi</h1><p>Copyright<b> 2021</b></p><html>", 
				"Crédits",
				JOptionPane.INFORMATION_MESSAGE);
		
	}
	
		/** Permet de donner des actions aux clics de la souris
		 * 
		 * @param e = les clics de la souris
		 */
	
	public void actionCase(MouseEvent e) {
		
		if ( e.getSource() instanceof Reveal) {
			
			Reveal but = (Reveal)e.getSource();
			
			if ( ! but.contains( e.getPoint() ) ) {
				
				return;
			}
			
			if ( e.getButton() == MouseEvent.BUTTON1 ) {
				
				this.demineur.retourner(but.getMineVoisine());
				
			} else if ( e.getButton() == MouseEvent.BUTTON3 ) {
				
				this.demineur.marquer(but.getMineVoisine());
				
			}
			
			this.resultat();
		}
	}
	
	/**
	 * Donne le resultat du clic
	 */
	
	public void resultat() {

		if(this.demineur.isPartiePerdue()) {
			
			JOptionPane.showMessageDialog(this, "Vous avez perdu ! 😭");
			
		}
		
		if(this.demineur.isPartieTerminee() && !this.demineur.isPartiePerdue()) {
			
			JOptionPane.showMessageDialog(this, "Félicitation vous avez gagné ! 😎");
			
		}
		
		for (int i=0; i<this.caseAcocher.length; i++) {
			
			this.caseAcocher[i].revelation(this.demineur.getEtat(i), this.demineur.getValeur(i), !this.demineur.isPartiePerdue() );
			
		}
	}
	
}
