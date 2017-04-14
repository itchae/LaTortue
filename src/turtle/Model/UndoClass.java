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

	/**
	 * permet d'annuler les commandes de deb jusqu'à pos
	 * @param pos 
	 * @param deb deb>=pos
	 */
	private void annuleCommand(int pos , int deb){
		for( int i = deb ; i>= pos ;i--){
			this.listCommand.get(i).undoAction();
		}
	}
	
	/**
	 * annule les commande de la fin de la liste jusqu'à pos
	 * @param pos
	 */
	private void annuleCommand(int pos){
		this.annuleCommand(pos , this.listCommand.size()-1);
	}
	
	/**
	 * permet de refaire les commandes à partir de la position pos
	 * @param pos
	 * @return
	 */
	private boolean refaireCommand(int pos){
		for (int i= pos ; i< this.listCommand.size() ; i++){
			if(!this.listCommand.get(i).doAction()){	//si echec on annule ce qu'on a fait
				this.annuleCommand(pos, i-1);
				return false;
			}
		}
		return true;
	}
	
	/**
	 * ajoute une commande go
	 * @param k nb fois où l'on effectue le go
	 * @param posInsertion position d'insertion dans la liste
	 * @return true si l'ajout est autorisé
	 */
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
	
	/**
	 *ajoute une commande go en fin de liste
	 * @param k nb fois où l'on effectue le go
	 * @return true si l'ajout est autorisé
	 */
	public boolean addGoCommand(int k){	//ajout en fin
		return this.addGoCommand(k, this.listCommand.size());
	}
	
	/**
	 * anuule la derniere commande
	 */
	public void undo(){
		if(!this.pileInsertion.isEmpty()){
			int pos = this.pileInsertion.get(0).intValue();
			this.pileInsertion.remove(0);
			this.annuleCommand(pos);
			this.listCommand.remove(pos);
			this.refaireCommand(pos);
		}
		
	}
	
	/**
	 * annule toutes les commandes
	 */
	public void clear(){
		while(!this.pileInsertion.isEmpty()){
			this.undo();
		}
	}

	/**
	 * ajoute une commande Draw en fin de liste
	 * @param enable
	 */
	public void addDrawCommand(boolean enable){
		this.addDrawCommand(enable,this.listCommand.size());
	}
	
	/**
	 * ajoute une commande Draw 
	 * @param enable active le dessin ou pas
	 * @param posInsertion possition d'insertion dans la liste
	 */
	public void addDrawCommand(boolean enable , int posInsertion){
		this.annuleCommand(posInsertion);
		Command c = new Command_Draw(this.tortue,enable);
		c.doAction();
		this.refaireCommand(posInsertion);
		this.listCommand.add(posInsertion,c);
		this.pileInsertion.add(0 ,new Integer(posInsertion));
		
	}
	
	/**
	 * ajoute une commande color en fin de liste
	 * @param coul la couleur a mettre
	 */
	public void addColorCommand(Color coul){
		this.addColorCommand(coul,this.listCommand.size());
	}
	
	/**
	 * ajoute une commande color
	 * @param coul la couleur a ajouter
	 * @param posInsertion la position dans la liste
	 */
	public void addColorCommand(Color coul , int posInsertion){
		this.annuleCommand(posInsertion);
		Command c = new Command_Color(this.tortue,coul);
		c.doAction();
		this.refaireCommand(posInsertion);
		this.listCommand.add(posInsertion,c);
		this.pileInsertion.add(0 ,new Integer(posInsertion));
		
	}
	
	/**
	 * ajoute une commande Turn en fin de liste
	 * @param k nb fois où l'on tourne le motif
	 * @return true si la tortue ne sort pas de la grille
	 */
	public boolean addTurnCommand(int k){
		 return this.addTurnCommand(k,this.listCommand.size());
	}
	
	/**
	 * ajoute une commande turn
	 * @param k nb fois où l'on tourne le motif
	 * @param posInsertion la position dans la liste
	 * @return true si la tortue ne sort pas de la grille
	 */
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
	
	/**
	 * ajoute une commande Motif en fin de liste
	 * @param k le nouveau motif
	 * @return true si la tortue ne sort pas de la grille
	 */
	public boolean addMotifCommand(Motif k){
		 return this.addMotifCommand(k,this.listCommand.size());
	}
	
	/**
	 * ajoute une commande Motif
	 * @param k le nouveau motif
	 * @param posInsertion la position dans la liste
	 * @return true si la tortue ne sort pas de la grille
	 */
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
	
	/**
	 * Renvoi les points calculé pendant les commande go
	 * @return liste de liste de points de passage de la tortue
	 */
	public List<List<Vecteur>> getPoints(){
		List<List<Vecteur>> points = new ArrayList<List<Vecteur>>();
		for(int i = 0 ; i<this.listCommand.size() ; i++){
			if(this.listCommand.get(i) instanceof Command_Go){
				points.add(((Command_Go)this.listCommand.get(i)).getRoute());
			}
		}
		return points;
		
	}
	
	/**
	 * renvoi la liste des etat de draw de la trotue
	 */
	public List<Boolean> getDrawPoints(){
		List<Boolean> points = new ArrayList<Boolean>();
		for(int i = 0 ; i<this.listCommand.size() ; i++){
			if(this.listCommand.get(i) instanceof Command_Go){
				points.add(new Boolean(((Command_Go)this.listCommand.get(i)).isDraw()));
			}
		}
		return points;
		
	}
	
	/**
	 * La liste des couleur pour chaque action go.
	 * @return
	 */
	public List<Color> getColorPoints(){
		List<Color> points = new ArrayList<Color>();
		for(int i = 0 ; i<this.listCommand.size() ; i++){
			if(this.listCommand.get(i) instanceof Command_Go){
				points.add(((Command_Go)this.listCommand.get(i)).getDrawColor());
			}
		}
		return points;
		
	}

	/**
	 * 
	 * @return la tortue
	 */
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
