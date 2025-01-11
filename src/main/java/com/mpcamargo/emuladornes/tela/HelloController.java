package com.mpcamargo.emuladornes.tela;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class HelloController {
    @FXML
    private Canvas canvas;

    @FXML
    public void initialize() {

    }

    public void atualizarTela() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setFill(Color.RED);
        gc.fillRect(0, 0, 50,50);
    }

    @FXML
    public void handleExit() {
        System.exit(0);
    }
}