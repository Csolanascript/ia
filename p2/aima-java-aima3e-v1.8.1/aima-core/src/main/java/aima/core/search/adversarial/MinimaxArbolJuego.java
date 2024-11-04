package aima.core.search.adversarial;

public class MinimaxArbolJuego<V extends Comparable<V>> {

    private int nodosVisitados = 0;

    public V getMinimaxValue(ArboldeJuego<V> nodo) {
        V resultado = minimax(nodo);
        nodo.printArbolExplorado();
        nodosVisitados--;
        System.out.println("Nodos visitados: " + nodosVisitados);
        return resultado;
    }

    private V minimax(ArboldeJuego<V> nodo) {
        if (nodo.esTerminal()) {
            nodosVisitados++;
            nodo.setVisitado();
            return nodo.getValor();
        }

        V valor;
        if (nodo.esMax()) {
            valor = null;
            for (ArboldeJuego<V> hijo : nodo.getHijos()) {
                V valorHijo = minimax(hijo);
                if (valor == null || valorHijo.compareTo(valor) > 0) {
                    valor = valorHijo;
                }
            }
        } else {
            valor = null;
            for (ArboldeJuego<V> hijo : nodo.getHijos()) {
                V valorHijo = minimax(hijo);
                if (valor == null || valorHijo.compareTo(valor) < 0) {
                    valor = valorHijo;
                }
            }
        }
        nodosVisitados++;
        nodo.setValor(valor);
        nodo.setVisitado();
        return valor;
    }
}
