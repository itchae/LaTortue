package turtle.ihm;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JTextArea;

import turtle.Model.UndoClass;

public class ColorListener extends MouseAdapter {

	private UndoClass T;
	private JComponent afficheur;
	private JTextArea textCommand;
	private JComponent grille;
	
	public ColorListener (UndoClass tortue, JComponent afficheur ,JTextArea textCommand , JComponent grille){
		this.T = tortue;
		this.afficheur=afficheur;
		this.textCommand = textCommand;
		this.grille = grille;
	}

	
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if(o instanceof JComponent){	
			JComponent couleurSel = (JComponent)o;
			afficheur.setBackground(couleurSel.getBackground());
			T.addColorCommand(couleurSel.getBackground());
			this.textCommand.setText(""+T);
			this.grille.repaint();
		}
		else{
			System.err.println("Un listener MotifClicListener n'est pas associé à un DessinMotif");
		}
		
	}

	
}
