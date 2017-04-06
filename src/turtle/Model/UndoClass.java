package turtle.Model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class UndoClass {
	
	private Tortue tortue;
	private List<Command> listCommand;
	private List<Integer> pileInsertion;

	public UndoClass(Tortue t) {
		this.tortue = t;
		this.listCommand = new ArrayList<Command>();
		this.pileInsertion = new ArrayList<Integer>();
		
		
	}

	private void annuleCommand(int pos , int deb){
		for( int i = deb ; i>= pos ;i--){
			this.listCommand.get(i).undoAction();
		}
	}
	
	private void annuleCommand(int pos){
		this.annuleCommand(pos , this.listCommand.size()-1);
	}
	
	private boolean refaireCommand(int pos){
		for (int i= pos ; i< this.listCommand.size() ; i++){
			if(!this.listCommand.get(i).doAction()){	//si echec on annule ce qu'on a fait
				this.annuleCommand(pos, i-1);
				return false;
			}
		}
		return true;
	}
	
	public boolean addGoCommand(int k , int posInsertion){
		this.annuleCommand(posInsertion);
		Command c = new Command_Go(this.tortue,k);
		if(!c.doAction()){
			this.refaireCommand(posInsertion);
			return false;
		}
		
		if(!this.refaireCommand(posInsertion)){	//si pas reussi a refaire on reviens en etat initial
			c.undoAction();
			this.refaireCommand(posInsertion);
			return false;
		}
		this.listCommand.add(posInsertion, c);
		this.pileInsertion.add(0,new Integer(posInsertion));
		return true;
	}
	
	public boolean addGoCommand(int k){	//ajout en fin
		return this.addGoCommand(k, this.listCommand.size());
	}
	
	public void undo(){
		if(!this.pileInsertion.isEmpty()){
			int pos = this.pileInsertion.get(0).intValue();
			this.pileInsertion.remove(0);
			this.annuleCommand(pos);
			this.listCommand.remove(pos);
			this.refaireCommand(pos);
		}
		
	}
	
	public void clear(){
		while(!this.pileInsertion.isEmpty()){
			this.undo();
		}
	}

	public void addDrawCommand(boolean enable){
		this.addDrawCommand(enable,this.listCommand.size());
	}
	
	public void addDrawCommand(boolean enable , int posInsertion){
		this.annuleCommand(posInsertion);
		Command c = new Command_Draw(this.tortue,enable);
		c.doAction();
		this.refaireCommand(posInsertion);
		this.listCommand.add(posInsertion,c);
		this.pileInsertion.add(0 ,new Integer(posInsertion));
		
	}
	
	public void addColorCommand(Color coul){
		this.addColorCommand(coul,this.listCommand.size());
	}
	
	public void addColorCommand(Color coul , int posInsertion){
		this.annuleCommand(posInsertion);
		Command c = new Command_Color(this.tortue,coul);
		c.doAction();
		this.refaireCommand(posInsertion);
		this.listCommand.add(posInsertion,c);
		this.pileInsertion.add(0 ,new Integer(posInsertion));
		
	}
	
	public boolean addTurnCommand(int k){
		 return this.addTurnCommand(k,this.listCommand.size());
	}
	
	public boolean addTurnCommand(int k , int posInsertion){
		this.annuleCommand(posInsertion);
		Command c = new Command_turn(this.tortue,k);
		c.doAction();
		if(!this.refaireCommand(posInsertion)){
			c.undoAction();
			this.refaireCommand(posInsertion);
			return false;
		}
		
		this.listCommand.add(posInsertion,c);
		this.pileInsertion.add(0 ,new Integer(posInsertion));
		return true;
	}
	
	public boolean addMotifCommand(Motif k){
		 return this.addMotifCommand(k,this.listCommand.size());
	}
	
	public boolean addMotifCommand(Motif k , int posInsertion){
		this.annuleCommand(posInsertion);
		Command c = new Command_Motif(this.tortue,k);
		c.doAction();
		if(!this.refaireCommand(posInsertion)){
			c.undoAction();
			this.refaireCommand(posInsertion);
			return false;
		}
		
		this.listCommand.add(posInsertion,c);
		this.pileInsertion.add(0 ,new Integer(posInsertion));
		return true;
	}
	
	public List<List<Vecteur>> getPoints(){
		List<List<Vecteur>> points = new ArrayList<List<Vecteur>>();
		for(int i = 0 ; i<this.listCommand.size() ; i++){
			if(this.listCommand.get(i) instanceof Command_Go){
				points.add(((Command_Go)this.listCommand.get(i)).getRoute());
			}
		}
		return points;
		
	}
	
	public List<Boolean> getDrawPoints(){
		List<Boolean> points = new ArrayList<Boolean>();
		for(int i = 0 ; i<this.listCommand.size() ; i++){
			if(this.listCommand.get(i) instanceof Command_Go){
				points.add(new Boolean(((Command_Go)this.listCommand.get(i)).isDraw()));
			}
		}
		return points;
		
	}
	
	public List<Color> getColorPoints(){
		List<Color> points = new ArrayList<Color>();
		for(int i = 0 ; i<this.listCommand.size() ; i++){
			if(this.listCommand.get(i) instanceof Command_Go){
				points.add(((Command_Go)this.listCommand.get(i)).getDrawColor());
			}
		}
		return points;
		
	}

	public Tortue getTortue() {
		return this.tortue;
	}

	@Override
	public String toString() {
		String txt = "";
		for(int i = 0 ; i< this.listCommand.size() ; i++){
			txt+= this.listCommand.get(i).toString();
		}
		return txt;
	}
	
	
	
	
}
