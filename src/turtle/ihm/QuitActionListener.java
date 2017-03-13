package turtle.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class QuitActionListener implements ActionListener{
	
	private JFrame f;

	public QuitActionListener(JFrame f) {
		this.f = f;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int res = JOptionPane.showConfirmDialog(f, "Voulez vous quitter?","Quitter",JOptionPane.YES_NO_OPTION);
		if(res == JOptionPane.YES_OPTION){
			f.dispose();
		}
		
	}

}
