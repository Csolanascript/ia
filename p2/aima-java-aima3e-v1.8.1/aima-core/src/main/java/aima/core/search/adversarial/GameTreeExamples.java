package aima.core.search.adversarial;

public class GameTreeExamples {

    public static void main(String[] args) {
        // Primer ejemplo de árbol
        System.out.println("Primer ejemplo de árbol:");
        GameTree<Double> tree1 = buildExampleTree1();

        // Ejecuta Minimax en el primer ejemplo
        MinimaxGameTree<Double> minimax1 = new MinimaxGameTree<>();
        double minimaxValue1 = minimax1.getMinimaxValue(tree1);
        System.out.println("Value with MINIMAX: " + minimaxValue1);
        tree1.printGameExplored();
        System.out.println("Nodos visitados en Minimax: " + countVisitedNodes(tree1));

        // Ejecuta Alpha-Beta pruning en el primer ejemplo
        AlphaBetaGameTree<Double> alphaBeta1 = new AlphaBetaGameTree<>();
        double alphaBetaValue1 = alphaBeta1.getAlphaBetaValue(tree1, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        System.out.println("Value with Alpha Beta pruning: " + alphaBetaValue1);
        tree1.printGameExplored();
        System.out.println("Nodos visitados en Alpha-Beta pruning: " + countVisitedNodes(tree1));

        // Segundo ejemplo de árbol
        System.out.println("\nSegundo ejemplo de árbol:");
        GameTree<Double> tree2 = buildExampleTree2();

        // Ejecuta Minimax en el segundo ejemplo
        MinimaxGameTree<Double> minimax2 = new MinimaxGameTree<>();
        double minimaxValue2 = minimax2.getMinimaxValue(tree2);
        System.out.println("Value with MINIMAX: " + minimaxValue2);
        tree2.printGameExplored();
        System.out.println("Nodos visitados en Minimax: " + countVisitedNodes(tree2));

        // Ejecuta Alpha-Beta pruning en el segundo ejemplo
        AlphaBetaGameTree<Double> alphaBeta2 = new AlphaBetaGameTree<>();
        double alphaBetaValue2 = alphaBeta2.getAlphaBetaValue(tree2, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        System.out.println("Value with Alpha Beta pruning: " + alphaBetaValue2);
        tree2.printGameExplored();
        System.out.println("Nodos visitados en Alpha-Beta pruning: " + countVisitedNodes(tree2));
    }

    // Primer árbol de ejemplo
    private static GameTree<Double> buildExampleTree1() {
        GameTree<Double> subtree1 = new GameTree<>(null, false);
        subtree1.addchild(new GameTree<>(3.0, true));
        subtree1.addchild(new GameTree<>(12.0, true));
        subtree1.addchild(new GameTree<>(8.0, true));

        GameTree<Double> subtree2 = new GameTree<>(null, false);
        subtree2.addchild(new GameTree<>(2.0, true));
        subtree2.addchild(new GameTree<>(4.0, true));
        subtree2.addchild(new GameTree<>(6.0, true));

        GameTree<Double> subtree3 = new GameTree<>(null, false);
        subtree3.addchild(new GameTree<>(14.0, true));
        subtree3.addchild(new GameTree<>(5.0, true));
        subtree3.addchild(new GameTree<>(2.0, true));

        GameTree<Double> topTree = new GameTree<>(null, true);
        topTree.addchild(subtree1);
        topTree.addchild(subtree2);
        topTree.addchild(subtree3);

        return topTree;
    }

    // Segundo árbol de ejemplo
    private static GameTree<Double> buildExampleTree2() {
        GameTree<Double> subtree1 = new GameTree<>(null, false);
        subtree1.addchild(new GameTree<>(10.0, true));
        subtree1.addchild(new GameTree<>(4.0, true));
        subtree1.addchild(new GameTree<>(8.0, true));

        GameTree<Double> subtree2 = new GameTree<>(null, false);
        subtree2.addchild(new GameTree<>(3.0, true));
        subtree2.addchild(new GameTree<>(6.0, true));
        subtree2.addchild(new GameTree<>(7.0, true));

        GameTree<Double> subtree3 = new GameTree<>(null, false);
        subtree3.addchild(new GameTree<>(14.0, true));
        subtree3.addchild(new GameTree<>(5.0, true));
        subtree3.addchild(new GameTree<>(9.0, true));

        GameTree<Double> topTree = new GameTree<>(null, true);
        topTree.addchild(subtree1);
        topTree.addchild(subtree2);
        topTree.addchild(subtree3);

        return topTree;
    }

    // Método para contar los nodos visitados
    private static int countVisitedNodes(GameTree<?> node) {
        int count = node.getvisited() ? 1 : 0;
        for (GameTree<?> child : node.getchildren()) {
            count += countVisitedNodes(child);
        }
        return count;
    }
}
