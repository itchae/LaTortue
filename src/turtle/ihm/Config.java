package turtle.ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

public class Config extends JFrame{


	private static final long serialVersionUID = -2308639649954891679L;
	private JButton valid = new JButton("Valider");
	private JButton debutant = new JButton("Debutant");
	private JButton expert = new JButton("Expert");
	private JLabel vue = new JLabel("Choisissez votre vue");
	private JLabel tailleGrille = new JLabel("Choisissez le nombre de colonnes puis de ligne");
	private JLabel configuration = new JLabel("Configuration");
	private JSpinner tailleCo = new JSpinner(new SpinnerNumberModel(3,3,20,1));
	private JSpinner tailleLi = new JSpinner(new SpinnerNumberModel(3,3,20,1));
	
	public Config(){
		super();
		
		Box center = Box.createHorizontalBox();
		Box droite = Box.createVerticalBox();
		Box gauche = Box.createVerticalBox();
		
		this.add(configuration, BorderLayout.NORTH);
		
		droite.add(vue);
		droite.add(debutant);
		droite.add(expert);

		
		droite.add(tailleGrille);
		droite.add(tailleCo);
		droite.add(tailleLi);

		this.add(droite);
		this.add(valid, BorderLayout.SOUTH);
		
		this.setPreferredSize(new Dimension(200,200));
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	public static void main(String[] args) {

	SwingUtilities.invokeLater(new Runnable() {
		public void run () {new Config();}
	});
}
 







}
