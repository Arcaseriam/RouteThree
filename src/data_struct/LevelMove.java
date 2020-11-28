package data_struct;
import data.Move;

public class LevelMove {
    private final int level;
    private final Move move;
    
    public LevelMove(int a_level, Move a_move){
        level = a_level;
        move = a_move;
    }

    public Move getMove() {
        return move;
    }
    public int getLevel() {
        return level;
    }
    
    @Override
    public String toString() {
        return String.format("%d %s", level, move.getName());
    }
}
