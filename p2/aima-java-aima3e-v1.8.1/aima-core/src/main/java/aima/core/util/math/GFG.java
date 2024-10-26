package aima.core.util.math;

public class GFG {
    // Definir la tolerancia mínima aceptable
    static final double TOLERANCIA = 0.01;
    static final int MAX_ITERACIONES = 1000; // Se limita el número de iteraciones para evitar ciclos infinitos

    // Función genérica que queremos resolver
    static double evaluarFuncion(double x, double N, double d) {
        return ((x * (1 - Math.pow(x, d))) / (1.000001 - x)) - N;
    }

    // Implementación del método iterativo de búsqueda de raíz
    public static double bisection(double N, double d) {
        // Intervalo inicial de búsqueda
        double extremoIzquierdo = 1;
        double extremoDerecho = 4;

        // Verificación inicial de si la función cambia de signo en el intervalo dado
        double valorIzquierdo = evaluarFuncion(extremoIzquierdo, N, d);
        double valorDerecho = evaluarFuncion(extremoDerecho, N, d);
        
        if (valorIzquierdo * valorDerecho >= 0) {
            System.out.println("No hay cambio de signo en el intervalo proporcionado.");
            return Double.NaN; // Indica que no se encontró una raíz en este intervalo
        }

        // Definir variables adicionales para el proceso iterativo
        double puntoMedio = 0;
        int contadorIteraciones = 0;

        // Se ejecuta un número limitado de iteraciones en lugar de depender solo de la diferencia entre límites
        while (contadorIteraciones < MAX_ITERACIONES) {
            puntoMedio = (extremoIzquierdo + extremoDerecho) / 2;
            double valorMedio = evaluarFuncion(puntoMedio, N, d);

            // Si la función en el punto medio es lo suficientemente pequeña, consideramos que encontramos la raíz
            if (Math.abs(valorMedio) < TOLERANCIA) {
                break; // Se ha alcanzado la solución con la precisión deseada
            }

            // Actualizar los límites según el signo del valor en el punto medio
            if (valorIzquierdo * valorMedio < 0) {
                extremoDerecho = puntoMedio; // La raíz está en el intervalo izquierdo
            } else {
                extremoIzquierdo = puntoMedio; // La raíz está en el intervalo derecho
                valorIzquierdo = valorMedio; // Actualizar el valor en el extremo izquierdo
            }

            contadorIteraciones++;
        }

        if (contadorIteraciones >= MAX_ITERACIONES) {
            System.out.println("Número máximo de iteraciones alcanzado, puede que no se haya convergido a la raíz.");
        }

        return puntoMedio;
    }

    public static void main(String[] args) {
        // Valores de entrada para la función
        double valorObjetivo = 2.5;
        double exponente = 3;

        double resultado = buscarRaiz(valorObjetivo, exponente);
        if (!Double.isNaN(resultado)) {
            System.out.printf("La raíz aproximada es: %.4f\n", resultado);
        } else {
            System.out.println("No se encontró una raíz en el intervalo proporcionado.");
        }
    }
}
