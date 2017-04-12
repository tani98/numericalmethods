/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developerfriends.edu.numericalmethods.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Tani Aguirre
 */
public class FalseRule {

    public FalseRule() {
    }

    Function function;

    private double xi;
    private double xs;
    private int iterations;
    private double error;
    private String fx;
    ObservableList<String> listSolution = FXCollections.observableArrayList();

    public double f(double x) {
        function = new Function(fx);
        return function.eval(x);
    }

    /**
     * Solucion del Metodo de la Regla Falsa
     */
    public void solution() {

        System.out.println("Intervalo : [" + xi + ", " + xs + "]");
        System.out.println("Error : " + error);
        System.out.println("Iteraciones : " + iterations);
        System.out
                .println("------------------------------------------------ \n");

        double Xant = 0;
        double Xact = 0;
        int count = 1;
        double fi = f(xi);
        double fs = f(xs);
        double xr;
        double fr;

        do {
            xr = xs - ((fs * (xi - xs)) / (fi - fs));
            //(fs * xi - fi * xs) / (fs - fi);

            System.out.println("Iteración (" + count + ") : " + xr);
            listSolution.add("Iteración (" + count + ") : " + xr);
            fr = f(xr);

            if (fi * fr > 0) {
                xi = xr;
                fi = xi;
                Xant = xr;
                fs = f(xs);                
                xr = xs - ((fs * (xi - xs)) / (fi - fs));
                Xact = xr;
                fr = f(xr);                
            } else {
                xs = xr;
                fs = f(xs);                
                Xant = xr;
                fi = f(xi);
                xr = xs - ((fs * (xi - xs)) / (fi - fs));
                fr = f(xr);
                Xact = xr;
            }
            count++;
        } while (count <= iterations && StopTest(Xant, Xact));
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
     * @param xi
     * @param xs
     */
    public void setRange(double xi, double xs) {
        this.xi = xi;
        this.xs = xs;
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
     * @param Xant
     * @param Xact
     */
    private boolean StopTest(double Xant, double Xact) {
        //Math.abs(xp / xr - 1) < error
        return Math.abs(Xant - Xact) >= error;
    }

    /**
     * Para mostrar al usuario el número de iteraciones
     *
     * @return listSolution
     */
    public ObservableList<String> getListSolution() {
        return listSolution;
    }

}
