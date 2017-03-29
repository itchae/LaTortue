package turtle.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSlider;
import javax.swing.JTextArea;

import turtle.Model.UndoClass;


public class GoListener implements ActionListener{

	private UndoClass T;
	private JSlider S;
	private EcranCentral grille;
	private JTextArea textCommand;
	private LabelTempo error;
	
	public GoListener(UndoClass T, JSlider S ,EcranCentral grille,JTextArea textcommand,LabelTempo textError){
		this.T = T;
		this.S = S;
		this.grille = grille;
		this.textCommand = textcommand;
		this.error = textError;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(T.addGoCommand(S.getValue())){
			this.grille.repaint();
			this.textCommand.setText(""+T);
		}
		else{
			this.error.showText("Cette action fait sortir la tortue de la grille");
		}
	}
	
}
