package aima.core.environment.eightpuzzle;

import aima.core.search.framework.HeuristicFunction;
import aima.core.util.datastructure.XYLocation;

/**
 * @author Ravi Mohan
 * 
 */
public class ManhattanHeuristicFunction implements HeuristicFunction {
	public EightPuzzleBoard objetivo;

	public ManhattanHeuristicFunction(EightPuzzleBoard objetivo) {
		this.objetivo = objetivo;
	}
	
	public double h(Object state) {
		EightPuzzleBoard board = (EightPuzzleBoard) state;
		int retVal = 0;
		for (int i = 1; i < 9; i++) {
			retVal += evaluateManhattanDistanceOf(i,board);
		}
		return retVal;

	}

	public int evaluateManhattanDistanceOf(int i,EightPuzzleBoard board) {
		XYLocation locObjetivo = objetivo.getLocationOf(i);
		XYLocation loc = board.getLocationOf(i);
		//System.out.println(board);
		System.out.println(objetivo);
		int xpos = loc.getXCoOrdinate();
		int ypos = loc.getYCoOrdinate();
		int xposGoal = locObjetivo.getXCoOrdinate();
		int yposGoal = locObjetivo.getYCoOrdinate();
		int retVal = Math.abs(xpos - xposGoal) + Math.abs(ypos - yposGoal);
		System.out.println(retVal);
		
		return retVal;
	}
}