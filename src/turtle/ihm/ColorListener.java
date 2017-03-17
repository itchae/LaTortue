package turtle.ihm;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

import turtle.Model.Tortue;

public class ColorListener extends MouseAdapter {

	private Tortue T;
	private JComponent afficheur;
	
	public ColorListener (Tortue tortue, JComponent afficheur){
		this.T = tortue;
		this.afficheur=afficheur;
	}

	
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if(o instanceof JComponent){	
			JComponent couleurSel = (JComponent)o;
			afficheur.setBackground(couleurSel.getBackground());
			T.setColor(couleurSel.getBackground());
		}
		else{
			System.err.println("Un listener MotifClicListener n'est pas associé à un DessinMotif");
		}
		
	}

	
}
