package turtle.Model;


public abstract class Command {
	
	private Tortue t;
	
	public Command(Tortue t){
		this.t = t;
	}
	/**
	 * execute la commande
	 * @return
	 */
	public abstract boolean doAction();
	
	/**
	 * annule la commande
	 */
	public abstract void undoAction();
	
	/**
	 * 
	 * @return la tortue
	 */
	protected Tortue getTortue(){
		return this.t;
	}
}