package turtle.ihm;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import turtle.Model.Tortue;
import turtle.Model.Vecteur;

public class EcranCentral extends Grille {

	private static final long serialVersionUID = 2920717238864944340L;
	private Tortue t ;
	private List<List<Vecteur>> points;
	private Vecteur origine;
	private List<Boolean> draw;
	private List<Color> color;

	public EcranCentral(int colonne, int ligne , Tortue t) {
		super(colonne, ligne);
		this.t = t;
		this.points = new ArrayList<List<Vecteur>>();
		this.origine = t.getCoordonnee();
		this.draw = new ArrayList<Boolean>();
		this.color = new ArrayList<Color>();
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics.create();
		super.paintComponent(g);
		this.drawChemin(g);
		Vecteur posTortue = this.t.getCoordonnee();
		int colonneTaille = this.getTailleColonne();
		 int ligneTaille = this.getTailleLigne();
		 //on concidere le 0,0 en bas a gauche
		 
		g.setColor(Color.BLACK);
		g.fillOval((int)((posTortue.getX()-0.5)*colonneTaille),(int) ((this.getNbligne()-(posTortue.getY()+0.5))*ligneTaille), colonneTaille, ligneTaille);
		
	}
	
	private void drawChemin(Graphics gra){
		Vecteur position = this.origine;
		Graphics2D g = (Graphics2D)gra.create();
		g.setStroke(new BasicStroke(4));
		for (int i=0 ; i<this.points.size() ; i++){
			if(this.draw.get(i).booleanValue()){
				g.setColor(this.color.get(i));
				for(Vecteur v : this.points.get(i)){
					this.drawLine(position,v,g);
					position = v;
				}
			}
			else{
				position = this.points.get(i).get(this.points.get(i).size()-1);
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
	
	public void addPoint (List<Vecteur> point,boolean draw , Color color){
		this.points.add(point);
		this.draw.add(new Boolean(draw));
		this.color.add(color);
	}
	
	

}
