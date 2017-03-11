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
		return "(x=" + this.x + ", y=" + this.y + ")";
	}
	
	public static Vecteur somme(Vecteur v1 , Vecteur v2){
		return new Vecteur(v1.getX()+v2.getX() , v1.getY()+ v2.getY());
	}
	
	

}