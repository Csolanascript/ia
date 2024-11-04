package aima.core.search.adversarial;

public class AlphaBetaGameTree<V extends Comparable<V>> {

    public V getAlphaBetaValue(GameTree<V> node, V alpha, V beta) {
        if (node.isTerminal()) {
            node.setvisited();  // Marca el nodo terminal como visitado
            return node.getvalue();
        }

        if (node.isMax()) {
            V value = null;
            for (GameTree<V> child : node.getchildren()) {
                V childValue = getAlphaBetaValue(child, alpha, beta);
                if (value == null || childValue.compareTo(value) > 0) {
                    value = childValue;
                }
                if (alpha == null || value.compareTo(alpha) > 0) {
                    alpha = value;
                }
                if (beta != null && value.compareTo(beta) >= 0) {
                    // No marcamos el nodo si fue podado
                    break; // Poda beta
                }
                child.setvisited();  // Marca el nodo como visitado si fue evaluado
            }
            node.setvalue(value);
            node.setvisited();  // Marca el nodo actual como visitado
            return value;
        } else {
            V value = null;
            for (GameTree<V> child : node.getchildren()) {
                V childValue = getAlphaBetaValue(child, alpha, beta);
                if (value == null || childValue.compareTo(value) < 0) {
                    value = childValue;
                }
                if (beta == null || value.compareTo(beta) < 0) {
                    beta = value;
                }
                if (alpha != null && value.compareTo(alpha) <= 0) {
                    // No marcamos el nodo si fue podado
                    break; // Poda alpha
                }
                child.setvisited();  // Marca el nodo como visitado si fue evaluado
            }
            node.setvalue(value);
            node.setvisited();  // Marca el nodo actual como visitado
            return value;
        }
    }
}
