package turtle.Model;

import java.awt.Color;
import java.util.List;

public class Command_Go extends Command {

	private int nb;
	private List<Vecteur> route;
	private boolean draw;
	private Color drawColor;

	public int getNb() {
		return this.nb;
	}
	
	public Command_Go(Tortue t,int nb){
		super(t);
		this.nb = nb;
		this.route = null;
	}
	
	public Command_Go(Tortue t){
		this(t,1);
	}

	@Override
	public boolean doAction() {
		 
		 boolean t = true;
			try{
				this.route = this.getTortue().go(this.getNb());
				this.draw = this.getTortue().getDraw();
				this.drawColor = this.getTortue().getColor();
			}
			catch(Exception e){
				t= false;
			}
			return t;
	}

	@Override
	public void undoAction() {
		this.getTortue().ungo(this.getNb());
	}
	
	/**
	 * les points de passage de la tortue pendant ce go
	 * @return
	 */
	public List<Vecteur> getRoute(){
		return this.route;
	}

	/**
	 * savoir si le draw de la tortue était activer ou pas
	 * @return
	 */
	public boolean isDraw() {
		return this.draw;
	}

	/**
	 * la couleur de la tortue pendant ce deplacement
	 * @return
	 */
	public Color getDrawColor() {
		return this.drawColor;
	}
	
	@Override
	public String toString() {
		String txt = "Go "+this.nb + "\n";
		return txt;
	}
	
	

}