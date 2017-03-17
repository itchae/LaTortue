package turtle.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import turtle.Model.Tortue;

public class DrawListener implements ActionListener{

	private Tortue T;
	public DrawListener(Tortue T){
		this.T=T;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o instanceof JCheckBox){	
			JCheckBox checkDraw = (JCheckBox)o;
			T.setDraw(checkDraw.isSelected());
		}
		else{
			System.err.println("Problème drawListener");
		}

	}

	
	
}
