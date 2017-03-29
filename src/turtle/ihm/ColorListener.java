package turtle.ihm;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

import turtle.Model.UndoClass;

public class ColorListener extends MouseAdapter {

	private UndoClass T;
	private JComponent afficheur;
	
	public ColorListener (UndoClass tortue, JComponent afficheur){
		this.T = tortue;
		this.afficheur=afficheur;
	}

	
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if(o instanceof JComponent){	
			JComponent couleurSel = (JComponent)o;
			afficheur.setBackground(couleurSel.getBackground());
			T.addColorCommand(couleurSel.getBackground());
		}
		else{
			System.err.println("Un listener MotifClicListener n'est pas associé à un DessinMotif");
		}
		
	}

	
}
