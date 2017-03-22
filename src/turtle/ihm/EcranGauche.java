package turtle.ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import turtle.Model.Tortue;

public class EcranGauche extends JPanel {

	private static final long serialVersionUID = -4991461646057125561L;
	private JTextArea textCommand;
	private JScrollPane scrollText;
	private JComponent blocInstruction;
	
	public EcranGauche(boolean debutant , Tortue t ,JComponent dessinMotif , JComponent afficheurCoul,EcranCentral grille){
		super(new BorderLayout());
		this.textCommand = new TextInstruction();
		this.createBlocInstruction(debutant, t, dessinMotif,afficheurCoul,grille);
		Box vBox = Box.createVerticalBox();
		this.scrollText = new JScrollPane(this.textCommand);
		vBox.add(this.scrollText);
		vBox.add(this.blocInstruction);
		this.add(vBox);
	}

	
	private void createBlocInstruction(boolean debutant , Tortue t ,JComponent dessinMotif, JComponent afficheurCoul,EcranCentral grille){
		if(debutant){
			this.blocInstruction = new Instructions(t,dessinMotif,afficheurCoul,grille);
			this.textCommand.setEditable(false);
		}
		else{
			this.blocInstruction = new Instructions(t,dessinMotif,afficheurCoul,grille);
		}
	}


	@Override
	public void setPreferredSize(Dimension preferredSize) {
		// TODO Auto-generated method stub
		super.setPreferredSize(preferredSize);
		this.scrollText.setPreferredSize(new Dimension(preferredSize.width,(int) (preferredSize.height*0.6)));
		this.blocInstruction.setPreferredSize(new Dimension(preferredSize.width,(int) (preferredSize.height*0.4)));
	}



	
	

}
