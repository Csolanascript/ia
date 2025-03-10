package aima.gui.demo.search;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import aima.core.agent.Action;
import aima.core.environment.canibales.CanibalesBoard;
import aima.core.environment.canibales.CanibalesFunctionFactory;
import aima.core.environment.canibales.CanibalesGoalTest;
import aima.core.environment.canibales.ManhattanHeuristicFunction;
import aima.core.environment.canibales.MisplacedTilleHeuristicFunction;
import aima.core.search.framework.GraphSearch;
import aima.core.search.framework.Problem;
import aima.core.search.framework.ResultFunction;
import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;
import aima.core.search.informed.AStarSearch;
import aima.core.search.informed.GreedyBestFirstSearch;
import aima.core.search.local.SimulatedAnnealingSearch;
import aima.core.search.uninformed.BidirectionalSearch;
import aima.core.search.uninformed.BreadthFirstSearch;
import aima.core.search.uninformed.DepthFirstSearch;
import aima.core.search.uninformed.DepthLimitedSearch;
import aima.core.search.uninformed.IterativeDeepeningSearch;
import aima.core.search.uninformed.UniformCostSearch;

/**
 * @author Ravi Mohan
 * 
 */

public class EightPuzzleDemo3 {
	static CanibalesBoard estadoInicial = new CanibalesBoard(
			new int[] { 3, 3, 0,0,0});;

			public static void executeActions(List<Action> actions, Problem problem) {
				Object initialState = problem.getInitialState();
				ResultFunction resultFunction = problem.getResultFunction();
				Object state = initialState;
				System.out.println("INITIAL STATE");
				System.out.println(state);
				for (Action action : actions) {
					 System.out.println(action.toString());
					 state = resultFunction.result(state, action);
					 System.out.println(state);
					 System.out.println("- - -");
				}
			}
			
	public static void main(String[] args) {
		canibalesBFSdemo();
		canibalesDLSdemo();
		canibalesIDSdemo();  
		canibalesUCSdemo();		
		canibalesDFSdemo();
	}

	private static void canibalesBFSdemo() {
		System.out.println("\nMisioneros y canibales BFS -->");
		try {
			Problem problem = new Problem(estadoInicial, CanibalesFunctionFactory
					.getActionsFunction(), CanibalesFunctionFactory
					.getResultFunction(), new CanibalesGoalTest());
			Search search = new BreadthFirstSearch();
			SearchAgent agent = new SearchAgent(problem, search);
			//printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			executeActions(agent.getActions(),problem);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void canibalesDLSdemo() {
		System.out.println("\nMisioneros y canibales DLS 11 -->");
		try {
			Problem problem = new Problem(estadoInicial, CanibalesFunctionFactory
					.getActionsFunction(), CanibalesFunctionFactory
					.getResultFunction(), new CanibalesGoalTest());
			Search search = new DepthLimitedSearch(11);
			SearchAgent agent = new SearchAgent(problem, search);
			//printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			executeActions(agent.getActions(),problem);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void canibalesIDSdemo() {
		System.out.println("\nMisioneros y canibales iterative DLS -->");
		try {
			Problem problem = new Problem(estadoInicial, CanibalesFunctionFactory
					.getActionsFunction(), CanibalesFunctionFactory
					.getResultFunction(), new CanibalesGoalTest());
			Search search = new IterativeDeepeningSearch();
			SearchAgent agent = new SearchAgent(problem, search);
			//printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			executeActions(agent.getActions(),problem);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void canibalesUCSdemo() {
		System.out.println("\nMisioneros y canibales UCS -->");
		try {
			Problem problem = new Problem(estadoInicial, CanibalesFunctionFactory
					.getActionsFunction(), CanibalesFunctionFactory
					.getResultFunction(), new CanibalesGoalTest());
			Search search = new UniformCostSearch();
			SearchAgent agent = new SearchAgent(problem, search);
			//printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			executeActions(agent.getActions(),problem);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void canibalesDFSdemo() {
		System.out.println("\nMisioneros y canibales DFS -->");
		try {
			Problem problem = new Problem(estadoInicial, CanibalesFunctionFactory
					.getActionsFunction(), CanibalesFunctionFactory
					.getResultFunction(), new CanibalesGoalTest());
			Search search = new DepthFirstSearch(new GraphSearch());
			SearchAgent agent = new SearchAgent(problem, search);
			//printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			executeActions(agent.getActions(),problem);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	private static void printInstrumentation(Properties properties) {
		Iterator<Object> keys = properties.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String property = properties.getProperty(key);
			System.out.println(key + " : " + property);
		}

	}

}
	