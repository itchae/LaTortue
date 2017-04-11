package turtle.ihm.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTextArea;

import turtle.Model.UndoClass;
import turtle.ihm.DessinMotif;

public class UndoListener implements ActionListener {

	private UndoClass undoModule;
	private JComponent grille;
	private JTextArea textCommand;
	private JComponent motifActuel;
	private JComponent couleur;
	private JCheckBox drawBox;
	
	public UndoListener(UndoClass undo , JComponent grille , JTextArea text ,JComponent motifActuel , JComponent couleur ,JCheckBox draw) {
		this.undoModule = undo;
		this.grille = grille;
		this.textCommand = text;
		this.motifActuel = motifActuel;
		this.couleur = couleur;
		this.drawBox = draw;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.undoModule.undo();
		//refresh tout
		this.grille.repaint();
		this.textCommand.setText(""+this.undoModule);
		if(this.motifActuel instanceof DessinMotif){
			DessinMotif m = (DessinMotif) this.motifActuel;
			m.setMotif(this.undoModule.getTortue().getMotif());
		}
		this.motifActuel.repaint();
		this.drawBox.setSelected(this.undoModule.getTortue().getDraw());
		this.couleur.setBackground(this.undoModule.getTortue().getColor());
		
	}

}
