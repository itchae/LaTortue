package turtle.ihm.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.JTextArea;

import turtle.Model.UndoClass;
import turtle.ihm.LabelTempo;

public class TurnListener implements ActionListener{

	private UndoClass T;
	private JSlider S;
	private JComponent dessinMotif;
	private JTextArea textCommand;
	private LabelTempo error;
	
	public TurnListener(UndoClass T, JSlider S, JComponent dessinMotif ,JTextArea textcommand,LabelTempo error){
		this.T = T;
		this.S = S;
		this.dessinMotif = dessinMotif;
		this.textCommand = textcommand;
		this.error = error;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(T.addTurnCommand(S.getValue())){
			dessinMotif.repaint();
			this.textCommand.setText(""+T);
		}
		else{
			this.error.showText("Cette action fait sortir la tortue de la grille");
		}
	}
	
}
