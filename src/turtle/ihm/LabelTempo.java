package turtle.ihm;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


public class LabelTempo extends JLabel  {


	private static final long serialVersionUID = 4460752270933071796L;
	private Timer timer;
	
	public LabelTempo(String text , int time){
		super(text);
		this.setVisible(false);
		this.timer = new Timer(time, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				LabelTempo.this.setVisible(false);
				
			}
			
		});
	}
	
	public LabelTempo(int time){
		this("",time);
	}


		public static void main(String[] args) {
			
			SwingUtilities.invokeLater(new Runnable(){
				
				@Override
				public void run() {
					JFrame f = new JFrame();
					LabelTempo l = new LabelTempo("CouCou",5000);

					f.add(l,BorderLayout.SOUTH);
					JButton b = new JButton("Show");
					b.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) {
							l.affiche();
							//f.pack();
							
						}
						
					});
					f.add(b);
					f.pack();
					f.setVisible(true);
					
				}
			});
			
		}


		public void affiche() {
			this.setVisible(true);
			this.timer.start();
		}


}
