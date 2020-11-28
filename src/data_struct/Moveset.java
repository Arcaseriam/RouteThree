package data_struct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import data.Game;
import data.Move;
import data.Species;

public class Moveset implements Iterable<Move>{
	private ArrayList<Move> moves = new ArrayList<Move>();
	
	public Moveset() { }
    
    public Moveset(List<Move> newMoves) {
        if (newMoves == null)
            return;          
        moves = new ArrayList<Move>(newMoves);
    }
    
    //returns the 4 most recently learned moves for a pokemon of this level
    public static Moveset defaultMoveset(Species species, int level, Game game){
        ArrayList<Move> distinctMoves = new ArrayList<Move>();
        HashSet<Move> movesSet = new HashSet<Move>();
        Learnset learnset = AllLearnsets.getLearnset(species, game);
        
        if (learnset == null) {
            return new Moveset();
        }
        
        for(LevelMove levelMove : learnset) {
        	int moveLevel = levelMove.getLevel();
        	Move move = levelMove.getMove();
        	
            if (!movesSet.contains(move) && moveLevel <= level) {
                movesSet.add(move);
                distinctMoves.add(move);
            }
        }
        
        if (distinctMoves.size() <= 4)
            return new Moveset(distinctMoves);
        else {
            int n = distinctMoves.size();
            return new Moveset(distinctMoves.subList(n-4, n));
        }           
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for(Move m : moves) {
            sb.append(m.getName() + "/");
        }
        
        int len = sb.toString().length();
		return (sb.toString()).substring(0, len - 1);
    }

    @Override
    public Iterator<Move> iterator() {
        return moves.iterator();
    }
    
    public void addMove(Move m) {
        if (!moves.contains(m))
            moves.add(m);
    }
    
    public void addMove(String s) {
        addMove(Move.valueOf(s));
    }
    
    public void addMove(int i) {
        addMove(Move.values()[i]);
    }
    
    public boolean delMove(Move m) {
        return moves.remove(m);
    }
    
    public void delMove(String s) {
        delMove(Move.valueOf(s));
    }
}
