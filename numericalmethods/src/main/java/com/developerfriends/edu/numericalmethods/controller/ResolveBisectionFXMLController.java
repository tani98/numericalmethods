/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developerfriends.edu.numericalmethods.controller;

import com.developerfriends.edu.numericalmethods.util.Bisection;
import com.developerfriends.edu.numericalmethods.util.Dialog;
import com.developerfriends.edu.numericalmethods.util.FalseRule;
import com.developerfriends.edu.numericalmethods.util.Function;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Tani Aguirre
 */
public class ResolveBisectionFXMLController implements Initializable {

    Bisection bisection = new Bisection();
    Dialog dialog = new Dialog();

    Function FunctionFx;
    Function FunctionGx;
    Function FunctionHx;

    XYChart.Series s1 = new XYChart.Series();
    XYChart.Series s2 = new XYChart.Series();

    String fx;
    String gx;
    String hx;

    @FXML
    private TextField txtFx;
    @FXML
    private LineChart<?, ?> chart;
    @FXML
    private TextField txtGx;
    @FXML
    private TextField txtHx;
    @FXML
    private JFXButton btnCalculate;
    @FXML
    private JFXListView<String> listIteration;
    @FXML
    private JFXButton btnRepeat;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnRepeat.setVisible(false);
    }

    @FXML
    private void calculateFuntion(ActionEvent event) {
        try {
            if (!isEmpty()) {
                if (isCorrect()) {
                    makeChart();
                    bisection.setFuntion(fx);
                    bisection.setError(0.005);
                    bisection.setIterations(30);
                    bisection.setRange(1, 2);
                    bisection.solution();

                    listIteration.setItems(bisection.getListSolution());
                    btnCalculate.setDisable(true);
                    btnRepeat.setVisible(true);
                } else {
                    dialog.ErrorDialog("Función mal escrita");
                }
            } else {
                dialog.ErrorDialog("No puede dejar campos vacios");
            }
        } catch (Exception ex) {
            System.err.println("Error " + ex.getMessage());
        }

    }

    @FXML
    private void repeat(ActionEvent event) {
        clean();
        btnCalculate.setDisable(false);
        btnRepeat.setVisible(false);
    }

    private void makeChart() {
        try {
            for (int i = 1; i < 10; i++) {
                s1.getData().add(new XYChart.Data(String.valueOf(i), FunctionGx.eval(i)));

                s2.getData().add(new XYChart.Data(String.valueOf(i), FunctionHx.eval(i)));
            }

            chart.getData().add(s1);
            chart.getData().add(s2);

        } catch (Exception ex) {
            System.err.println("Error " + ex.getMessage());
        }
    }

    private boolean isEmpty() {
        return (txtFx.getText().isEmpty() || txtGx.getText().isEmpty() || txtHx.getText().isEmpty());
    }

    private boolean isCorrect() {
        fx = txtFx.getText();
        gx = txtGx.getText();
        hx = txtHx.getText();

        FunctionFx = new Function(fx);
        FunctionGx = new Function(gx);
        FunctionHx = new Function(hx);

        return (FunctionFx.isCorrect() || FunctionGx.isCorrect() || FunctionHx.isCorrect());
    }

    private void clean() {
        chart.getData().clear();
        listIteration.getItems().clear();
        txtFx.setText("");
        txtGx.setText("");
        txtHx.setText("");
    }

}
