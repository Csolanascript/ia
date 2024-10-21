package aima.core.util.math;


/**
 * @author geeksforgeeks.org
 * 
 * https://www.geeksforgeeks.org/program-for-bisection-method/
 */


//Java program for implementation of Bisection Method
//for solving equations
public class GFG{
 static final float EPSILON = (float)0.01;

 // An example function whose solution is determined using
 // Bisection Method. The function is x^3 - x^2  + 2
 static double func(double x, double N, double d)
 {
	 return ((x*(1-Math.pow(x, d))) / (1.000001-x)) - N;
 }

 // Prints root of func(x) with error of EPSILON
 public static double bisection(double N, double d)
 {
	 // limites del problema
	 double a = 1;
	 double b = 4; 
     if (func(a,N,d) * func(b,N,d) >= 0)
     {
         System.out.println("You have not assumed"
                     + " right a and b");
         return 0;
     }

     double c = a;
     while (Math.abs(b-a) >= EPSILON)
     {
         // Find middle point
         c = (a+b)/2;

         // Check if middle point is root
         if (func(c,N,d) == 0.0)
             break;

         // Decide the side to repeat the steps
         else if (func(c,N,d)*func(a,N,d) < 0)
             b = c;
         else
             a = c;
     }
             //prints value of c upto 4 decimal places
     return c;
 }

 // Driver program to test above function
 public static void main(String[] args)
 {
     // Initial values assumed
     double a =-200, b = 300;
     bisection(a, b);
 }
 // This code is contributed by Nirmal Patel
}