package turtle.Model;


public class Command_Draw extends Command {

	private boolean enable;
	private boolean oldState;
	
	public Command_Draw (Tortue t ,boolean b){
		super(t);
		this.enable = b;
		this.oldState = t.getDraw();
	}

	public boolean isEnable() {
		return this.enable;
	}

	@Override
	public boolean doAction() {
		this.getTortue().setDraw(this.isEnable());
		return true;
	}

	@Override
	public void undoAction() {
		this.getTortue().setDraw(this.oldState);
		
	}	

}