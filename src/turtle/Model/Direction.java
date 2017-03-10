package turtle.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Direction {

	private List<Vecteur> chemin;
	
	public Direction (List<Vecteur> deplacement){
		this.chemin = new ArrayList<Vecteur>();
		for(Vecteur v : deplacement){
			this.chemin.add(v);
		}
	}
	
	public Iterator<Vecteur> getIteratorDeplacement(){
		return this.chemin.iterator();
	}
	
	/**
	 * permet de calculer la direction où l'on commence par la fin du chemin
	 * @return
	 */
	public Direction inverseSens(){
		List <Vecteur> newChemin = new ArrayList<Vecteur>();
		for(Vecteur v : this.chemin){
			newChemin.add(0,new Vecteur(v.getY(),v.getX()));
		}
		
		return new Direction(newChemin);
	}
	
	/**
	 * renvoi la direction qui resulte d'une rotation de -90 degres de la direction
	 * @return
	 */
	public Direction rotation(){
		List <Vecteur> newChemin = new ArrayList<Vecteur>();
		for(Vecteur v : this.chemin){
			newChemin.add(new Vecteur(v.getY() , -v.getX()));
		}
		return  new Direction(newChemin);
	}

	@Override
	public String toString() {
		return "Direction [chemin=" + this.chemin + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Direction other = (Direction) obj;
		if (this.chemin == null) {
			if (other.chemin != null)
				return false;
		} else if (!this.chemin.equals(other.chemin))
			return false;
		return true;
	}

	

}