package turtle.Model;

public class OutOfGridException extends Exception{

	private static final long serialVersionUID = 6556539468329048068L;

	public OutOfGridException(){
		System.out.println("Oups votre tortue � manqu� de tomb� de la grille !");
	}
}
