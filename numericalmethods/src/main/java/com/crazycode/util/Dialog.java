package com.crazycode.util;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

/**
 *
 * @author Tani Aguirre
 */
public class Dialog {

    public Dialog() {
    }
    
     public void ErrorDialog(String ContentText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("");
        alert.setContentText(ContentText);
        alert.initStyle(StageStyle.UTILITY);
        alert.showAndWait();
    }

    public void InformationDialog(String ContentText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setContentText(ContentText);
        alert.initStyle(StageStyle.UTILITY);
        alert.showAndWait();
    }

    public void WarningDialog(String ContentText) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("");
        alert.setContentText(ContentText);
        alert.initStyle(StageStyle.UTILITY);
        alert.showAndWait();
    }
}
