package turtle.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Motif {

	private List<Direction> listDir;
	private int dirActuel;
	
	public Motif(List<Vecteur> deplacement){
		this.listDir = new ArrayList<Direction>();
		this.dirActuel = 0;
		this.listDir.add(new Direction (deplacement));
		this.addDirection(this.listDir.get(0).inverseSens());
		

		for(int i =0 ; i <this.listDir.size() ; i++){	//calcul des rotations possible
			this.addDirection(this.listDir.get(i).rotation());		
		}
	}
	
	
	private void addDirection(Direction d){
		if(!this.listDir.contains(d)){
			this.listDir.add(d);
		}
	}
	

	/**
	 * permet de passer à la direction suivante
	 */
	public void turn() {
		this.dirActuel = (this.dirActuel+1)%this.listDir.size();		
	}


	@Override
	public String toString() {
		String text = "Motif choisi :"+this.dirActuel;
		int i =0;
		for (Direction d : this.listDir){
			text += "\n Numero "+i+" :" +d;
			i++;
		}
		return text;
	}
	
	
	
	public Iterator<Vecteur> getIteratorDeplacement(){
		return this.listDir.get(this.dirActuel).getIteratorDeplacement();
	}
	
	
	/**
	 * renvoie un vecteur qui represente la diagonale du plus petit carre contenant la Direction selon le point d'origine 0,0
	 * @return
	 */
	public Vecteur getVectDiagonalRect(){

		return this.listDir.get(this.dirActuel).getVectDiagonalRect();
		
	}
	
	/**
	 * Donne le vecteur qui corespond au deplacement total du motif actuel
	 * @return
	 */
	public Vecteur getVectMouvement(){
		return this.listDir.get(this.dirActuel).getVectMouvement();
	}
	
	
	public static List<Motif> getDefaultMotif(){
		List<Motif> motifs = new ArrayList<Motif>();
		List<Vecteur> chemin = new ArrayList<Vecteur>();
		chemin.add(new Vecteur(0,2));
		chemin.add(new Vecteur(1,0));
		motifs.add( new Motif(chemin));
		
		chemin.clear();
		chemin.add( new Vecteur(1,0));
		motifs.add( new Motif(chemin));
		
		chemin.clear();
		chemin.add( new Vecteur(1,1));
		motifs.add( new Motif(chemin));
		
		chemin.clear();
		chemin.add( new Vecteur(1,1));
		chemin.add( new Vecteur(-1,1));
		chemin.add( new Vecteur(-1,-1));
		motifs.add( new Motif(chemin));
		
		chemin.add(new Vecteur(1,-1));
		motifs.add( new Motif(chemin));
		
		chemin.clear();
		chemin.add( new Vecteur(1,1));
		chemin.add( new Vecteur(0,1));
		chemin.add( new Vecteur(1,-1));
		motifs.add( new Motif(chemin));
		
		return motifs;
	}
	
	

}