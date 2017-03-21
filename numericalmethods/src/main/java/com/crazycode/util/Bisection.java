package com.crazycode.util;

/**
 *
 * @author Tani Aguirre
 */
public class Bisection {

    public Bisection() {
    }
    
    Function function;

    private double a;
    private double b;
    private int Iterations;
    private double error;

    private double f(double x) {
        return function.eval(x);
    }

    /**
     * Solucion del Metodo de Biseccion
     */
   public void solution() {

        System.out.println("Intervalo : [" + a + ", " + b + "]");
        System.out.println("Error : " + error);
        System.out.println("Iteraciones : " + Iterations);
        System.out
                .println("------------------------------------------------ \n");

        double c;
        double fa;
        double fb;
        double fc;
        double Pant = 0;
        double Pact = 0;
        int iteracion = 1;

        do {
            c = (a + b) / 2;

            System.out.println("Iteracion (" + iteracion + ") : " + c);
            fa = f(a);
            fb = f(b);
            fc = f(c);

            if (fc * fa < 0) {
                b = c;
                fa = f(a);
                Pant = c;
                fb = f(b);
                c = (a + b) / 2;
                Pact = c;
                fc = f(c);
            } else {
                a = c;
                fa = f(a);
                Pant = c;
                fb = f(b);
                c = (a + b) / 2;
                fc = f(c);
                Pact = c;
            }
            iteracion++;
        } while (iteracion <= Iterations && StopTest(Pant, Pact));
        System.out.println("the end");
    }

    /**
     * Definicion del intervalo
     *
     * @param a
     * @param b
     */
    public void setRange(double a, double b) {
        this.a = a;
        this.b = b;
    }

    /**
     * Definicion de las iteraciones
     *
     * @param iterations
     */
    public void setIterations(int iterations) {
        this.Iterations = iterations;
    }

    /**
     * Definicion del margen de error
     * @param error
     */
    public void setError(double error) {
        this.error = error;
    }

    /**
     * Criterio de parada
     */
    private boolean StopTest(double Pant, double Pact) {
        return Math.abs(Pant - Pact)  >= error ;
    }
    
    
}
