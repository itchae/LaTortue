package turtle.Model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Tortue {

	private Color color;
	private Vecteur coordonnee;
	private boolean draw;
	private Motif motif;
	private int xmax; 
	private int ymax;
	
	
	public Tortue(int xmax, int ymax){
		this.color = Color.BLACK;
		this.coordonnee = new Vecteur(0,0);
		this.draw = false;
		this.motif = null;
		this.xmax = xmax; 
		this.ymax = ymax; 
		
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Vecteur getCoordonnee() {
		return this.coordonnee;
	}

	public boolean getDraw() {
		return this.draw;
	}

	public void setMotif(Motif motif) {
		this.motif = motif;
	}

	public void goException(int xdep, int ydep) throws OutOfGridException{
		if(xdep>this.xmax && ydep>this.ymax){
			throw new OutOfGridException();
		}
	}
	
	/**
	 * Execute go, si draw = true alors dessine motif sinon juste déplacement tortue 
	 * @param k
	 * @throws OutOfGridException 
	 */
	public List<Vecteur> go() throws OutOfGridException {
		List<Vecteur> liste = new ArrayList<Vecteur>();
		Vecteur tmp = this.coordonnee;
		if(draw){
			Iterator<Vecteur> i = motif.getIteratorDeplacement();
			while (i.hasNext()){
				Vecteur v = i.next();
				tmp = Vecteur.somme(tmp, v);
				goException(tmp.getX(), tmp.getY());
				liste.add(this.coordonnee);
			}
			this.coordonnee = tmp;
		}else{
			tmp = Vecteur.somme(this.coordonnee, motif.getVectMouvement());
			goException(tmp.getX(), tmp.getY());
			this.coordonnee = tmp;
			liste.add(this.coordonnee);
		}
		return liste;
	}

	/**
	 * Execute k fois go
	 * @param k
	 * @throws OutOfGridException 
	 */
	public List<Vecteur> go(int k) throws OutOfGridException {
		List<Vecteur> liste = new ArrayList<Vecteur>();
		for(int i = 0 ; i<k ; i++){
			liste.addAll(this.go());
		}
		return liste;
	}

	
	/**
	 * Tourne le motif
	 * @param k
	 */
	public void turn() {
		this.motif.turn();
	}

	
	/**
	 * Tourne le motif k fois
	 * @param k
	 */
	public void turn(int k) {
		for (int i = 0 ; i<k ; i++){
			this.turn();
		}
	}

	/**
	 * 
	 * @param enable
	 */
	public void setDraw(boolean enable) {
		this.draw = enable;
	}
	
	public Motif getMotif(){
		return this.motif;
	}

}