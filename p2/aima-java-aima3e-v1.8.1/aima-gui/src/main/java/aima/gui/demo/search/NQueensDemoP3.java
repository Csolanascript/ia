package aima.gui.demo.search;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.environment.nqueens.AttackingPairsHeuristic;
import aima.core.environment.nqueens.NQueensBoard;
import aima.core.environment.nqueens.NQueensFitnessFunction;
import aima.core.environment.nqueens.NQueensFunctionFactory;
import aima.core.environment.nqueens.NQueensGoalTest;
import aima.core.search.framework.GraphSearch;
import aima.core.search.framework.Problem;
import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;
import aima.core.search.framework.TreeSearch;
import aima.core.search.local.GeneticAlgorithm;
import aima.core.search.local.HillClimbingSearch;
import aima.core.search.local.Individual;
import aima.core.search.local.Scheduler;
import aima.core.search.local.SimulatedAnnealingSearch;
import aima.core.search.uninformed.BreadthFirstSearch;
import aima.core.search.uninformed.DepthFirstSearch;
import aima.core.search.uninformed.DepthLimitedSearch;
import aima.core.search.uninformed.IterativeDeepeningSearch;
import aima.core.util.datastructure.XYLocation;

/**
 * @author Ravi Mohan
 * 
 */

public class NQueensDemoP3 {

	private static final int _boardSize = 8;
	
	public static void main(String[] args) {

		newNQueensDemo();
	}

	public static NQueensBoard generateRandomNqueensBoard (int boardSize) {
        NQueensBoard board = new NQueensBoard(boardSize);
        for (int i = 0; i < boardSize; i++) {
            board.addQueenAt(new XYLocation(i, new Random().nextInt(boardSize)));
        }
        return board;
    }

