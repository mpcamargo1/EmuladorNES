package com.mpcamargo.emuladornes.gui;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource("/com/mpcamargo/emuladornes/hello-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Emulador NES");
        stage.setScene(scene);
        stage.show();

        iniciarRenderizacao(fxmlLoader.getController());
    }

    private void iniciarRenderizacao(HelloController controller) {

        AnimationTimer animationTimer = new AnimationTimer() {

            @Override
            public void handle(long now) {
               controller.render();
            }
        };

        animationTimer.start();
    }

    public static void main(String[] args) {
        launch();
    }
}