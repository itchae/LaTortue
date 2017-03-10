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
	
	

}