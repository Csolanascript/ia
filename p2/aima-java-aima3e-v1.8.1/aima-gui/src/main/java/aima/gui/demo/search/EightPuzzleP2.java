package aima.gui.demo.search;


import aima.core.environment.eightpuzzle.EightPuzzleBoard;

import aima.core.environment.eightpuzzle.EightPuzzleFunctionFactory;
import aima.core.environment.eightpuzzle.EightPuzzleGoalTest;
import aima.core.environment.eightpuzzle.ManhattanHeuristicFunction;
import aima.core.environment.eightpuzzle.MisplacedTilleHeuristicFunction;
import aima.core.search.framework.GraphSearch;
import aima.core.search.framework.Problem;
import aima.core.search.framework.SearchAgent;
import aima.core.search.informed.AStarSearch;
import aima.core.search.uninformed.IterativeDeepeningSearch;
import aima.core.search.uninformed.BreadthFirstSearch;
import aima.core.util.math.*;

/**
 * @author Ravi Mohan && Marcos Pérez (820532)
 * 
 */

public class EightPuzzleP2 {
	//static EightPuzzleBoard ini;
	//static EightPuzzleBoard objetivo;
	public static void main(String[] args) {
		String linea = "---------------------------------------------------------------------";
		System.out.format("%s\n",linea);
		System.out.format("||   ||        Nodos Generados      ||                b*           ||\n");
		System.out.format("%s\n",linea);
		System.out.format("||  d|| BFS | IDS | A*h(1) | A*h(2) || BFS | IDS | A*h(1) | A*h(2) ||\n");
		System.out.format("%s\n",linea);
		System.out.format("%s\n",linea);
		
		
		String sinRes = "-----";
		EightPuzzleBoard ini;
		EightPuzzleBoard objetivo;
		Problem problem;
		Integer nodosGenerados;
		for(int j = 2; j < 25; j++)
		{
			int nodosBFS = 0;
			int nodosIDS = 0;
			int nodosA1 = 0;
			int nodosA2 = 0;
			
			double bBFS = 0;
			double bIDS = 0;
			double bA1 = 0;
			double bA2 = 0;
			
			for(int i = 0; i < 100; i++) 
			{
				ini = GenerateInitialEightPuzzleBoard.randomIni();
				System.out.println(ini);
				objetivo = GenerateInitialEightPuzzleBoard.random(j, ini);
				System.out.println(objetivo);
				new EightPuzzleGoalTest(objetivo);
				ManhattanHeuristicFunction J1 = new ManhattanHeuristicFunction(objetivo);
				double distancia = J1.h(objetivo);
				
				
				
				while(distancia != j) {
					//System.out.println(nodosIDS);
					 ini = GenerateInitialEightPuzzleBoard.randomIni();
					 objetivo = GenerateInitialEightPuzzleBoard.random(j, ini);
					
					new EightPuzzleGoalTest(objetivo);
					J1 = new ManhattanHeuristicFunction(objetivo);
					distancia = J1.h(objetivo);
				}
				
				try {
			        problem = new Problem(ini, EightPuzzleFunctionFactory.getActionsFunction(),EightPuzzleFunctionFactory.getResultFunction(),new EightPuzzleGoalTest(objetivo));

			            SearchAgent agent = new SearchAgent(problem, new BreadthFirstSearch(new GraphSearch()));
			        
			            nodosGenerados= ((int)Float.parseFloat(agent.getInstrumentation().getProperty("nodosGenerados")));
			            nodosBFS=nodosBFS + nodosGenerados;
				}catch(Exception e) {
			            e.printStackTrace();
			    }
			            
			            
			    try {
			        if(j<12) {
			            problem = new Problem(ini, EightPuzzleFunctionFactory.getActionsFunction(),EightPuzzleFunctionFactory.getResultFunction(), new EightPuzzleGoalTest(objetivo));

			            SearchAgent agent = new SearchAgent(problem, new IterativeDeepeningSearch());
			            
			            nodosGenerados= ((int)Float.parseFloat(agent.getInstrumentation().getProperty("nodosGenerados")));
			            nodosIDS=nodosIDS + nodosGenerados;
			            }
			    }catch(Exception e) {
			            e.printStackTrace();
			    }
			                    
			            
			    try {
			        problem = new Problem(ini, EightPuzzleFunctionFactory.getActionsFunction(),EightPuzzleFunctionFactory.getResultFunction(), new EightPuzzleGoalTest(objetivo));

			            SearchAgent agent = new SearchAgent(problem, new AStarSearch(new GraphSearch(),new ManhattanHeuristicFunction(objetivo)));            
			            nodosGenerados= ((int)Float.parseFloat(agent.getInstrumentation().getProperty("nodosGenerados")));
			            nodosA1=nodosA1 + nodosGenerados;
			     }catch(Exception e) {
			            e.printStackTrace();
			     }      
			            
			     try {
			        problem = new Problem(ini, EightPuzzleFunctionFactory.getActionsFunction(),EightPuzzleFunctionFactory.getResultFunction(), new EightPuzzleGoalTest(objetivo));

			            SearchAgent agent = new SearchAgent(problem, new AStarSearch(new GraphSearch(),new MisplacedTilleHeuristicFunction(objetivo)));
			            nodosGenerados= ((int)Float.parseFloat(agent.getInstrumentation().getProperty("nodosGenerados")));
			            nodosA2=nodosA2 + nodosGenerados;
			      }catch(Exception e) {
			            e.printStackTrace();
			     }
				
			}
			
			nodosIDS = nodosIDS/100;
			nodosBFS = nodosBFS/100;
			nodosA1 = nodosA1/100;
			nodosA2 = nodosA2/100;
			
			
			bBFS = GFG.bisection(nodosBFS,j); 
			bA1 = GFG.bisection(nodosA1,j);
			bA2 = GFG.bisection(nodosA2,j);
			if(j <= 10)
			{
				bIDS = GFG.bisection(nodosIDS,j);
				System.out.format("%5s %6s %5s %7s %7s %7.2f %7.2f %7.2f %7.2f\n",j,nodosBFS,nodosIDS,nodosA1,nodosA2,bBFS,bIDS,bA1,bA2);
			}
			else
			{
				System.out.format("%5s %6s %5s %7s %7s %7.2f %7s %7.2f %7.2f\n",j,nodosBFS,sinRes,nodosA1,nodosA2,bBFS,sinRes,bA1,bA2);
			}
		}
		
		System.out.format("\n%s\n",linea);
	
	}


}