package turtle.Model;

import java.awt.Color;

public class Command_Color extends Command {

	private Color color;
	private Color oldColor;
	
	public Command_Color(Tortue t,Color c){
		super(t);
		this.color = c;
		this.oldColor = t.getColor();
	}

	public Color getColor() {
		return this.color;
	}

	@Override
	public boolean doAction() {
		this.getTortue().setColor(this.getColor());
		return true;
	}

	@Override
	public void undoAction() {
		this.getTortue().setColor(this.oldColor);
		
	}
	
	

}