package turtle.ihm;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import turtle.Model.Tortue;

public class FenetrePrincipal extends JFrame {
	
	private static final long serialVersionUID = -219028337465163564L;
	private JLabel textEtat;
	private JComponent central;
	private EcranDroite droite;

	private JComponent gauche;
	private Tortue tortue;

	public FenetrePrincipal(boolean debutant){
		super();

		this.tortue = new Tortue();
		this.textEtat = new LabelTempo(3000);
		this.central = new EcranCentral(10,10, this.tortue);
		this.droite = new EcranDroite(this.tortue,this);
		this.gauche = new EcranGauche(debutant,this.tortue , this.droite.getMotifActuel() , this.droite.getColorPanel(),this.central);
		
		this.add(this.central);
		this.add(this.droite,BorderLayout.EAST);
		this.add(this.textEtat , BorderLayout.SOUTH);
		this.add(this.gauche,BorderLayout.WEST);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.addComponentListener(new ResizeWindow(this.droite,this.central,this.gauche));
		
	}
	
	
	public static void main(String[] args){
		
		SwingUtilities.invokeLater(new Runnable(){
			
			@Override
			public void run() {
				JFrame f = new FenetrePrincipal(true);
				f.pack();
				f.setVisible(true);
				
			}
		});
	}

}
