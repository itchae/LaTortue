package turtle.ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
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
	private JScrollPane scroll;

	public EcranDroite(Tortue tortue , JFrame fenetre){
		super(new BorderLayout());
		List<Motif> listMotif = Motif.getDefaultMotif();
		tortue.setMotif(listMotif.get(0));
		this.motifActuel = new DessinMotif(tortue.getMotif());
		this.selecteur = new SelecteurMotif(listMotif,tortue , this.motifActuel);
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
		this.scroll = new JScrollPane(this.selecteur);
		this.scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		vBox.add(this.scroll);
		Box hBox = Box.createHorizontalBox();
		vBox.add(Box.createRigidArea(new Dimension(0,10)));
		vBox.add(hBox);
		hBox.add(this.motifActuel);
		hBox.add(this.couleurActuel);
		
		GridLayout grid = new GridLayout(2,2);
		grid.setHgap(5);
		grid.setVgap(5);
		JPanel buttonPanel = new JPanel(grid);
		vBox.add(Box.createRigidArea(new Dimension(0,10)));
		vBox.add(buttonPanel);
		for(JButton b : this.buttons){
			buttonPanel.add(b);
		}
		
		
	}

	
	public JComponent getMotifActuel() {
		return this.motifActuel;
	}
	
	public JComponent getColorPanel(){
		return this.couleurActuel;
	}
	
	


	@Override
	public void setPreferredSize(Dimension preferredSize) {
		
		super.setPreferredSize(preferredSize);
		this.selecteur.setPreferredSize(new Dimension((int) (preferredSize.width*0.8),preferredSize.height));
		this.scroll.setPreferredSize(new Dimension (preferredSize.width,(int) (preferredSize.height*0.5)));
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
