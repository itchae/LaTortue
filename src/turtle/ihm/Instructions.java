package turtle.ihm;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Instructions extends JPanel{

	private static final long serialVersionUID = 2749854200229887457L;

	JCheckBox draw = new JCheckBox();
	
	public Instructions (){
		super();
		Box mainBox = Box.createVerticalBox();

		Box sliders = Box.createVerticalBox();
		sliders.add(boxTurn("Turn"));
		sliders.add(boxTurn("Go"));
		
		JPanel couleurs = new JPanel();
		couleurs.add(panelCoul(Color.GREEN));
		couleurs.add(panelCoul(Color.BLUE));
		couleurs.add(panelCoul(Color.RED));
		couleurs.add(panelCoul(Color.YELLOW));

		Box drawBox = Box.createHorizontalBox();
		
		JLabel drawText = new JLabel("Draw");
		drawBox.add(draw);
		drawBox.add(drawText);
		
		mainBox.add(sliders);
		mainBox.add(couleurs);
		mainBox.add(drawBox);
		this.add(mainBox);
		this.setVisible(true);
	}
	
	public static Box boxTurn(String str){
		Box fois = Box.createHorizontalBox();
		
		JButton bouton = new JButton(str);
		bouton.setPreferredSize(new Dimension(80,40));

		JSlider slide = new JSlider(); //0 à 8 
		slide.setMaximum(8);
		slide.setMinimum(0);
		slide.setValue(0);
			
		JLabel nbSlide = new JLabel(" " + slide.getValue());
		slide.addChangeListener(new SliderListener(nbSlide));
		
		fois.add(nbSlide);
		fois.add(slide);
		fois.add(bouton);
		return fois;
	}

	public static JPanel panelCoul(Color color){
		JPanel coulPane = new JPanel();
		coulPane.setBackground(color);
		coulPane.setPreferredSize(new Dimension(70,70));
		return coulPane;		
	}


}
