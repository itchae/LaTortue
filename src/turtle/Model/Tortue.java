package turtle.Model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public class Tortue {

	private Color color;
	private Vecteur coordonnee;
	private boolean draw;
	private Motif motif;
	
	public Tortue(){
		this.color = Color.BLACK;
		this.coordonnee = new Vecteur(0,0);
		this.draw = false;
		this.motif = Motif.getDefaultMotif().get(0);
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

	
	/**
	 * Execute go, si draw = true alors dessine motif sinon juste déplacement tortue 
	 * @param k
	 */
	public List<Vecteur> go() {
		List<Vecteur> liste = new ArrayList<Vecteur>();
		if(draw){
			while (motif.getIteratorDeplacement().hasNext()){
				Vecteur v = motif.getIteratorDeplacement().next();
				this.coordonnee = Vecteur.somme(this.coordonnee, v);
				liste.add(this.coordonnee);
			}
		}else{
			this.coordonnee = Vecteur.somme(this.coordonnee, motif.getVectMouvement());
			liste.add(this.coordonnee);
		}
		return liste;
	}

	/**
	 * Execute k fois go
	 * @param k
	 */
	public List<Vecteur> go(int k) {
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