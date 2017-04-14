package turtle.Model;

public class Vecteur {

	private int x;
	private int y;
	
	public Vecteur (int x , int y){
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "<" + this.x + "," + this.y + ">";
	}
	
	/**
	 * Somme v1 et v2
	 * @param v1
	 * @param v2
	 * @return un vecteur égal à la somme de v1 et v2
	 */
	public static Vecteur somme(Vecteur v1 , Vecteur v2){
		return new Vecteur(v1.getX()+v2.getX() , v1.getY()+ v2.getY());
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vecteur other = (Vecteur) obj;
		if (this.x != other.x)
			return false;
		if (this.y != other.y)
			return false;
		return true;
	}
	
	
	
	

}