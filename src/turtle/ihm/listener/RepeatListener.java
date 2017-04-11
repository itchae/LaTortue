package turtle.ihm.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import turtle.Model.UndoClass;
import turtle.ihm.DrawThread;
import turtle.ihm.EcranCentral;

public class RepeatListener implements ActionListener {
	
	private JComponent grille;
	private UndoClass undo;
	private boolean actif;

	public RepeatListener(JComponent grille , UndoClass undo ) {
		this.grille = grille;
		this.undo = undo;
		this.actif = false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if(this.grille instanceof EcranCentral && !this.actif){
			DrawThread t = new DrawThread((EcranCentral)this.grille,this.undo, this);
			this.actif = true;
			t.start();
		}
		
		
	}

	public void setInactif() {
		this.actif = false;
	}

	
}
