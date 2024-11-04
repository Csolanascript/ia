package aima.core.search.adversarial;

public class AlfaBetaArbolJuego {

    private int nodosVisitados = 0;

    public Double alfaBetaSearch(ArboldeJuego<Double> nodo) {
        nodosVisitados = 0; // Reinicia el contador de nodos visitados
        Double resultado;
        if (nodo.esMax()) {
            resultado = maxValor(nodo, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        } else {
            resultado = minValor(nodo, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        }
        nodo.printArbolExplorado(); // Muestra el árbol después de la exploración
        nodosVisitados--;
        System.out.println("Nodos visitados: " + nodosVisitados);
        System.out.println("Resultado de Alfa-Beta: " + resultado);
        return resultado;
    }

    private Double maxValor(ArboldeJuego<Double> nodo, Double alfa, Double beta) {
        nodosVisitados++;  // Incrementa nodos visitados cada vez que se entra en MAX
        nodo.setVisitado();

        if (nodo.esTerminal()) {
            return nodo.getValor();
        }

        Double valor = Double.NEGATIVE_INFINITY;
        for (ArboldeJuego<Double> hijo : nodo.getHijos()) {
            Double minValor = minValor(hijo, alfa, beta);
            valor = Math.max(valor, minValor);

            // Actualizar alfa
            alfa = Math.max(alfa, valor);

            // Verificar la condición de poda
            if (alfa >= beta) {
                return valor; // Poda, no explora más hijos
            }
        }
        return valor;
    }

    private Double minValor(ArboldeJuego<Double> nodo, Double alfa, Double beta) {
        nodosVisitados++;  // Incrementa nodos visitados cada vez que se entra en MIN
        nodo.setVisitado();

        if (nodo.esTerminal()) {
            return nodo.getValor();
        }

        Double valor = Double.POSITIVE_INFINITY;
        for (ArboldeJuego<Double> hijo : nodo.getHijos()) {
            Double maxValor = maxValor(hijo, alfa, beta);
            valor = Math.min(valor, maxValor);

            // Actualizar beta
            beta = Math.min(beta, valor);

            // Verificar la condición de poda
            if (valor <= alfa) {
                return valor; // Poda, no explora más hijos
            }
        }
        return valor;
    }
}
