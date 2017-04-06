package turtle.ihm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

import turtle.Model.Commands;
import turtle.Model.UndoClass;

public class LecteurListener implements ActionListener {
	
	private JTextArea command;
	private UndoClass undo;
	private LabelTempo error;

	public LecteurListener(JTextArea command , UndoClass undo , LabelTempo error) {
		this.command = command;
		this.undo = undo;
		this.error = error;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		List<String[]> commands = splitTextCommand(this.command.getText());
		if(this.verifTextCommand(commands)){
			//comparaison et modification du undo
			this.detectNewCommand(commands);
			System.out.println(""+this.undo);
		}
		else{
			this.error.showText("Il y a une erreur dans les commandes");
		}
		
	}
	
	private List<String[]> splitTextCommand(String textCommand){
		String[] tmp = textCommand.split("\n");
		List<String[]> commands = new ArrayList<String[]>();
		
		for(int i=0 ; i<tmp.length ; i++){
			commands.add(tmp[i].split(" "));
		}
		
		return commands;
	}
	
	private boolean verifTextCommand(List<String[]> commandes){
		boolean juste = true;
		for(String[] ligne : commandes){
				try{
					if(ligne[0] != ""){
						Commands c = Commands.valueOf(ligne[0].toUpperCase());
						juste = juste && verifArg(c,ligne);
					}
				}
				catch(IllegalArgumentException e){
					juste = false;
					System.out.println("Command fause="+ligne[0]+"/");
				}	
		}		
		return juste;
	}
	
	private boolean verifArg (Commands c , String[] arg){
		boolean juste = true;
		switch(c){
			case DRAW: if(arg.length == 2){
							juste = arg[1].equalsIgnoreCase("true") || arg[1].equalsIgnoreCase("false");
						}
						else{
							juste = false;
						}
				break;

			case TURN:
			case GO: if(arg.length == 2){
							try{
								int nb = Integer.parseInt(arg[1]);
								juste = nb > 0;
							}
							catch(NumberFormatException e){
								juste = false;
							}
						}
						else{
							juste = false;
						}
				break;
			case COLOR: if(arg.length == 4){
							try{
								for(int i=1 ; i<4 ; i++){
									int nb = Integer.parseInt(arg[i]);
									juste = (nb >= 0 && nb<=255) && juste;
								}
							}
							catch(NumberFormatException e){
								juste = false;
							}
						}
						else{
							juste = false;
						}
				break;
			default: System.err.println(c+" n'est pas codé");
				break;
		}
		return juste;
	}
	
	private void detectNewCommand(List<String[]> nouv ){
		//trouve une solution../.
	}
	
	


}
