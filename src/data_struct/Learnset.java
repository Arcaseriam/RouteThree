package data_struct;

import java.util.ArrayList;
import java.util.Iterator;

public class Learnset implements Iterable<LevelMove>{
    private ArrayList<LevelMove> levelMoves;
    
    public Learnset() {
    	levelMoves = new ArrayList<LevelMove>();
    }
    
    private Learnset(ArrayList<LevelMove> list) {
    	levelMoves = list;
    }
    
    // Builder, thanks entrpntr
    public Learnset add(LevelMove levelMove) {
    	this.levelMoves.add(levelMove);
    	return this;
    }
    
    public Learnset clone() {
    	ArrayList<LevelMove> copy = new ArrayList<LevelMove>(levelMoves);
        return new Learnset(copy);
    }

	@Override
	public Iterator<LevelMove> iterator() {
		return levelMoves.iterator();
	}
}
