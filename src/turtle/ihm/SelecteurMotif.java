package turtle.ihm;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import turtle.Model.Motif;
import turtle.Model.Tortue;

public class SelecteurMotif extends JPanel {

	private static final long serialVersionUID = 8883297560974887620L;
	private List<DessinMotif> motifs;
	
	public SelecteurMotif(List<Motif> listMotif , Tortue tortue ,DessinMotif dessinActuel){
		this.motifs = new ArrayList<DessinMotif>();
		MotifClicListener motifListener = new MotifClicListener(tortue);
		UpdateSelectedMotifListener updateDessin = new UpdateSelectedMotifListener(dessinActuel);
		
		for(Motif m : listMotif){
			DessinMotif dessin = new DessinMotif(m);
			this.motifs.add(dessin);
			this.add(dessin);
			dessin.addMouseListener(motifListener);
			dessin.addMouseListener(updateDessin);
		}
	}

}
