package turtle.ihm;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JComponent;

public class ResizeWindow extends ComponentAdapter  {
	
	private JComponent droite,gauche,central;

	public ResizeWindow(JComponent droite , JComponent c , JComponent gauche){
		this.droite = droite;
		this.central = c;
		this.gauche = gauche;
	}

	@Override
	public void componentResized(ComponentEvent e) {
		int hauteur = e.getComponent().getHeight();
		int largeur = e.getComponent().getWidth();
		Dimension taillePanneau = new Dimension((int) (largeur*0.2) , hauteur);
		this.droite.setPreferredSize(taillePanneau);
		this.gauche.setPreferredSize(taillePanneau);
		this.central.setPreferredSize(new Dimension((int) (largeur*0.6) , hauteur));
		
	}

}
