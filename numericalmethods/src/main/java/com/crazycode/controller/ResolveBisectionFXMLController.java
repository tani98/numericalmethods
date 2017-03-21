/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crazycode.controller;

import com.crazycode.util.Bisection;
import com.crazycode.util.Dialog;
import com.crazycode.util.Function;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Tani Aguirre
 */
public class ResolveBisectionFXMLController implements Initializable {

    Function function;
    Bisection bisection = new Bisection();
    Dialog dialog = new Dialog();

    XYChart.Series s1 = new XYChart.Series();
    XYChart.Series s2 = new XYChart.Series();

    @FXML
    private TextField txtFx;
    @FXML
    private LineChart<?, ?> chart;
    @FXML
    private Button btnCalculate;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnCalculate.setDisable(true);
        enableBtn();
    }

    @FXML
    private void calculateFuntion(ActionEvent event) {
        try {
            String fx = txtFx.getText();
            function = new Function(fx);

            if (function.isCorrect()) {
                if (!s1.getData().isEmpty()) {
                    s1.getData().clear();
                }               

                for (int i = 1; i < 10; i++) {
                    s1.getData().add(new XYChart.Data(String.valueOf(i), function.eval(i)));
                }
                chart.getData().add(s1);
                bisection.setError(0.005);
                bisection.setIterations(20);
                bisection.setRange(1, 2);
                bisection.solution();
            } else {
                dialog.ErrorDialog("Función mal escrita");
                clean();
            }

        } catch (IllegalArgumentException ex) {
            System.err.println("Error " + ex.getMessage());
        }
    }

    private void clean() {
        chart.getData().clear();
        txtFx.setText("");
    }

    private void enableBtn() {
        txtFx.textProperty().addListener((observable, oldValue, newValue) -> {
            btnCalculate.setDisable(newValue.trim().isEmpty());
        });
    }
}
