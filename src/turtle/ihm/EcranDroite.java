package turtle.ihm;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import turtle.Model.Motif;
import turtle.Model.Tortue;

public class EcranDroite extends JPanel {
	
	private static final long serialVersionUID = 521106232148146111L;
	private SelecteurMotif selecteur;
	private DessinMotif motifActuel;
	private JPanel couleurActuel;
	private List<JButton> buttons; 

	public EcranDroite(Tortue tortue , JFrame fenetre){
		super(new BorderLayout());
		this.motifActuel = new DessinMotif(tortue.getMotif());
		this.selecteur = new SelecteurMotif(Motif.getDefaultMotif(),tortue , this.motifActuel);
		this.couleurActuel = new JPanel();
		this.couleurActuel.setPreferredSize(this.motifActuel.getPreferredSize());
		this.couleurActuel.setBackground(DessinMotif.color);
		this.buttons = new ArrayList<JButton>();
		this.buttons.add(new JButton("Init"));
		this.buttons.add(new JButton("Undo"));
		this.buttons.add(new JButton("Replay"));
		this.buttons.add(new JButton("Quit"));
		this.buttons.get(3).addActionListener(new QuitActionListener(fenetre));
		
		Box vBox = Box.createVerticalBox();
		this.add(vBox);
		JScrollPane scroll = new JScrollPane(this.selecteur);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		vBox.add(scroll);
		Box hBox = Box.createHorizontalBox();
		vBox.add(Box.createVerticalGlue());
		vBox.add(hBox);
		hBox.add(this.motifActuel);
		hBox.add(this.couleurActuel);
		
		JPanel buttonPanel = new JPanel(new GridLayout(2,2));
		vBox.add(Box.createVerticalGlue());
		vBox.add(buttonPanel);
		for(JButton b : this.buttons){
			buttonPanel.add(b);
		}
		
		
	}

	public static void main(String[] args){
		
		SwingUtilities.invokeLater(new Runnable(){
			
			@Override
			public void run() {
				JFrame f = new JFrame();
				f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				f.add(new EcranDroite(new Tortue(),f));
				f.pack();
				f.setVisible(true);
				
			}
		});
	}
}