    public static Set<NQueensBoard> generateSetNqueensBoard(int boardSize, int populationSize) {
        Set<NQueensBoard> setGeneratedNQueens = new HashSet<NQueensBoard>();

        while(setGeneratedNQueens.size()<populationSize) {
            setGeneratedNQueens.add(generateRandomNqueensBoard(_boardSize));
        }
        return setGeneratedNQueens;
    }
	private static void newNQueensDemo() {


		nQueensHillClimbingSearch_Statistics(10000);
		nQueensRandomRestartHillClimbing();
		nQueensSimulatedAnnealingSearch(1000);0
		nQueensSimulatedAnnealingRandomrestart();
		nQueensGeneticAlgorithmSearch();
	}

	
	private static void nQueensSimulatedAnnealingSearch(int numExperiments) {
		System.out.println("\nNQueens SimulatedAnnealing with 1000 different initial states -->");
		int Failures = 0;
		int Successes = 0;
		int avgFailures = 0;
		int avgSuccesses = 0;
		
		Scheduler schedule = new Scheduler(10, 0.1, 500);
		System.out.println("Parámetros Scheduler: 10, 0.1, 500");
		for (int i=0; i< numExperiments; i++) {
			try {
				Problem problem = new Problem(generateRandomNqueensBoard(_boardSize),
						NQueensFunctionFactory.getCActionsFunction(),
						NQueensFunctionFactory.getResultFunction(),
						new NQueensGoalTest());
				SimulatedAnnealingSearch search = new SimulatedAnnealingSearch(new
						AttackingPairsHeuristic(), schedule);
				SearchAgent agent = new SearchAgent(problem, search);
				if(search.getOutcome().toString().contentEquals("SOLUTION_FOUND")) {
					Successes ++;
					avgSuccesses += agent.getActions().size();}
				else {
					Failures++;
					avgFailures+= agent.getActions().size();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Failures: %.2f%%\n", (double)Failures/numExperiments*100);
		System.out.printf("average cost of Failures: %.2f\n", (double)avgFailures/Failures);
		System.out.printf("Successes: %.2f%%\n", (double)Successes/numExperiments*100);
		System.out.printf("average cost of Successes:%.2f\n", (double)avgSuccesses/Successes);
		} 
	

	private static void nQueensHillClimbingSearch_Statistics(int numExperiments){
		System.out.println("\nNQueens HillClimbing with 10000 different initial states -->");
		int Failures = 0;
		int Successes = 0;
		int avgFailures = 0;
		int avgSuccesses = 0;
		
		for (int i=0; i< numExperiments; i++) {
			try {
				Problem problem = new Problem(generateRandomNqueensBoard(_boardSize),
						NQueensFunctionFactory.getCActionsFunction(),
						NQueensFunctionFactory.getResultFunction(),
						new NQueensGoalTest());
				HillClimbingSearch search = new HillClimbingSearch(
						new AttackingPairsHeuristic());
				SearchAgent agent = new SearchAgent(problem, search);
				if(search.getOutcome().toString().contentEquals("SOLUTION_FOUND")) {
					Successes ++;
					avgSuccesses += agent.getActions().size();}
				else {
					Failures++;
					avgFailures+= agent.getActions().size();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Failures: %.2f%%\n", (double)Failures/numExperiments*100);
		System.out.printf("average cost of Failures: %.2f\n", (double)avgFailures/Failures);
		System.out.printf("Successes: %.2f%%\n", (double)Successes/numExperiments*100);
		System.out.printf("average cost of Successes:%.2f\n", (double)avgSuccesses/Successes);
		} 
	
	
	private static void nQueensRandomRestartHillClimbing(){
		System.out.println("\nNQueens HillClimbing until a solution is found -->");
		int intentos = 0;
		int avgFailures = 0;
		int avgSuccesses = 0;
		while(true) {
			intentos++;
			try {
				Problem problem = new Problem(generateRandomNqueensBoard(_boardSize),
						NQueensFunctionFactory.getCActionsFunction(),
						NQueensFunctionFactory.getResultFunction(),
						new NQueensGoalTest());
				HillClimbingSearch search = new HillClimbingSearch(
						new AttackingPairsHeuristic());
				SearchAgent agent = new SearchAgent(problem, search);
				if(search.getOutcome().toString().contentEquals("SOLUTION_FOUND")) {
						avgSuccesses = agent.getActions().size();
						System.out.println("Search Outcome=" + search.getOutcome().toString());
						System.out.println("Final State=\n" + search.getLastSearchState());
						System.out.println("Number of tries: " + intentos);
						System.out.printf("Average Failure Cost: %.2f\n", (double)avgFailures/(intentos-1));
						System.out.println("Sucess Cost: " + (avgFailures+avgSuccesses));
						System.out.println("Average Sucess Cost: " + avgSuccesses);
					break;
					}
				else {
					avgFailures+= agent.getActions().size();
				}
			} catch (Exception e) {
				System.out.println("SOLUTION_NOT_FOUND");
				e.printStackTrace();
			}
		}
		} 
	
	private static void nQueensSimulatedAnnealingRandomrestart(){
		System.out.println("\nNQueens HillClimbing until a solution is found -->");
		int intentos = 0;
		int avgFailures = 0;
		int avgSuccesses = 0;
		Scheduler schedule = new Scheduler(10, 0.1, 500);
		System.out.println("Parámetros Scheduler: 10, 0.1, 500");
		while(true) {
			intentos++;
			try {
					Problem problem = new Problem(generateRandomNqueensBoard(_boardSize),
							NQueensFunctionFactory.getCActionsFunction(),
							NQueensFunctionFactory.getResultFunction(),
							new NQueensGoalTest());
					SimulatedAnnealingSearch search = new SimulatedAnnealingSearch(new
							AttackingPairsHeuristic(), schedule);
					SearchAgent agent = new SearchAgent(problem, search);
				if(search.getOutcome().toString().contentEquals("SOLUTION_FOUND")) {
						avgSuccesses = agent.getActions().size();
						System.out.println("Search Outcome=" + search.getOutcome().toString());
						System.out.println("Final State=\n" + search.getLastSearchState());
						System.out.println("Number of tries: " + intentos);
						System.out.printf("Average Failure Cost: %.2f\n", (double)avgFailures/(intentos-1));
						System.out.println("Sucess Cost: " + (avgFailures+avgSuccesses));
						System.out.println("Average Sucess Cost: " + avgSuccesses);
					break;
					}
				else {
					avgFailures+= agent.getActions().size();
				}
			} catch (Exception e) {
				System.out.println("SOLUTION_NOT_FOUND");
				e.printStackTrace();
			}
		}
		} 
	
	
		
	public static void nQueensGeneticAlgorithmSearch() {
			System.out.println("\nNQueensDemo Genetic Algorithm");
			NQueensFitnessFunction fitnessFunction = new NQueensFitnessFunction();
			Set<Individual<Integer>> population = new HashSet<Individual<Integer>>();
			try {
				for (int i = 0; i < 50; i++) {
						population.add(fitnessFunction.generateRandomIndividual(_boardSize));
				}
				
						GeneticAlgorithm<Integer> ga = new GeneticAlgorithm<Integer>(_boardSize,fitnessFunction.getFiniteAlphabetForBoardOfSize(_boardSize),0.15);
						Individual<Integer> bestIndividual = ga.geneticAlgorithm(population,fitnessFunction, fitnessFunction, 1000L);
						bestIndividual = ga.geneticAlgorithm(population, fitnessFunction,fitnessFunction, 0L);
						System.out.println("Parámetros iniciales:\tPoblación: " +
						ga.getPopulationSize() + ", " + "Probabilidad mutación: 0.15");
						System.out.println("Mejor individuo=\n" +
						fitnessFunction.getBoardForIndividual(bestIndividual) + "\n");
						System.out.println("Tamaño tablero = " + _boardSize);
						System.out.println("Fitness = " +
						fitnessFunction.getValue(bestIndividual));
						System.out.println("Es objetivo = " +
						fitnessFunction.isGoalState(bestIndividual));
						System.out.println("Tamaño de población = " + ga.getPopulationSize());
						System.out.println("Iteraciones = " + ga.getIterations());
						System.out.println("Tiempo = " +
						ga.getTimeInMilliseconds() + "ms.");
					} 
				catch (Exception e) {
					e.printStackTrace();
					}
	}


}