package turtle.ihm;

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
import javax.swing.JSlider;

import turtle.Model.Tortue;

public class Instructions extends JPanel{

	private static final long serialVersionUID = 2749854200229887457L;
	private List<JButton> boutons; 
	private List<JSlider> sliders;
	
	public Instructions (Tortue T, JComponent dessin, JComponent afficheurCouleur){
		super();
		Box mainBox = Box.createVerticalBox();
		this.boutons = new ArrayList<JButton>();
		this.sliders = new ArrayList<JSlider>();
		
		Box sliders = Box.createVerticalBox();
		sliders.add(boxTurn("Turn"));
		sliders.add(boxTurn("Go"));
		
		this.boutons.get(0).addActionListener(new TurnListener(T, this.sliders.get(0),dessin));
		this.boutons.get(1).addActionListener(new TurnListener(T, this.sliders.get(1),dessin));
		
		JPanel couleurs = new JPanel();
		couleurs.add(panelCoul(Color.GREEN, afficheurCouleur, T));
		couleurs.add(panelCoul(Color.BLUE, afficheurCouleur, T));
		couleurs.add(panelCoul(Color.RED, afficheurCouleur, T));
		couleurs.add(panelCoul(Color.YELLOW, afficheurCouleur, T));
		
		
		
		Box drawBox = Box.createHorizontalBox();
		JCheckBox draw = new JCheckBox();
		draw.addActionListener(new DrawListener(T));
		
		JLabel drawText = new JLabel("Draw");
		drawBox.add(draw);
		drawBox.add(drawText);
		
		mainBox.add(sliders);
		mainBox.add(couleurs);
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

	public static JPanel panelCoul(Color color, JComponent afficheur, Tortue T){
		JPanel coulPane = new JPanel();
		coulPane.setBackground(color);
		coulPane.setPreferredSize(new Dimension(70,70));
		coulPane.addMouseListener(new ColorListener(T, afficheur));
		return coulPane;		
	}


}
