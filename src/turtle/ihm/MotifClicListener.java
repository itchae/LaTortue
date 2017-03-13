package turtle.ihm;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import turtle.Model.Tortue;

public class MotifClicListener extends MouseAdapter {
	
	private Tortue tortue ;
	
	public MotifClicListener(Tortue tortue){
		this.tortue = tortue;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if(o instanceof DessinMotif){
			DessinMotif motif = (DessinMotif)o;
			tortue.setMotif(motif.getMotif());
		}
		else{
			System.err.println("Un listener MotifClicListener n'est pas associé à un DessinMotif");
		}
		
	}

	

}
