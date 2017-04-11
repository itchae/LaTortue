package turtle.ihm.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JTextArea;

import turtle.Model.Commands;
import turtle.Model.Motif;
import turtle.Model.UndoClass;
import turtle.ihm.DessinMotif;
import turtle.ihm.LabelTempo;

public class LecteurListener implements ActionListener {
	
	private JTextArea command;
	private UndoClass undo;
	private LabelTempo error;
	private  JComponent grille;
	private DessinMotif motifActuel;
	private JComponent couleur;

	public LecteurListener(JTextArea command , UndoClass undo , LabelTempo error ,JComponent grille,JComponent motifActuel,JComponent couleur) {
		this.command = command;
		this.undo = undo;
		this.error = error;

		this.grille = grille;
		if( motifActuel instanceof DessinMotif){
			this.motifActuel =(DessinMotif) motifActuel;
		}
		this.couleur = couleur;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		List<String[]> commandeText = Commands.splitTextCommand(this.command.getText());
		if(Commands.verifTextCommand(commandeText)){
			this.doCommand(commandeText);
			this.updateComposant();
		}
		else{
			this.error.showText("Il y a une erreur dans les commandes");
		}
		
	}
	
	private void updateComposant(){
		this.grille.repaint();
		try{
			this.motifActuel.setMotif(this.undo.getTortue().getMotif());
			this.motifActuel.repaint();
		}
		catch(NullPointerException e){
			
		}
		this.couleur.setBackground(this.undo.getTortue().getColor());
	}
	
	
	
	private void doCommand(List<String[]> nouv ){
		this.undo.clear();
		this.command.setText("");
		boolean juste = true;
		for(String[] ligne : nouv){
			if(!this.addCommand(ligne)){
				ligne[0] = "//"+ligne[0];
				juste = false;
			}
			this.command.setText(this.command.getText()+ligne[0]);
			for(int i=1 ; i<ligne.length ; i++){
				this.command.setText(this.command.getText()+" "+ligne[i]);
			}
			this.command.setText(this.command.getText()+"\n");
		}
		if(!juste){
			this.error.showText("Une commande a été mis en commentaire car elle cause la sorti de la tortue");
		}
		
	}
	
	private boolean addCommand(String[] ligne){
		boolean ok = true;
		switch(Commands.valueOf(ligne[0].toUpperCase())){
		case COLOR: int red = Integer.parseInt(ligne[1]);
					int green = Integer.parseInt(ligne[2]);
					int blue = Integer.parseInt(ligne[3]);
					this.undo.addColorCommand(new Color(red,green,blue));
			break;
		case DRAW: this.undo.addDrawCommand(ligne[1].equalsIgnoreCase("true"));
			break;
		case GO:	ok = this.undo.addGoCommand(Integer.parseInt(ligne[1]));
			break;
		case TURN:	ok = this.undo.addTurnCommand(Integer.parseInt(ligne[1]));
			break;
		case MOTIF: Motif k = Motif.createMotif(ligne[1].substring(1, ligne[1].length()-1));
			ok = this.undo.addMotifCommand(k);
			break;
		default: System.err.println(ligne[0]+" n'est pas codé");
			break;
		
		}
		return ok;
	}
	
	


}
