package aima.test.core.unit.environment.eightpuzzle;

import org.junit.Assert;
import org.junit.Test;

import aima.core.environment.canibales.CanibalesBoard;
import aima.core.environment.canibales.MisplacedTilleHeuristicFunction;

/**
 * @author Ravi Mohan
 * 
 */
public class MisplacedTileHeuristicFunctionTest {

	@Test
	public void testHeuristicCalculation() {
		MisplacedTilleHeuristicFunction fn = new MisplacedTilleHeuristicFunction();
		CanibalesBoard board = new CanibalesBoard(new int[] { 2, 0, 5, 6,
				4, 8, 3, 7, 1 });
		Assert.assertEquals(6.0, fn.h(board), 0.001);

		board = new CanibalesBoard(new int[] { 6, 2, 5, 3, 4, 8, 0, 7, 1 });
		Assert.assertEquals(5.0, fn.h(board), 0.001);

		board = new CanibalesBoard(new int[] { 6, 2, 5, 3, 4, 8, 7, 0, 1 });
		Assert.assertEquals(6.0, fn.h(board), 0.001);
		
		board = new CanibalesBoard(new int[] { 8, 1, 2, 3, 4, 5, 6, 7, 0 });
		Assert.assertEquals(1.0, fn.h(board), 0.001);
		
		board = new CanibalesBoard(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 });
		Assert.assertEquals(0.0, fn.h(board), 0.001);
	}
}
