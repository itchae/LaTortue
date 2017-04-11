package turtle.ihm.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import turtle.ihm.DessinMotif;


public class UpdateSelectedMotifListener extends MouseAdapter {
	
	private DessinMotif motif;

	public UpdateSelectedMotifListener(DessinMotif motif){
		this.motif = motif;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if(o instanceof DessinMotif){
			DessinMotif motif = (DessinMotif)o;
			this.motif.setMotif(motif.getMotif());
		}
		else{
			System.err.println("Un listener UpdateSelectedMotifListener n'est pas associé à un DessinMotif");
		}
		
	}
}
