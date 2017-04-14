package turtle.ihm;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import turtle.Model.UndoClass;
import turtle.Model.Vecteur;

public class EcranCentral extends Grille {

	private static final long serialVersionUID = 2920717238864944340L;
	private UndoClass t ;
	private Vecteur origine;
	private int arretNbPointAvant;

	public EcranCentral(int colonne, int ligne , UndoClass t) {
		super(colonne, ligne);
		this.t = t;
		this.arretNbPointAvant = 0;
		this.origine = t.getTortue().getCoordonnee();
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics.create();
		super.paintComponent(g);
		this.drawChemin(g);
	}
	
	/**
	 * dessine la torue
	 * @param gra module graphics
	 * @param pos position de la tortue
	 * @param coul couleur de la tortue
	 */
	private void dessinTortue(Graphics gra , Vecteur pos ,Color coul){
		Graphics2D g = (Graphics2D)gra.create();
		Vecteur posTortue =  pos;
		if(this.arretNbPointAvant == 0){
			this.t.getTortue().getCoordonnee();
			coul = this.t.getTortue().getColor();
		}
		int colonneTaille = this.getTailleColonne();
		 int ligneTaille = this.getTailleLigne();
		 //on concidere le 0,0 en bas a gauche
		 
		g.setColor(coul);
		g.fillOval((int)((posTortue.getX()-0.5)*colonneTaille),(int) ((this.getNbligne()-(posTortue.getY()+0.5))*ligneTaille), colonneTaille, ligneTaille);
		
	}
	
	/**
	 * dessine le chemin de la tortue + la tortue
	 * @param gra
	 */
	private void drawChemin(Graphics gra){
		Vecteur position = this.origine;
		Graphics2D g = (Graphics2D)gra.create();
		g.setStroke(new BasicStroke(4));
		
		List<List<Vecteur>> points = this.t.getPoints();
		List<Boolean> draw = this.t.getDrawPoints();
		List<Color> color = this.t.getColorPoints();
		
		for (int i=0 ; i<points.size() - this.arretNbPointAvant ; i++){
			if(draw.get(i).booleanValue()){
				g.setColor(color.get(i));
				for(Vecteur v : points.get(i)){
					this.drawLine(position,v,g);
					position = v;
				}
			}
			else{
				position = points.get(i).get(points.get(i).size()-1);
			}
		}
		Color coulTortue;
		try{
			coulTortue = color.get(points.size() - this.arretNbPointAvant );
		}
		catch(Exception e){
			coulTortue = this.t.getTortue().getColor();
		}
		this.dessinTortue(g,position,coulTortue);
	}
	
	/**
	 * dessine un vecteur sur la grille
	 * @param origine
	 * @param fin
	 * @param g
	 */
	private void drawLine(Vecteur origine ,Vecteur fin , Graphics2D g){
		int colonneTaille = this.getTailleColonne();
		 int ligneTaille = this.getTailleLigne();
		 int xDeb = origine.getX()*colonneTaille;
		 int yDeb = (this.getNbligne()-origine.getY())*ligneTaille;

		 int xFin = fin.getX()*colonneTaille;
		 int yFin = (this.getNbligne()-fin.getY())*ligneTaille;
		 g.drawLine(xDeb, yDeb, xFin, yFin);
	}

	/**
	 * modifie le cran d'arret du dessin du chemin de la tortue
	 * @param arretNbPointAvant
	 */
	public void setArretNbPointAvant(int arretNbPointAvant) {
		if(arretNbPointAvant >=0){
			this.arretNbPointAvant = arretNbPointAvant;
		}
		else{
			this.arretNbPointAvant = 0;
		}
		
	}
	
	
	
	

}
