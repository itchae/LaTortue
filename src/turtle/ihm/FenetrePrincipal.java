package turtle.ihm;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import turtle.Model.Tortue;

public class FenetrePrincipal extends JFrame {
	
	private static final long serialVersionUID = -219028337465163564L;
	private JLabel textEtat;
	private JComponent central;
	private JComponent droite;
	private Tortue tortue;

	public FenetrePrincipal(){
		super();
		this.textEtat = new LabelTempo(3000);
		this.central = new EcranCentral(10,10);
		this.tortue = new Tortue();
		this.droite = new EcranDroite(this.tortue,this);
		
		this.add(this.central);
		this.add(this.droite,BorderLayout.EAST);
		this.add(this.textEtat , BorderLayout.SOUTH);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	
	public static void main(String[] args){
		
		SwingUtilities.invokeLater(new Runnable(){
			
			@Override
			public void run() {
				JFrame f = new FenetrePrincipal();
				f.pack();
				f.setVisible(true);
				
			}
		});
	}

}
