package turtle.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import turtle.Model.UndoClass;

public class DrawListener implements ActionListener{

	private UndoClass T;
	public DrawListener(UndoClass T){
		this.T=T;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o instanceof JCheckBox){	
			JCheckBox checkDraw = (JCheckBox)o;
			T.addDrawCommand(checkDraw.isSelected());
		}
		else{
			System.err.println("Problème drawListener");
		}

	}

	
	
}
