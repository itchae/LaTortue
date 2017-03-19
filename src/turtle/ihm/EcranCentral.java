package turtle.ihm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import turtle.Model.Tortue;
import turtle.Model.Vecteur;

public class EcranCentral extends Grille {

	private static final long serialVersionUID = 2920717238864944340L;
	private Tortue t ;

	public EcranCentral(int colonne, int ligne , Tortue t) {
		super(colonne, ligne);
		this.t = t;
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics.create();
		super.paintComponent(g);
		Vecteur posTortue = this.t.getCoordonnee();
		int colonneTaille = this.getTailleColonne();
		 int ligneTaille = this.getTailleLigne();
		 //on concidere le 0,0 en bas a gauche
		g.setColor(Color.BLACK);
		g.fillOval((int)((posTortue.getX()-0.5)*colonneTaille),(int) ((this.getNbligne()-(posTortue.getY()+0.5))*ligneTaille), colonneTaille, ligneTaille);
		
	}
	
	

}
