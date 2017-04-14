package turtle.ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.border.LineBorder;


abstract class Grille extends JComponent {
	

	private static final long serialVersionUID = -7649907374135164257L;
	private int nbligne;
	private int nbcolonne;
	
	public Grille(int colonne, int ligne){
		super();
		this.nbcolonne = colonne;
		this.nbligne = ligne;

		this.setBorder(new LineBorder(Color.BLACK));
	}
	
	
	@Override
	protected void paintComponent (Graphics graphics){
		Graphics gra = graphics.create();
		int xmax = (int) this.getSize().getWidth();
		int ymax = (int) this.getSize().getHeight();
		for (int i=0; i<nbcolonne;i++){		
			int x = xmax/nbcolonne*i;
			gra.drawLine(x, 0, x, ymax);
		}
		for (int j=0; j<nbligne ; j++){
			int y = ymax/nbligne*j;
			gra.drawLine(0, y, xmax, y);
		}
		//force la grille à avoir la taille correcte
		this.setSize(new Dimension(this.getNbcolonne()*this.getTailleColonne() , this.getNbligne()*this.getTailleLigne()));
	}


	public int getNbligne() {
		return this.nbligne;
	}


	public int getNbcolonne() {
		return this.nbcolonne;
	}
	
	protected int getTailleLigne(){
		return (int) this.getSize().getHeight()/this.nbligne;
	}
	
	protected int getTailleColonne(){
		return (int) this.getSize().getWidth()/this.nbcolonne;
	}


	protected void setNbligne(int nbligne) {
		this.nbligne = nbligne;
	}


	protected void setNbcolonne(int nbcolonne) {
		this.nbcolonne = nbcolonne;
	}
	
	
	

}
