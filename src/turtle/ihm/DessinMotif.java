package turtle.ihm;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import turtle.Model.Motif;
import turtle.Model.Vecteur;

public class DessinMotif extends Grille {

	private static final long serialVersionUID = -549604409144143552L;
	private static final int largeurCrayon = 3;
	public static Color  color= new Color(30,155,255);
	
	private Motif motif;


	public DessinMotif(Motif motif) {
		super(0,0);
		this.motif = motif;
		this.setPreferredSize(new Dimension(50,50));
		this.setBorder(new LineBorder(Color.BLACK));
		
	}
	
	private void calculTailleGrille(){
		Vecteur rectMinimal = motif.getVectDiagonalRect();
		this.setNbligne(rectMinimal.getY()+ 2);
		this.setNbcolonne(rectMinimal.getX()+ 2);
		if(this.getNbcolonne() %2 != 0) this.setNbcolonne(this.getNbcolonne()+1);
		if(this.getNbligne() %2 != 0) this.setNbligne(this.getNbligne()+1);
		
		
	}

	public Motif getMotif() {
		return this.motif;
	}

	public void setMotif(Motif motif) {
		this.motif = motif;
		this.repaint();			//force a redessiner
	}
	
	public void turn(){
		this.motif.turn();
		this.repaint();
	}

	
	@Override
	protected void paintComponent(Graphics graphics) {
		Graphics gra = graphics.create();

		this.calculTailleGrille();
		super.paintComponent(gra);
		
		Graphics2D g = (Graphics2D) gra;
		
		//calcul du pt origine et taille ligne et colonne
		//la taille de la grille ne change pas selon la rotation du motif
		//on concidere (0,0) au centre de l'�cran
		Vecteur mouvTotal = this.motif.getVectMouvement();
		Vecteur point = new Vecteur(-mouvTotal.getX()/2 , -mouvTotal.getY()/2);	//calcul du decalage pour centrer la figure sur le (0.0) fictif
		Iterator<Vecteur> i = this.motif.getIteratorDeplacement();
		
		
		
		int tailleColonne = this.getTailleColonne();
		int tailleLigne = this.getTailleLigne() ;
		int xZero = (int) (this.getNbcolonne()/2)*tailleColonne;	
		int yZero = (int) (this.getNbligne()/2)*tailleLigne;	
		
		g.setStroke(new BasicStroke(DessinMotif.largeurCrayon));
		g.setColor(DessinMotif.color);
		
		//dessin de la piece

		g.drawOval(xZero+(point.getX()*tailleColonne)-DessinMotif.largeurCrayon,yZero+(-point.getY()*tailleLigne)-DessinMotif.largeurCrayon, DessinMotif.largeurCrayon*2 , DessinMotif.largeurCrayon*2);
		while(i.hasNext()){
			Vecteur deplacement = i.next();
			int nextX =  point.getX()+deplacement.getX();
			int nextY = point.getY()+deplacement.getY();
			//les y sont inverser car normalement les y monte en descendant et la on concidere un repere avec y montant
			g.drawLine(xZero+(point.getX()*tailleColonne), yZero+(-point.getY()*tailleLigne),xZero+(nextX*tailleColonne), yZero+(-nextY*tailleLigne));
			point.setX(nextX);
			point.setY(nextY);
		}
	}
	
public static void main(String[] args){
	
	SwingUtilities.invokeLater(new Runnable(){
		
		@Override
		public void run() {
			JFrame f = new JFrame();
			f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			JPanel p = new JPanel();
			f.add(p);
			List<Motif> listMotif = Motif.getDefaultMotif();
			List<DessinMotif> listDessin = new ArrayList<DessinMotif>();
			for(Motif m : listMotif){
				DessinMotif dessin = new DessinMotif(m);
				p.add(dessin);
				listDessin.add(dessin);
			}
			JButton turn = new JButton("Turn");
			turn.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					for(DessinMotif m : listDessin){
						m.turn();
					}
				}
			});
			f.add(turn, BorderLayout.SOUTH);
			
			f.pack();
			f.setVisible(true);
			
		}
	});
		
	}
	
	

}
