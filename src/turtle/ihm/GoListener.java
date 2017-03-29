package turtle.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSlider;

import turtle.Model.UndoClass;

public class GoListener implements ActionListener{

	private UndoClass T;
	private JSlider S;
	private EcranCentral grille;
	
	public GoListener(UndoClass T, JSlider S ,EcranCentral grille){
		this.T = T;
		this.S = S;
		this.grille = grille;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(T.addGoCommand(S.getValue())){
			this.grille.repaint();
		}
	}
	
}
