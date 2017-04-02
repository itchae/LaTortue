package turtle.ihm;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextArea;

import turtle.Model.UndoClass;

public class MotifClicListener extends MouseAdapter {
	
	private UndoClass undo ;
	private JTextArea textCommand;
	
	public MotifClicListener(UndoClass undo ){
		this.undo = undo;
		this.textCommand = null;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if(o instanceof DessinMotif){
			DessinMotif motif = (DessinMotif)o;
			this.undo.addMotifCommand(motif.getMotif());
			try{
				this.textCommand.setText(""+this.undo);
			}
			catch(NullPointerException excep){
				
			}
		}
		else{
			System.err.println("Un listener MotifClicListener n'est pas associé à un DessinMotif");
		}
		
	}

	public void setTextCommand(JTextArea textCommand) {
		this.textCommand = textCommand;
	}
	
	

	

}
