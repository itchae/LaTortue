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

	public EcranCentral(int colonne, int ligne , UndoClass t) {
		super(colonne, ligne);
		this.t = t;
		this.origine = t.getTortue().getCoordonnee();
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics.create();
		super.paintComponent(g);
		this.drawChemin(g);
		Vecteur posTortue = this.t.getTortue().getCoordonnee();
		int colonneTaille = this.getTailleColonne();
		 int ligneTaille = this.getTailleLigne();
		 //on concidere le 0,0 en bas a gauche
		 
		g.setColor(this.t.getTortue().getColor());
		g.fillOval((int)((posTortue.getX()-0.5)*colonneTaille),(int) ((this.getNbligne()-(posTortue.getY()+0.5))*ligneTaille), colonneTaille, ligneTaille);
		
	}
	
	private void drawChemin(Graphics gra){
		Vecteur position = this.origine;
		Graphics2D g = (Graphics2D)gra.create();
		g.setStroke(new BasicStroke(4));
		
		List<List<Vecteur>> points = this.t.getPoints();
		List<Boolean> draw = this.t.getDrawPoints();
		List<Color> color = this.t.getColorPoints();
		
		for (int i=0 ; i<points.size() ; i++){
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
	}
	
	private void drawLine(Vecteur origine ,Vecteur fin , Graphics2D g){
		int colonneTaille = this.getTailleColonne();
		 int ligneTaille = this.getTailleLigne();
		 int xDeb = origine.getX()*colonneTaille;
		 int yDeb = (this.getNbligne()-origine.getY())*ligneTaille;

		 int xFin = fin.getX()*colonneTaille;
		 int yFin = (this.getNbligne()-fin.getY())*ligneTaille;
		 g.drawLine(xDeb, yDeb, xFin, yFin);
	}
	

	
	

}
