package turtle.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;

import turtle.Model.UndoClass;

public class DrawListener implements ActionListener{

	private UndoClass T;
	private JTextArea textCommand;
	
	public DrawListener(UndoClass T , JTextArea textCommand){
		this.T=T;
		this.textCommand = textCommand;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o instanceof JCheckBox){	
			JCheckBox checkDraw = (JCheckBox)o;
			T.addDrawCommand(checkDraw.isSelected());
			this.textCommand.setText(""+T);
		}
		else{
			System.err.println("Problème drawListener");
		}

	}

	
	
}
