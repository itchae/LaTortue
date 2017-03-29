package turtle.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JSlider;

import turtle.Model.UndoClass;

public class TurnListener implements ActionListener{

	private UndoClass T;
	private JSlider S;
	private JComponent dessinMotif;
	
	public TurnListener(UndoClass T, JSlider S, JComponent dessinMotif){
		this.T = T;
		this.S = S;
		this.dessinMotif = dessinMotif;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(T.addTurnCommand(S.getValue())){
			dessinMotif.repaint();
		}
	}
	
}
