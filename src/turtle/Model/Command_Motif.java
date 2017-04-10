package turtle.Model;

import java.util.Iterator;

public class Command_Motif extends Command {

	private Motif ancienMotif;
	private Motif nouveauMotif;
	
	public Command_Motif(Tortue t ,Motif nouv ) {
		super(t);
		this.ancienMotif = t.getMotif();
		this.nouveauMotif = nouv;
	}

	@Override
	public boolean doAction() {
		this.getTortue().setMotif(this.nouveauMotif);
		return true;
	}

	@Override
	public void undoAction() {
		this.getTortue().setMotif(this.ancienMotif);
	}

	@Override
	public String toString() {
		String txt = "Motif <";
		Iterator<Vecteur> i = this.nouveauMotif.getIteratorDeplacement();
		while(i.hasNext()){
			Vecteur v = i.next();
			txt += v;
		}
		txt += ">\n";
		return txt;
	}
	
	

}
