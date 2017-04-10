package turtle.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Commands {
	COLOR,DRAW,GO,TURN,MOTIF;
	
	static public boolean verifTextCommand(String text){
		List<String[]> commandeText = splitTextCommand(text);
		return verifTextCommand(commandeText);
	}
	
	static public List<String[]> splitTextCommand(String textCommand){
		String[] tmp = textCommand.split("\n");
		List<String[]> commands = new ArrayList<String[]>();
		
		for(int i=0 ; i<tmp.length ; i++){
			commands.add(tmp[i].split(" "));
		}
		
		return commands;
	}
	
	
	static public boolean verifTextCommand(List<String[]> commandes){
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
	
	
	static private boolean verifArg_Draw(String[] arg){
		boolean juste;
		if(arg.length == 2){
			juste = arg[1].equalsIgnoreCase("true") || arg[1].equalsIgnoreCase("false");
		}
		else{
			juste = false;
		}
		return juste;
	}
	
	
	static private boolean verifArg_GoTurn(String [] arg){
		boolean juste;
		if(arg.length == 2){
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
		return juste;
	}
	
	
	static private boolean verifArg_Color(String[] arg){
		boolean juste = true;
		 if(arg.length == 4){
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
		return juste;
	}
	
	static private boolean verifArg_Motif(String[] arg){
		boolean juste = true;
		 if(arg.length == 2){
			 Pattern p = Pattern.compile("<(<([0-9])+,([0-9])+>)+>");	//fomat <<12,12><12,12>>
			 Matcher m = p.matcher(arg[1]);
			 juste = m.matches();
			 
		}
		else{
			juste = false;
		}
		return juste;
	}

	static private boolean verifArg (Commands c , String[] arg){
		boolean juste = true;
		switch(c){
			case DRAW: juste = verifArg_Draw(arg);
				break;

			case TURN:
			case GO: juste = verifArg_GoTurn(arg);
				break;
			case COLOR: juste = verifArg_Color(arg);
				break;
			case MOTIF : juste = verifArg_Motif(arg);
				break;
			default: System.err.println(c+" n'est pas codé");
				break;
		}
		return juste;
	}
}
