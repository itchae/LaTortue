package turtle.Model;


public abstract class Command {
	
	private Tortue t;
	
	public Command(Tortue t){
		this.t = t;
	}
	
	public abstract boolean doAction();
	public abstract void undoAction();
	
	protected Tortue getTortue(){
		return this.t;
	}
}