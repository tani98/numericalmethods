package com.crazycode.util;

import org.nfunk.jep.JEP;

/**
 *
 * @author Tani Aguirre
 */
public class Function {

    JEP j = new JEP();

    public Function(String fx) {
        j.addVariable("x", 0);
        j.addStandardConstants();
        j.addStandardFunctions();
        j.addComplex();
        j.parseExpression(fx);
    }
    


    public double eval(double x) {
        double value;
        j.addVariable("x", x);       
        value = j.getValue();
        return value;
    }
    
    public boolean isCorrect(){
        return !j.hasError();
    }


}
