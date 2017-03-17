package turtle.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JSlider;

import turtle.Model.Tortue;

public class turnListener implements ActionListener{

	private Tortue T;
	private JSlider S;
	private JComponent dessinMotif;
	
	public turnListener(Tortue T, JSlider S, JComponent dessinMotif){
		this.T = T;
		this.S = S;
		this.dessinMotif = dessinMotif;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		T.turn(S.getValue());
		dessinMotif.repaint();
	}
	
}
