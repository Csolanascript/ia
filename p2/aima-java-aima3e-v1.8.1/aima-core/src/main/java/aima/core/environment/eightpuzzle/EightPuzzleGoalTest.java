package aima.core.environment.eightpuzzle;

import aima.core.search.framework.GoalTest;

/**
 * @author Ravi Mohan
 * 
 */
public class EightPuzzleGoalTest implements GoalTest {

    static EightPuzzleBoard objetivo;

    public EightPuzzleGoalTest() {}

    public EightPuzzleGoalTest(EightPuzzleBoard goalstate) {
    	objetivo = goalstate;
    }

    public boolean isGoalState(Object state) {
        return ((EightPuzzleBoard) state).equals(objetivo);
    }
}