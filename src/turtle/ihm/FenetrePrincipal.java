package turtle.ihm;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import turtle.Model.Tortue;
import turtle.Model.UndoClass;

public class FenetrePrincipal extends JFrame {
	
	private static final long serialVersionUID = -219028337465163564L;
	private LabelTempo textEtat;
	private EcranCentral central;
	private EcranDroite droite;

	private EcranGauche gauche;
	private Tortue tortue;
	private UndoClass undo;

	public FenetrePrincipal(boolean debutant , int xMaxGrid ,int yMaxGrid){
		super();


		this.tortue = new Tortue(xMaxGrid, yMaxGrid);
		this.undo = new UndoClass(this.tortue);
		this.textEtat = new LabelTempo(3000);
		this.central = new EcranCentral(xMaxGrid,yMaxGrid, this.undo);
		this.droite = new EcranDroite(this.undo,this);
		this.gauche = new EcranGauche(debutant,this.undo , this.droite.getMotifActuel() , this.droite.getColorPanel(),this.central,this.textEtat);
		this.droite.createUndoListener(this.central, this.gauche.getTextCommand(),this.droite.getMotifActuel(),this.droite.getColorPanel(),this.gauche.getDrawBox());
		
		this.add(this.central);
		this.add(this.droite,BorderLayout.EAST);
		this.add(this.textEtat , BorderLayout.SOUTH);
		this.add(this.gauche,BorderLayout.WEST);
		this.textEtat.setHorizontalAlignment(JLabel.CENTER);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.addComponentListener(new ResizeWindow(this.droite,this.central,this.gauche));
		
	}
	
	
	public static void main(String[] args){
		
		SwingUtilities.invokeLater(new Runnable(){
			
			@Override
			public void run() {
				//JFrame f = new FenetrePrincipal(true,10,10);
				JFrame f = new FenetrePrincipal(true,10,10);
				f.pack();
				f.setVisible(true);
				
			}
		});
	}

}
