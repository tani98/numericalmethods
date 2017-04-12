package com.developerfriends.edu.numericalmethods.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    private int iterations;
    private double error;
    private String fx;
    ObservableList<String> listSolution = FXCollections.observableArrayList();

    private double f(double x) {
        function = new Function(fx);
        return function.eval(x);
    }

    /**
     * Solucion del Metodo de Biseccion
     */
    public void solution() {

        System.out.println("Intervalo : [" + a + ", " + b + "]");
        System.out.println("Error : " + error);
        System.out.println("Iteraciones : " + iterations);
        System.out
                .println("------------------------------------------------ \n");

        double c;
        double fa;
        double fb;
        double fc;
        double Pant = 0;
        double Pact = 0;
        int count = 1;

        do {
            c = (a + b) / 2;

            System.out.println("Iteración (" + count + ") : " + c);
            listSolution.add("Iteración (" + count + ") : " + c);
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
            count++;
        } while (count <= iterations && StopTest(Pant, Pact));
        System.out.println("the end");
    }

    /**
     * Función a ser evaluada
     *
     * @param fx
     */
    public void setFuntion(String fx) {
        this.fx = fx;
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
        this.iterations = iterations;
    }

    /**
     * Definicion del margen de error
     *
     * @param error
     */
    public void setError(double error) {
        this.error = error;
    }

    /**
     * Criterio de parada
     *
     * @param Pant
     * @param Pact
     */
    private boolean StopTest(double Pant, double Pact) {
        return Math.abs(Pant - Pact) >= error;
    }
    
    /**
    *Para mostrar al usuario el número de iteraciones
    * @return listSolution
    */
    public ObservableList<String> getListSolution() {
        return listSolution;
    }

}
