package turtle.ihm.listener;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderListener implements ChangeListener {

	private JLabel label ;
	
	public SliderListener (JLabel l){
		this.label = l;
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		Object s =  e.getSource();
		if(s instanceof JSlider){
			JSlider slider = (JSlider) s;
			this.label.setText(""+slider.getValue());
		}
		
	}

}
