package turtle.ihm;


import java.util.List;

import javax.swing.SwingUtilities;

import turtle.Model.UndoClass;
import turtle.ihm.listener.RepeatListener;

public class DrawThread extends Thread {

	private EcranCentral grille;
	private UndoClass undo;
	private RepeatListener listener;
	
	public DrawThread(EcranCentral v , UndoClass u , RepeatListener list) {
		this.grille = v;
		this.undo = u;
		this.listener = list;
	}

	@Override
	public void run() {
		super.run();
		List<Boolean> v = this.undo.getDrawPoints();
		for(int i = v.size() ; i>=0 ; i--){
			this.grille.setArretNbPointAvant(i);
			SwingUtilities.invokeLater(new Runnable(){
				
				@Override
				public void run() {
					DrawThread.this.grille.repaint();
					
				}
			});
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.listener.setInactif();
	}

	

}
