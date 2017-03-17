package turtle.ihm;

import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import turtle.Model.Tortue;

public class EcranGauche extends JPanel {

	private static final long serialVersionUID = -4991461646057125561L;
	private JTextArea textCommand;
	private JComponent blocInstruction;
	
	public EcranGauche(boolean debutant , Tortue t ,JComponent dessinMotif , JComponent afficheurCoul){
		this.textCommand = new TextInstruction();
		this.createBlocInstruction(debutant, t, dessinMotif,afficheurCoul);
		Box vBox = Box.createVerticalBox();
		vBox.add(this.textCommand);
		vBox.add(this.blocInstruction);
		this.add(vBox);
	}

	
	private void createBlocInstruction(boolean debutant , Tortue t ,JComponent dessinMotif, JComponent afficheurCoul){
		if(debutant){
			this.blocInstruction = new Instructions(t,dessinMotif,afficheurCoul);
		}
		else{
			this.blocInstruction = new Instructions(t,dessinMotif,afficheurCoul);
		}
	}

}
