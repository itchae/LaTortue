package turtle.Model;


public class Command_turn extends Command {

	private int nb;
	
	public Command_turn (Tortue t,int nb){
		super(t);
		this.nb = nb;
	}
	
	public Command_turn(Tortue t){
		this(t,1);
	}

	public int getNb() {
		return this.nb;
	}

	@Override
	public boolean doAction() {
		this.getTortue().turn(this.getNb());
		return true;
	}

	@Override
	public void undoAction() {
		this.getTortue().getMotif().unturn(this.getNb());
		
	}

	@Override
	public String toString() {
		String txt = "Turn "+this.nb + "\n";
		return txt;
	}
	
	
	
	

}