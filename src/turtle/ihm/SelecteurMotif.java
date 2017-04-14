package turtle.ihm;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import turtle.Model.Motif;
import turtle.Model.UndoClass;
import turtle.ihm.listener.MotifClicListener;
import turtle.ihm.listener.UpdateSelectedMotifListener;

public class SelecteurMotif extends JPanel {

	private static final long serialVersionUID = 8883297560974887620L;
	private List<DessinMotif> motifs;
	private MotifClicListener motifListener;
	
	public SelecteurMotif(List<Motif> listMotif ,UndoClass undo ,DessinMotif dessinActuel){
		this.motifs = new ArrayList<DessinMotif>();
		this.motifListener = new MotifClicListener(undo);
		UpdateSelectedMotifListener updateDessin = new UpdateSelectedMotifListener(dessinActuel);
		
		for(Motif m : listMotif){
			DessinMotif dessin = new DessinMotif(m);
			this.motifs.add(dessin);
			this.add(dessin);
			dessin.addMouseListener(motifListener);
			dessin.addMouseListener(updateDessin);
		}
	}
	
	/**
	 * ajoute le text area pour la mise a jour du texte des commande à la selection d'un motif
	 * @param text
	 */
	public void addTextCommandRefresh(JTextArea text){
		this.motifListener.setTextCommand(text);
	}

}
