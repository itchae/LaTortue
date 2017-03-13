package turtle.Model;

import java.awt.Rectangle;
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
		return "Direction [chemin=" + this.chemin + ", mouv="+this.getVectMouvement()+"]";
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
	
	/**
	 * renvoi un vecteur qui represente la diagonale du plus petit carre contenant la Direction selon le point d'origine 0,0
	 * @return
	 */
	public Rectangle getVectDiagonalRect(){
		Vecteur min = new Vecteur(0,0);
		Vecteur max = new Vecteur(0,0);
		Vecteur pointAct = new Vecteur(0,0);
		for(Vecteur v : this.chemin){
			pointAct = Vecteur.somme(pointAct, v);
			if(pointAct.getX() > max.getX()) max.setX(pointAct.getX());
			if(pointAct.getX() < min.getX()) min.setX(pointAct.getX());
			if(pointAct.getY() > max.getY()) max.setY(pointAct.getY());
			if(pointAct.getY() < min.getY()) min.setY(pointAct.getY());
			
		}
		return new Rectangle(min.getX(),min.getY(),max.getX()-min.getX() , max.getY()-min.getY());
		
	}
	
	/**
	 * donne le vecteur qui corespond au deplacement total de la direction
	 * @return
	 */
	public Vecteur getVectMouvement(){
		Vecteur pointAct = new Vecteur(0,0);
		for(Vecteur v : this.chemin){
			pointAct = Vecteur.somme(pointAct, v);
		}
		return pointAct;
	}

	

}