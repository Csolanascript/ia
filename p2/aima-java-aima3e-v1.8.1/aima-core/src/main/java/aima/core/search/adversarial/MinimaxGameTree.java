package aima.core.search.adversarial;

public class MinimaxGameTree<V extends Comparable<V>> {

    public V getMinimaxValue(GameTree<V> node) {
        if (node.isTerminal()) {
            node.setvisited();  // Marca como visitado
            return node.getvalue();
        }

        if (node.isMax()) {
            V maxValue = null;
            for (GameTree<V> child : node.getchildren()) {
                V childValue = getMinimaxValue(child);
                if (maxValue == null || childValue.compareTo(maxValue) > 0) {
                    maxValue = childValue;
                }
            }
            node.setvalue(maxValue);  // Asigna el valor máximo al nodo
            node.setvisited();  // Marca como visitado
            return maxValue;
        } else {
            V minValue = null;
            for (GameTree<V> child : node.getchildren()) {
                V childValue = getMinimaxValue(child);
                if (minValue == null || childValue.compareTo(minValue) < 0) {
                    minValue = childValue;
                }
            }
            node.setvalue(minValue);  // Asigna el valor mínimo al nodo
            node.setvisited();  // Marca como visitado
            return minValue;
        }
    }
}
