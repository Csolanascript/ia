package aima.test.core.unit.environment.eightpuzzle;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import aima.core.agent.Action;
import aima.core.environment.canibales.CanibalesBoard;
import aima.core.environment.canibales.CanibalesFunctionFactory;

/**
 * @author Ravi Mohan
 * @author Ciaran O'Reilly
 */
public class EightPuzzleFunctionFactoryTest {
	CanibalesBoard board;

	@Before
	public void setUp() {
		board = new CanibalesBoard(new int[] { 1, 2, 5, 3, 4, 0, 6, 7, 8 });
	}

	@Test
	public void testGenerateCorrect3Successors() {
		List<Action> actions = new ArrayList<Action>(CanibalesFunctionFactory
				.getActionsFunction().actions(board));
		Assert.assertEquals(3, actions.size());

		// test first successor
		CanibalesBoard expectedFirst = new CanibalesBoard(new int[] { 1, 2,
				0, 3, 4, 5, 6, 7, 8 });
		CanibalesBoard actualFirst = (CanibalesBoard) CanibalesFunctionFactory
				.getResultFunction().result(board, actions.get(0));
		Assert.assertEquals(expectedFirst, actualFirst);
		Assert.assertEquals(CanibalesBoard.UP, actions.get(0));

		// test second successor
		CanibalesBoard expectedSecond = new CanibalesBoard(new int[] { 1,
				2, 5, 3, 4, 8, 6, 7, 0 });
		CanibalesBoard actualSecond = (CanibalesBoard) CanibalesFunctionFactory
				.getResultFunction().result(board, actions.get(1));
		Assert.assertEquals(expectedSecond, actualSecond);
		Assert.assertEquals(CanibalesBoard.DOWN, actions.get(1));

		// test third successor
		CanibalesBoard expectedThird = new CanibalesBoard(new int[] { 1, 2,
				5, 3, 0, 4, 6, 7, 8 });
		CanibalesBoard actualThird = (CanibalesBoard) (CanibalesBoard) CanibalesFunctionFactory
				.getResultFunction().result(board, actions.get(2));
		Assert.assertEquals(expectedThird, actualThird);
		Assert.assertEquals(CanibalesBoard.LEFT, actions.get(2));
	}

	@Test
	public void testGenerateCorrectWhenGapMovedRightward() {
		board.moveGapLeft();// gives { 1, 2, 5, 3, 0, 4, 6, 7, 8 }
		Assert.assertEquals(new CanibalesBoard(new int[] { 1, 2, 5, 3, 0, 4,
				6, 7, 8 }), board);

		List<Action> actions = new ArrayList<Action>(CanibalesFunctionFactory
				.getActionsFunction().actions(board));
		Assert.assertEquals(4, actions.size());

		CanibalesBoard expectedFourth = new CanibalesBoard(new int[] { 1,
				2, 5, 3, 4, 0, 6, 7, 8 });
		CanibalesBoard actualFourth = (CanibalesBoard) (CanibalesBoard) CanibalesFunctionFactory
				.getResultFunction().result(board, actions.get(3));
		Assert.assertEquals(expectedFourth, actualFourth);
		Assert.assertEquals(CanibalesBoard.RIGHT, actions.get(3));
	}
}
