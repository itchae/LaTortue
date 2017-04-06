package turtle.ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import turtle.Model.Motif;
import turtle.Model.UndoClass;

public class EcranDroite extends JPanel {
	
	private static final long serialVersionUID = 521106232148146111L;
	private SelecteurMotif selecteur;
	private DessinMotif motifActuel;
	private JPanel couleurActuel;
	private List<JButton> buttons; 
	private JScrollPane scroll;
	private UndoClass undo;

	public EcranDroite(UndoClass undo , JFrame fenetre ){
		super(new BorderLayout());
		this.undo = undo;
		List<Motif> listMotif = Motif.getDefaultMotif();
		undo.getTortue().setMotif(listMotif.get(0));
		this.motifActuel = new DessinMotif(undo.getTortue().getMotif());
		this.selecteur = new SelecteurMotif(listMotif,undo , this.motifActuel);
		this.couleurActuel = new JPanel();
		this.couleurActuel.setPreferredSize(this.motifActuel.getPreferredSize());
		this.couleurActuel.setBackground(undo.getTortue().getColor());
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
	
	
	public void createUndoListener(JComponent grille , JTextArea text , JComponent motifActuel , JComponent couleur,JCheckBox drawBox){
		if(this.buttons.get(1).getActionListeners().length == 0){
			this.buttons.get(1).addActionListener(new UndoListener(undo,grille,text,motifActuel,couleur,drawBox));
			this.buttons.get(0).addActionListener(new InitListener(undo,grille,text,motifActuel,couleur,drawBox));
			this.buttons.get(2).addActionListener(new RepeatListener(grille,undo));
			this.setTextCommandRefresh(text);
		}
		else{
			System.err.println("Le bouton undo a déjà un action listener");
		}
		
	}
	
	private void setTextCommandRefresh(JTextArea text){
		this.selecteur.addTextCommandRefresh(text);
	}

	@Override
	public void setPreferredSize(Dimension preferredSize) {
		
		super.setPreferredSize(preferredSize);
		this.selecteur.setPreferredSize(new Dimension((int) (preferredSize.width*0.8),preferredSize.height));
		this.scroll.setPreferredSize(new Dimension (preferredSize.width,(int) (preferredSize.height*0.5)));
	}


}
