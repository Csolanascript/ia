package aima.core.search.adversarial;

import java.util.Arrays;

public class EjemploArbolJuego {

    public static void main(String[] args) {
        // Crear árbol de ejemplo para Minimax
        ArboldeJuego<Double> raizMinimax = new ArboldeJuego<>(0.0, true); // Asigna un valor inicial
        ArboldeJuego<Double> n1Minimax = new ArboldeJuego<>(3.0, false, Arrays.asList(
                new ArboldeJuego<>(3.0, true),
                new ArboldeJuego<>(12.0, true),
                new ArboldeJuego<>(8.0, true)
        ));
        ArboldeJuego<Double> n2Minimax = new ArboldeJuego<>(2.0, false, Arrays.asList(
                new ArboldeJuego<>(2.0, true),
                new ArboldeJuego<>(4.0, true),
                new ArboldeJuego<>(6.0, true)
        ));
        ArboldeJuego<Double> n3Minimax = new ArboldeJuego<>(2.0, false, Arrays.asList(
                new ArboldeJuego<>(14.0, true),
                new ArboldeJuego<>(5.0, true),
                new ArboldeJuego<>(2.0, true)
        ));
        raizMinimax.agnadeHijo(n1Minimax);
        raizMinimax.agnadeHijo(n2Minimax);
        raizMinimax.agnadeHijo(n3Minimax);

        // Ejecutar Minimax y asignar el resultado a la raíz
        MinimaxArbolJuego<Double> minimax = new MinimaxArbolJuego<>();
        Double valorMinimax = minimax.getMinimaxValue(raizMinimax);
        raizMinimax.setValor(valorMinimax); // Asigna el valor resultante a la raíz
        System.out.println("Valor con MINIMAX: " + valorMinimax);
        System.out.println("-------------------------------");

        // Crear árbol de ejemplo para Alfa-Beta (nuevo árbol)
        ArboldeJuego<Double> raizAlfaBeta = new ArboldeJuego<>(0.0, true); // Asigna un valor inicial
        ArboldeJuego<Double> n1AlfaBeta = new ArboldeJuego<>(3.0, false, Arrays.asList(
                new ArboldeJuego<>(3.0, true),
                new ArboldeJuego<>(12.0, true),
                new ArboldeJuego<>(8.0, true)
        ));
        ArboldeJuego<Double> n2AlfaBeta = new ArboldeJuego<>(2.0, false, Arrays.asList(
                new ArboldeJuego<>(2.0, true),
                new ArboldeJuego<>(4.0, true),
                new ArboldeJuego<>(6.0, true)
        ));
        ArboldeJuego<Double> n3AlfaBeta = new ArboldeJuego<>(2.0, false, Arrays.asList(
                new ArboldeJuego<>(14.0, true),
                new ArboldeJuego<>(5.0, true),
                new ArboldeJuego<>(2.0, true)
        ));
        
        
        
        raizAlfaBeta.agnadeHijo(n1AlfaBeta);
        raizAlfaBeta.agnadeHijo(n2AlfaBeta);
        raizAlfaBeta.agnadeHijo(n3AlfaBeta);
        

        // Ejecutar Alfa-Beta y asignar el resultado a la raíz
        AlfaBetaArbolJuego alfaBeta = new AlfaBetaArbolJuego();
        Double valorAlfaBeta = alfaBeta.alfaBetaSearch(raizAlfaBeta);
        raizAlfaBeta.setValor(valorAlfaBeta); // Asigna el valor resultante a la raíz
        System.out.println("Valor con poda Alfa Beta: " + valorAlfaBeta);
        System.out.println("-------------------------------");
        
        
        
        
        // Crear árbol de ejemplo para Alfa-Beta (nuevo árbol)
        ArboldeJuego<Double> raizAlfaBeta2 = new ArboldeJuego<>(0.0, true); // Asigna un valor inicial
        ArboldeJuego<Double> n1AlfaBeta2 = new ArboldeJuego<>(3.0, false, Arrays.asList(
                new ArboldeJuego<>(10.0, true),
                new ArboldeJuego<>(4.0, true),
                new ArboldeJuego<>(8.0, true)
        ));
        ArboldeJuego<Double> n2AlfaBeta2 = new ArboldeJuego<>(2.0, false, Arrays.asList(
                new ArboldeJuego<>(3.0, true),
                new ArboldeJuego<>(2.0, true),
                new ArboldeJuego<>(5.0, true)
        ));
        ArboldeJuego<Double> n3AlfaBeta2 = new ArboldeJuego<>(2.0, false, Arrays.asList(
                new ArboldeJuego<>(2.0, true),
                new ArboldeJuego<>(7.0, true),
                new ArboldeJuego<>(1.0, true)
        ));
        
        raizAlfaBeta2.agnadeHijo(n1AlfaBeta2);
        raizAlfaBeta2.agnadeHijo(n2AlfaBeta2);
        raizAlfaBeta2.agnadeHijo(n3AlfaBeta2);
        

        // Ejecutar Alfa-Beta y asignar el resultado a la raíz
        AlfaBetaArbolJuego alfaBeta2 = new AlfaBetaArbolJuego();
        Double valorAlfaBeta2 = alfaBeta2.alfaBetaSearch(raizAlfaBeta2);
        raizAlfaBeta2.setValor(valorAlfaBeta2); // Asigna el valor resultante a la raíz
        System.out.println("Valor con poda Alfa Beta2: " + valorAlfaBeta2);
        System.out.println("-------------------------------");
    }
}
