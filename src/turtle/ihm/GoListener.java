package turtle.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JSlider;

import turtle.Model.Tortue;

public class GoListener implements ActionListener{

	private Tortue T;
	private JSlider S;
	private EcranCentral grille;
	
	public GoListener(Tortue T, JSlider S ,EcranCentral grille){
		this.T = T;
		this.S = S;
		this.grille = grille;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.grille.addPoint(T.go(S.getValue()), T.getDraw(), T.getColor());
		this.grille.repaint();
	}
	
}
