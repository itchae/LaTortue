package turtle.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JSlider;

import turtle.Model.Tortue;

public class GoListener implements ActionListener{

	private Tortue T;
	private JSlider S;
	private JComponent grille;
	
	public GoListener(Tortue T, JSlider S ,JComponent grille){
		this.T = T;
		this.S = S;
		this.grille = grille;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		T.go(S.getValue());
		this.grille.repaint();
	}
	
}
