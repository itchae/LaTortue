package turtle.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;

import turtle.Model.UndoClass;

public class Instructions extends JPanel{

	private static final long serialVersionUID = 2749854200229887457L;
	private List<JButton> boutons; 
	private List<JSlider> sliders;
	private JPanel panelCouleur;
	
	public Instructions (UndoClass T, JComponent dessin, JComponent afficheurCouleur ,EcranCentral grille ,JTextArea textCommand ,LabelTempo error){
		super(new BorderLayout());
		Box mainBox = Box.createVerticalBox();
		this.boutons = new ArrayList<JButton>();
		this.sliders = new ArrayList<JSlider>();
		
		Box sliders = Box.createVerticalBox();
		sliders.add(boxTurn("Turn"));
		sliders.add(Box.createRigidArea(new Dimension(0,5)));
		sliders.add(boxTurn("Go"));
		
		this.boutons.get(0).addActionListener(new TurnListener(T, this.sliders.get(0),dessin,textCommand,error));
		this.boutons.get(1).addActionListener(new GoListener(T, this.sliders.get(1),grille,textCommand,error));
		
		JPanel couleurs = new JPanel();
		this.panelCouleur = couleurs;
		List<Color> listCouleurs = this.getAllColor();
		for(Color c : listCouleurs){
			couleurs.add(panelCoul(c, afficheurCouleur, T,textCommand));
		}
		
		
		
		
		Box drawBox = Box.createHorizontalBox();
		JCheckBox draw = new JCheckBox();
		draw.addActionListener(new DrawListener(T,textCommand));
		
		JLabel drawText = new JLabel("Draw");
		drawBox.add(draw);
		drawBox.add(drawText);
		
		mainBox.add(Box.createRigidArea(new Dimension(0,5)));
		mainBox.add(sliders);
		mainBox.add(Box.createRigidArea(new Dimension(0,5)));
		JScrollPane scroll = new JScrollPane(couleurs);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setMinimumSize(new Dimension(40,40));
		mainBox.add(scroll);
		mainBox.add(drawBox);
		this.add(mainBox);
		this.setVisible(true);
	}
	
	public Box boxTurn(String str){
		Box fois = Box.createHorizontalBox();
		
		
		JButton bouton = new JButton(str);
		bouton.setPreferredSize(new Dimension(80,40));
		this.boutons.add(bouton);
		
		JSlider slide = new JSlider(); //0 à 8 
		slide.setMaximum(8);
		slide.setMinimum(0);
		slide.setValue(0);
		this.sliders.add(slide);
		
		JLabel nbSlide = new JLabel(" " + slide.getValue());
		slide.addChangeListener(new SliderListener(nbSlide));
		
		fois.add(nbSlide);
		fois.add(slide);
		fois.add(bouton);
		return fois;
	}

	public static JPanel panelCoul(Color color, JComponent afficheur, UndoClass T , JTextArea textCommand){
		JPanel coulPane = new JPanel();
		coulPane.setBackground(color);
		coulPane.setPreferredSize(new Dimension(30,30));
		coulPane.addMouseListener(new ColorListener(T, afficheur , textCommand));
		return coulPane;		
	}

	@Override
	public void setPreferredSize(Dimension preferredSize) {
		super.setPreferredSize(preferredSize);
		this.panelCouleur.setPreferredSize(new Dimension((int) (preferredSize.width*0.8),preferredSize.height));
	}
	
	private List<Color> getAllColor(){
		List<Color> couleur = new ArrayList<Color>();
		couleur.add(Color.BLACK);
		couleur.add(Color.BLUE);
		couleur.add(Color.CYAN);
		couleur.add(Color.DARK_GRAY);
		couleur.add(Color.GRAY);
		couleur.add(Color.GREEN);
		couleur.add(Color.LIGHT_GRAY);
		couleur.add(Color.MAGENTA);
		couleur.add(Color.ORANGE);
		couleur.add(Color.PINK);
		couleur.add(Color.RED);
		couleur.add(Color.WHITE);
		couleur.add(Color.YELLOW);
		return couleur;
	}


	
	


}
