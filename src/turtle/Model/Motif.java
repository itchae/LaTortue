package turtle.Model;

import java.util.ArrayList;
import java.util.List;

public class Motif {

	private List<Direction> listDir;
	private int dirActuel;
	
	public Motif(List<Vecteur> deplacement){
		this.listDir = new ArrayList<Direction>();
		this.dirActuel = 0;
		this.listDir.add(new Direction (deplacement));
		this.listDir.add(this.listDir.get(0).inverseSens());
		for(int i =0 ; i< 3 ; i++){
			this.listDir.add(this.listDir.get(0+2*i).rotation());
			this.listDir.add(this.listDir.get(1+2*i).rotation());
		}
	}
	

	/**
	 * permet de passer à la direction suivante
	 */
	public void turn() {
		if(this.listDir.size() >1){
			this.dirActuel = (this.dirActuel+1)%this.listDir.size();
		}
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
	
	public static void main(String[] args){
		List<Vecteur> chemin = new ArrayList<Vecteur>();
		chemin.add(new Vecteur(0,2));
		chemin.add(new Vecteur(1,0));
		Motif m = new Motif(chemin);
		System.out.println(m);
	}
	
	

}