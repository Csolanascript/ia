package aima.core.environment.eightpuzzle;

import aima.core.search.framework.HeuristicFunction;
import aima.core.util.datastructure.XYLocation;

/**
 * @author Ravi Mohan
 * 
 */
public class MisplacedTilleHeuristicFunction implements HeuristicFunction {
	EightPuzzleBoard objetivo;
	
	public MisplacedTilleHeuristicFunction(EightPuzzleBoard objetivo) {
		this.objetivo = objetivo;
	}
	
	public double h(Object state) {
		EightPuzzleBoard board = (EightPuzzleBoard) state;
		return getNumberOfMisplacedTiles(board);
	}

	private int getNumberOfMisplacedTiles(EightPuzzleBoard board) {
        int numberOfMisplacedTiles = 0;

        for (int i = 0; i < 9; i++) {
            if (!(board.getLocationOf(i).equals(objetivo.getLocationOf(i)))) {
                numberOfMisplacedTiles++;
            }
        }

        if(numberOfMisplacedTiles > 0) {
            numberOfMisplacedTiles--;
        }

        return numberOfMisplacedTiles;
    }
}