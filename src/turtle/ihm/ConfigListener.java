package turtle.ihm;

import turtle.ihm.FenetrePrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SwingUtilities;

public class ConfigListener implements ActionListener{

	private JSpinner col; 
	private JSpinner line;
	private JRadioButton br;
	private JFrame frame;
	private JFrame frameConf;
	public ConfigListener(JSpinner col, JSpinner line, JRadioButton br, JFrame fc){
		this.col = col;
		this.line = line;
		this.br = br;
		this.frameConf=fc;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable(){
			
		@Override
		public void run() {
			if(br.isSelected()){
				frame = new FenetrePrincipal(true, (int)col.getValue(), (int)line.getValue());
			}else{
				frame = new FenetrePrincipal(false, (int)col.getValue(), (int)line.getValue());
			}
			frame.pack();
			frame.setVisible(true);
		}
		});
		frameConf.dispose();
	}
}
