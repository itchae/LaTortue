package turtle.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSlider;

import turtle.Model.Tortue;

public class GoListener implements ActionListener{

	private Tortue T;
	private JSlider S;
	
	public GoListener(Tortue T, JSlider S){
		this.T = T;
		this.S = S;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		T.go(S.getValue());
	}
	
}
